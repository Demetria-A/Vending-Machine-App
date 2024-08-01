package com.techelevator;

import com.techelevator.util.SalesReport;
import com.techelevator.util.TransLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {
    private Map<String, Product> inventory;
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public VendingMachine() {
        inventory = new HashMap<>();
        File inventoryCSV = new File("vendingmachine.csv");
        try(Scanner read = new Scanner(inventoryCSV)) {
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] pieces = line.split("\\|");
                Product product = new Product(
                    pieces[1],
                    Double.parseDouble(pieces[2]),
                    ProductType.fromName(pieces[3])
                );
                assert inventory != null;
                inventory.put(pieces[0],product);
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void displayProducts() {
        List<String> slots = new ArrayList<>();
        slots.addAll(inventory.keySet());
        Collections.sort(slots);
        for (var slot : slots) {
            Product product = inventory.get(slot);
            if (product.isOutOfStock()) {
                System.out.printf("%s - SOLD OUT.\n", product.getName());
            } else {
                System.out.printf("%s - (%s) \n", product.getName(), product.getQuantity());
            }
        }
        System.out.println(); //CR
    }
    public void printPurchaseMenu() {
        List<String> slots = new ArrayList<>();
        slots.addAll(inventory.keySet());
        Collections.sort(slots);
        for (var slot : slots) {
            System.out.printf(
                "%s %s $%.2f \n",
                slot,
                inventory.get(slot).getName(),
                inventory.get(slot).getPrice()
            );

        }
        System.out.println(); //CR
    }

    public double addMoney(double amount) { // returning just to make testable
        balance += amount;
        TransLog.log(String.format("FEED MONEY: $%.2f $%.2f", amount, balance));
        return balance;
    }

    public void purchaseProduct(String selection) {
        if (inventory.containsKey(selection)) {
            Product item = inventory.get(selection);
            if (balance >= item.getPrice()) {
                if (item.getQuantity() > 0) {
                    balance -= item.getPrice();
                    item.purchase();
                    System.out.println(item.getType().getMessage());
                    TransLog.log(
                        String.format(
                            "Purchase: %s %s $%.2f $%.2f",
                            item.getName(),
                            selection,
                            item.getPrice(),
                            balance
                        )
                    );
                } else {
                    System.out.println("SOLD OUT");
                }
            } else {
                System.out.println("Insufficient Funds");
            }
        } else {
            System.out.println("Invalid Item Selection");
        }
    }

    public void dispenseChange() {
        int convBalance = (int) Math.round(balance * 100);
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;

        int dispenseQuarters = convBalance / QUARTER;
        convBalance = convBalance % QUARTER;
        int dispenseDimes = convBalance / DIME;
        convBalance = convBalance % DIME;
        int dispenseNickels = convBalance / NICKEL;


        //  convBalance = convBalance % NICKEL; assert convBalance == 0;
        System.out.printf(
            "Your change is: $%.2f \n Dispensing: %d Quarters %d Dimes %d Nickels\n",
            balance,
            dispenseQuarters,
            dispenseDimes,
            dispenseNickels
        );
        TransLog.log(String.format("GIVE CHANGE: $%.2f $0.00", balance));
        balance = 0;
    }

    public void createSalesReport() {
        double finalSales = 0;
        for (var line : inventory.keySet()) {
            Product product = inventory.get(line);
            int sold = 5 - product.getQuantity();
            finalSales += sold * product.getPrice();
            SalesReport.writeToSalesReport(
                String.format(
                    "%s|%d\n",
                    product.getName(),
                    sold
                )
            );
        }
        SalesReport.writeToSalesReport(String.format("\n**TOTAL SALES** $%.2f",finalSales));
        SalesReport.finalizeSalesReport();

    }
}
