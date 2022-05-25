package com.nology;

import java.util.Random;

public class Product {

    private String name;
    private String category;
    private double price;
    private int maxQuantity;
    private int quantity;

    public Product(String name, String category, double price, int maxQuantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.maxQuantity = maxQuantity;
        Random random = new Random();
        this.quantity = random.nextInt(maxQuantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
