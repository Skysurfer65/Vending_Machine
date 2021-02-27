/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;

import java.util.Scanner;

/**
 *
 * @author Bax Musik
 */
public class Merchandise extends MerchAbstract implements MerchInterface{
    //Attributes
    public String color;
    //Constructor
    public Merchandise(String strTypeOfMerch, String name, String strPackage, double price, String color){
        super(strTypeOfMerch, name, strPackage, price);
        this.color = color;
    }
    //Methods

    @Override
    public void Description() {
        System.out.println("This "+name+" is branded with the \"VendingMachine\" logo.");
        System.out.println("It comes in three colors, the one you've choosen is "+color+".");
        System.out.println("One size fits all with our slick velcro adjustment");
        System.out.println("Our "+name+" comes in a "+strPackage+" which could be used for prolonged storage.");
        System.out.println("50% of item sales price of "+price+" SEK, will go to our local football team.");
    }

    @Override
    public void Buy() {
        System.out.println("It costs "+price+" SEK.");
        System.out.print("If you want this item press the key \"y\" for yes and \"n\" for no: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        if(input.equals("y")){
            MyWallet.shoppingCartType.add(strTypeOfMerch);
            MyWallet.shoppingCartName.add(name);
            MyWallet.shoppingCartPrice.add(price);
            MyWallet.shoppingCart.add(this);
        } 
        
    }

    @Override
    public void Use() {
        System.out.println("\nWhen you get it after checkout bring it out from the "+strPackage+" and put it on right away!");
    }
    
    
}
