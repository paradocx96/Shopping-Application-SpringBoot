package com.shoppingapplication.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapplication.models.ERole;
import com.shoppingapplication.models.Role;
import com.shoppingapplication.models.User;
import com.shoppingapplication.payload.request.UserLoginRequest;
import com.shoppingapplication.payload.request.UserSignupRequest;
import com.shoppingapplication.payload.response.JwtResponse;
import com.shoppingapplication.payload.response.MessageResponse;
import com.shoppingapplication.repositories.RoleRepository;
import com.shoppingapplication.repositories.UserRepository;
import com.shoppingapplication.security.jwt.JwtUtils;
import com.shoppingapplication.security.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JavaMailSender mailSender;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	//@PreAuthorize("hasRole('_SELLER') or hasRole('_BUYER') or hasRole('_ADMIN')")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginRequest loginRequest) {

		//Get user name and password and create new AuthenticationToken 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		//Set above assigned user credentials using Authentication object
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//After that create new JWT Token for that person
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		//Then get authentication principles and set that UserDetailimpl object 
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
		
		//Get getAuthorities and set to List object
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		//This is for check the program display correct values or not
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.getPassword());
		System.out.println(jwt);
		System.out.println(roles.toString());

		//Return JWT response to FrontEnd
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	//@PreAuthorize("hasRole('_SELLER') or hasRole('_BUYER') or hasRole('_ADMIN')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserSignupRequest signUpRequest) throws MessagingException, UnsupportedEncodingException{
		
		//Check whether userName is already taken or not
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			
			//If it is true, return error MSG to FrontEnd
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		//Check whether Email is already use or not
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			
			//If it is true, return error MSG to FrontEnd
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		//This is for check the program display correct values or not
		System.out.println(signUpRequest.getUsername());
		System.out.println(signUpRequest.getContactNo());
		System.out.println(signUpRequest.getEmail());
		System.out.println(signUpRequest.getPassword());
		System.out.println(signUpRequest.getUserType());
		
		// ------------------------------------------------------------------
		
		// Create new Email and send if user is registered success!
		String toAddress = signUpRequest.getEmail();
		String fromAddress = "rhnaeasyshopping@gmail.com";
		String senderName = "RHNA Easy Shopping";
		String subject = "Thank your for registration!";
		String content = "<h4>Dear [[name]], </h4><br>"
				+ "You're account has been successfully registered! <br>"
				+ "Your account is now ready to use."
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">click here to visit!</a></h3><br>"
				+ "Thank you,<br>"
				+ "RHNA Easy Shopping.<br>"
				+ "CEO : Hirush Gimhan</h3><br>";
		
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		
		content = content.replace("[[name]]", signUpRequest.getUsername());
		String verifyURL = "http://localhost:3000/login";
		content = content.replace("[[URL]]", verifyURL);
		helper.setText(content, true);
		
		mailSender.send(message);
		
		System.out.println("Email has been sent");
		
		
		// ------------------------------------------------------------------
		
		
	
		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getContactNo(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getEmail(),
							 signUpRequest.getUserType());
		

		//get user role and store Set variable
		Set<String> checkRoles = signUpRequest.getRole();
		
		//Create new HashSet to store user Roles
		Set<Role> roles = new HashSet<>();

		if (checkRoles == null) {
			
			//Check user is buyer or seller
			if(signUpRequest.getUserType().equals("buyer")) {
				
				//If it is true, Add ROLE_BUYER to that user
				Role buyerRole = roleRepository.findByName(ERole.ROLE_BUYER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(buyerRole);
				
			}else {
				
				//If it is false, Add ROLE_SELLER to that user
				Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(sellerRole);
				
			}
			
		} 
		
		//set all roles to user object
		user.setRoles(roles);
		
		//Save all user details into the database
		userRepository.save(user);
		
		
		//return success MSG to frontEnd user is registered successfully
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
