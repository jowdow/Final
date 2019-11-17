package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Inventory {
    private static ArrayList<ArrayList<String>> inventoryMatrix= new ArrayList<ArrayList<String>>();// static to access throughout class
    private static ArrayList<String> activityLog=new ArrayList<String>();
    private static ArrayList<String> soldLog=new ArrayList<String>();
    private static Date dateOfAction;

    Inventory(){// Default constructor
    }

    public void addInventory(String product,String price, String description, String seller){
        // You must make the row an ArrayList before appending new row into m
        ArrayList<String> newProduct= new ArrayList<String>(Arrays.asList(product,price,seller,description));
        inventoryMatrix.add(newProduct);
        dateOfAction=new Date();
        activityLog.add( product+" added by "+seller+" with a price of $"+price+" on "+dateOfAction.toString());
    }

    public static void removeInventory(int productNumber){
        //ArrayList<String> var=ArrayList<String>();
        // var.remove(index);
        String[] temp= inventoryMatrix.get(productNumber).toArray(new String[0]);
        inventoryMatrix.remove(productNumber);
        dateOfAction=new Date();
        activityLog.add( temp[0]+" removed  on "+dateOfAction.toString());
    }// mike

    public static void displayInventory(){
        System.out.println("Product        Price    Seller         Description");
        for(int index=0;index<inventoryMatrix.size();index++){
            String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            System.out.printf("%-15s",temp[0]);//Prints product
            System.out.printf("%-9s",temp[1]);//Prints price
            System.out.printf("%-15s",temp[2]);//Prints seller
            System.out.printf("%-30s",temp[3]);//Prints description
            //System.out.println(inventoryMatrix.get(index));
        }
        System.out.println("");// Making space between menu and inventory display
    }

    public static void displayInventoryWithNumbers(){
        // This will have numbers in front of inventory for selection
    }// mike

    public static int getSizeOfInventory(){
        return inventoryMatrix.size();
    }

    public static void sell(int productNumber,String name){
        String[] temp= inventoryMatrix.get(productNumber).toArray(new String[0]);// Getting array from arraylist to get info for log

        inventoryMatrix.remove(productNumber);

        dateOfAction=new Date();

        activityLog.add(temp[0]+" bought by "+name+" with a price of $"+temp[1]+" on "+dateOfAction.toString());// Logging Actions
        soldLog.add(temp[0]+" bought by "+name+" with a price of $"+temp[1]+" on "+dateOfAction.toString());

    }

    public static boolean searchInventory(String product){
        for(int index=0;index<inventoryMatrix.size();index++){
            String[] temp= inventoryMatrix.get(index).toArray(new String[0]);
            if(temp[index]==product){
                return true;
            }
        }
        return false;
    }

    public static void displayActivityLog(){
        for(int index=0;index<activityLog.size();index++){
            System.out.println(activityLog.get(index));
        }
    }

    public static void displaySoldLog(){
        for(int index=0;index<soldLog.size();index++){
            System.out.println(soldLog.get(index));
        }
    }
}
