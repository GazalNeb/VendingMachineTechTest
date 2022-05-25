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
            if (this.products.get(i).getQuantity() == 0) {
                System.out.println("product: "
                        + this.products.get(i).getName()
                        + ", category: " + this.products.get(i).getCategory()
                        + ", price: £" + this.products.get(i).getPrice() + ", Out of Stock");
            } else {
                System.out.println("product: "
                        + this.products.get(i).getName()
                        + ", category: " + this.products.get(i).getCategory()
                        + ", price: £" + this.products.get(i).getPrice() + ", Available: "
                        + this.products.get(i).getQuantity());
            }
        }
    }

    @Override
    public void buy() {
        boolean productsExist;
        do {
            displayProducts();
            System.out.println("Please enter the name of the product to buy");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            System.out.println("Please enter the quantity");
            int quantity = scanner.nextInt();
            double amountToPay;
            for (int i = 0; i < products.size(); i++) {
                if (name.toLowerCase().equals(this.products.get(i).getName().toLowerCase())) {
                    if (this.products.get(i).getQuantity() == 0) {
                        System.out.println("Sorry this item is out of stock");
                    } else {
                        amountToPay = this.products.get(i).getPrice() * quantity;
                        System.out.println("Please pay £" + amountToPay);
                        double amountPaid = scanner.nextDouble();
                        double amountToReturn = amountPaid - amountToPay;
                        if (amountToReturn < 0) {
                            System.out.println("Insufficient payment made");
                        } else {
                            System.out.println("product: "
                                    + this.products.get(i).getName()
                                    + ", category: " + this.products.get(i).getCategory()
                                    + ", price: £" + this.products.get(i).getPrice());
                            System.out.println("Your change is: " + amountToReturn);
                        }
                        this.products.get(i).setQuantity(this.products.get(i).getQuantity() - quantity);
                        System.out.println("The availability of this product now is " + this.products.get(i).getQuantity());
                    }
                }
            }
            productsExist = false;
            for (int i = 0; i < products.size(); i++) {
              if(this.products.get(i).getQuantity() != 0) {
                  productsExist = true;
              }
            }
        } while(productsExist == true);

    }

    @Override
    public void refill() {

    }

    @Override
    public void stock() {

    }

    public static void main(String[] args) {
      VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.buy();

    }
}
