package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        User user = new User();
        Scanner input = new Scanner(System.in);
        int selection;
        do {
            menu();
            selection = input.nextInt();
            input.nextLine();// Clears input
            if (selection == 1) {// Display inventory
                System.out.println("Current Inventory:");
                inventory.displayInventory();
            }
            else if (selection == 2) {// Add inventory
                System.out.println("Enter the name of the product:");
                String product = input.nextLine();

                System.out.println("Enter the price of the product:");
                String price = input.nextLine();

                System.out.println("Enter a brief description of the product:");
                String description = input.nextLine();

                inventory.addInventory(product,price,description,user.getName());
            }
            else if (selection == 3) {// Delete inventory
                do {
                    //inventory.displayInventoryWithNumbers();
                    inventory.displayInventory();
                    System.out.println("What would like to Remove(Example :1)?(Enter 0 to exit menu)");
                    System.out.print(":");
                    while (!input.hasNextInt()) {// checking to see if selection is an int, If not it loops until it is an int
                        System.out.println("Please enter a real number that is on the menu");
                        System.out.print(":");
                        input.next();
                    }
                    selection = input.nextInt();
                } while (selection > 0 && selection < inventory.getSizeOfInventory());// looping until selection is greater than 0 and less than the size of inventory
                if (selection != 0) {// if selection is not equal to 0 selected inventory is removed
                    inventory.removeInventory(selection - 1);
                }
            }
            else if (selection == 4) {// buy inventory
                do {
                    //inventory.displayInventoryWithNumbers();
                    inventory.displayInventory();
                    System.out.println("What would like to buy?(Enter 0 to exit menu)");
                    while (!input.hasNextInt()) {// checking to see if selection is an int
                        System.out.println("Please enter a real number that is on the menu");
                        input.next();
                    }
                    selection = input.nextInt();
                } while (selection > 0 && selection < inventory.getSizeOfInventory());// looping until selection is greater then 0 and less than the size of inventory
                if (selection != 0) {// if selection is not equal to 0 selected inventory is sold
                    inventory.sell(selection - 1, user.getName());
                }
            }
            else if (selection == 5) {// display sold
                inventory.displaySoldLog();
            }
            else if (selection == 6) {// display activity
                inventory.displayActivityLog();
            }
            else if (selection == 0) {
                System.out.println("Thank you for using THE SHOPPING APP");
                break;
            }
            else {
                System.out.println("Invalid input please enter in a valid number");
            }
        } while (selection != 0);// while the selection is not 0 the program loops


    }

    public static void menu() {
        //System.out.println("W͔͈ͭ͗E̗̤͔͕ͬͧ͐L͍͔͇̓ͧ̚C̹͕̺̥̪͊Ò͓̦̭ͯM̤͎̬̘̦ͪ͐E̱͔̦ͩ");

        System.out.println("");
        System.out.println("Welcome");
        System.out.println("(1)Display Current Inventory");
        System.out.println("(2)Add Inventory");
        System.out.println("(3)Delete Inventory");
        System.out.println("(4)Purchase From Inventory");
        System.out.println("(5)Display Sold Inventory");
        System.out.println("(6)Display Activity");
        System.out.println("(0)Exit");
        System.out.println("Please Enter Your Selection (Example :1)");
        System.out.print(":");
    }

}

