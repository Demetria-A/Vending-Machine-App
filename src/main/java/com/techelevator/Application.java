package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class Application {

	public static void printGreeting() {
		System.out.println("-------------------------------------");
		System.out.println("Welcome to the Vendo-Matic!");
		System.out.println("-------------------------------------");
	}
	public static void main(String[] args) {
		VendingMachine vendo = new VendingMachine();
		Scanner userInput = new Scanner(System.in);
		Menu mainMenu = new Menu(List.of("Display Vending Machine Items", "Purchase", "Exit"), "Main Menu: Please select an option ");
		Menu purchaseMenu = new Menu(List.of("Feed Money", "Select Purchase", "Finish Transaction"), "Purchase Menu: Please select an option");


		printGreeting();
		int mainOption = 0;

		while(mainOption != 3){
			mainMenu.print();;
			try {
				mainOption = Integer.parseInt(userInput.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Please Enter A Number\n");
				continue;
			}
			switch (mainOption) {
				case 1 -> {
					System.out.println();
					vendo.displayProducts();
				}

				case 2 -> {
                    System.out.println();
					int purchaseOption = 0;
					while(purchaseOption != 3) {
						System.out.printf("Current Money Provided: $%.2f\n\n", vendo.getBalance());
						purchaseMenu.print();
						try {
							purchaseOption = Integer.parseInt(userInput.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("Please Enter A Number\n");
							continue;
						}
						switch (purchaseOption) {
							case 1 -> {
								boolean done = false;
								int amount = 0;
								while (!done) {
									System.out.print("\nAmount to add: ");
									try {
										amount = Integer.parseInt(userInput.nextLine());
									} catch (NumberFormatException e) {
										System.out.println("Please enter an amount as a whole number");
										continue;
									}
									done = true;
								}
								vendo.addMoney(amount);


							}
							case 2 -> {
								vendo.printPurchaseMenu();
								String itemSelect = userInput.nextLine();
								vendo.purchaseProduct(itemSelect);
							}
							case 3 -> {
								System.out.println("Thank you for your purchase(s)!\n");
								vendo.dispenseChange();
							}

							default -> System.out.println("Please select a valid option:\n ");
						}
					}

                }
                case 3 -> {
					System.out.println("Have a great day!");
					userInput.close();
				}
				case 4 -> vendo.createSalesReport();
				default -> System.out.println("Please select a valid option: \n");
			}
		}
	}
}
