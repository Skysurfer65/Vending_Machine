/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;

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
       
    }

    @Override
    public void Use() {
        if(name.equals("Snacks"))System.out.println("Our snacks corresponds to food regulations and are suitable from 3 years and up.");
        else System.out.println("Our selection of sandwiches are changed two times a week and should always \n"
                + "have at least a week due date on purchase. Should be stored cool and out of direct sunlight.");
    }
    
}
