/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;

import java.util.Scanner;
import static vending_machine.Drink.debit;

/**
 *
 * @author Bax Musik
 */
public class Food extends MerchAbstract implements MerchInterface{
    //Attributes
    public boolean glutenFree;
    //Constructor
    public Food(String strTypeOfMerch, String name, String strPackage, double price, boolean glutenFree){
        super(strTypeOfMerch, name, strPackage, price);
        this.glutenFree = glutenFree;
    }
    //Methods

    @Override
    public void Description() {
        System.out.println("Our "+name+" is fresh and stored in cool conditions.");
        if(glutenFree)System.out.println("It's glutenfree and suitable for glutenintolerant persons.");
        System.out.println("It comes in an airtight bag containing "+strPackage+" of finest selection "+name+".");
    }

    @Override
    public void Buy() {
        System.out.println("It costs "+price+" SEK.");
        System.out.print("If you want this item press the key \"y\" for yes and \"n\" for no: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        if(input.equals("y"))debit += price;    
    }

    @Override
    public void Use() {
        System.out.println("Eat and smile ;-)");
    }
    
}
