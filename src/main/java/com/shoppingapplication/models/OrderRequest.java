package com.shoppingapplication.models;

import java.util.Arrays;

/*This class is not use for create tables.*/
public class OrderRequest {
    private OrderDetail orderDetail;
    private OrderItem[]  orderItems;

    public OrderRequest(OrderDetail orderDetail, OrderItem[] orderItems) {
        this.orderDetail = orderDetail;
        this.orderItems = orderItems;
    }

    public OrderRequest(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderDetail=" + orderDetail +
                ", orderItem=" + Arrays.toString(orderItems) +
                '}';
    }
}
