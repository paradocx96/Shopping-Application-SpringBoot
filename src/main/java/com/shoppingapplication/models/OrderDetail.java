package com.shoppingapplication.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetail {
    @Id
    private String orderId;
    private String orderDate;
    private String customerName;
    private String customerId;
    private String contactNumber;
    private String permanentAddress;
    private String deliveryAddress;

    public OrderDetail(String orderId, String orderDate, String customerName, String customerId, String contactNumber,
                       String permanentAddress, String deliveryAddress) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerId = customerId;
        this.contactNumber = contactNumber;
        this.permanentAddress = permanentAddress;
        this.deliveryAddress = deliveryAddress;
    }

    public OrderDetail() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}
