package com.shoppingapplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapplication.models.ERole;
import com.shoppingapplication.models.Role;


//created new RoleRepository to find out user role in the database
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
