package com.example.demo_cat.entity;

public class CartItem {
    private int productId;
    private String productName;
    private String thumbnail;
    private int qty;
    private double utilPRice;

    public CartItem() {
    }

    public CartItem(int productId, String productName, String thumbnail, int qty, double utilPRice) {
        this.productId = productId;
        this.productName = productName;
        this.thumbnail = thumbnail;
        this.qty = qty;
        this.utilPRice = utilPRice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getQty() {
        return qty;
    }
    public double getTotal() {
        return this.qty*this.utilPRice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUtilPRice() {
        return utilPRice;
    }

    public void setUtilPRice(double utilPRice) {
        this.utilPRice = utilPRice;
    }
}
