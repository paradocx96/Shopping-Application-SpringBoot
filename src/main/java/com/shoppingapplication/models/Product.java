package com.shoppingapplication.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String title;
    private double sellPrice;
    private double price; // number | null;
    private String image;
    private String categoryType;
    private int stockQty;

    public Product(String id, String title, double sellPrice, double price, String image, String categoryType, int stockQty) {
        this.id = id;
        this.title = title;
        this.sellPrice = sellPrice;
        this.price = price;
        this.image = image;
        this.categoryType = categoryType;
        this.stockQty = stockQty;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String cType) {
        this.categoryType = cType;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sellPrice=" + sellPrice +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", stockQty=" + stockQty +
                '}';
    }
}
