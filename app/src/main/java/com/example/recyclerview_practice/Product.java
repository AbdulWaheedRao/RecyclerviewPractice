package com.example.recyclerview_practice;

public class Product {
    private String title;
    private double price;
    private int imageResourceId;

    public Product() {
    }

    public Product(String title, double price, int imageResourceId) {
        this.title = title;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}

