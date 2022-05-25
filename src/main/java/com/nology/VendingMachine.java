package com.nology;

import java.util.*;

public class VendingMachine implements IVendingMachine {

    private List<Product> products = new ArrayList<>();

    public VendingMachine() {
        addProducts();
    }

    private void addProducts() {
        this.products.add(new Product("Coke", "Drinks", 1.5,15));
        this.products.add(new Product("Snickers", "Chocolate bars", 1.7, 20));
        this.products.add(new Product("Walkers", "Crisps", 1, 15));
        this.products.add(new Product("Coco puffs", "cereal bars", 1.5, 10));
        this.products.add(new Product("Sprite", "Drinks", 1.2, 10));
        this.products.add(new Product("Lays", "Crisps", 1.2, 15));
        this.products.add(new Product("Cadbury", "Chocolate bars", 1, 15));

    }

    private void displayProducts() {

        Comparator<Product> compareByCategory =
                (Product o1, Product o2) -> {
                    int value1 = o1.getCategory().compareTo(o2.getCategory());
                    if (value1 == 0) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return value1;
                    }
                };

        Collections.sort(products, compareByCategory);

        for (int i = 0; i < this.products.size(); i++) {
            System.out.println("product: " + this.products.get(i).getName() + ", category: " + this.products.get(i).getCategory() + ", price: £" + this.products.get(i).getPrice() + ", Available: " + this.products.get(i).getQuantity());
        }
    }

    @Override
    public void buy(Product product) {

    }

    @Override
    public void refill(Product product) {

    }

    @Override
    public void stock() {

    }

    public static void main(String[] args) {
      VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.displayProducts();

    }
}
