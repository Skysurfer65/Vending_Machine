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
public class Drinks extends MerchAbstract implements MerchInterface{
    //Attributes
    public String strStillOrSparkling;
   
    
    
    //Constructor
    public Drinks(String strTypeOfMerch, String name, String strPackage, double price, String strStillOrSparkling){
        super(strTypeOfMerch, name, strPackage, price);
        this.strStillOrSparkling = strStillOrSparkling;
    }
    //Methods

    @Override
    public void Description() {
        System.out.println(name+" is a "+strStillOrSparkling+" beverage that will be delivered cooled.");
        System.out.println("It comes in a "+strPackage+".");
    }

    @Override
    public void Buy() {
        System.out.print("If you want this item press the key \"y\" for yes and \"n\" for no: ");
    }

    @Override
    public void Use() {
        System.out.println("This drink should preferable be enjoyed chilled.");
    }
    
}
