package com.techelevator;

public class Product {
    private String name;
    private double price;
    private ProductType type;
    private int quantity;


    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f (%d)",name, price, quantity);
    }

    public int purchase() {  // returning int only allows for testing the method. Not used in code
        if (quantity > 0) {
            quantity -= 1;
        }
        return quantity;
    }

    public boolean isOutOfStock() {
        return quantity == 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

}
