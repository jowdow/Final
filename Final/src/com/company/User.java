package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private ArrayList<String> cart= new ArrayList<String>();
    private String nameOfUser;

    User(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Name of User:");
        this.nameOfUser=input.nextLine();
    }

    public void addCart(String product){
        cart.add(product);
    }

    public void removeCart(String product){
        // Find where the product is and remove
        // var.remove(index)
    }

    public void displayCart(){
        for(int index=0;index<cart.size();index++){
            System.out.println(cart.get(index));
        }
    }

    public String getName(){
        return this.nameOfUser;
    }

    public void setName(String name){
        this.nameOfUser=name;
    }

}
