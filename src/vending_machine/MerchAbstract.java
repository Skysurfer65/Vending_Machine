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
abstract public class MerchAbstract {
    //Attributs
    public String strTypeOfMerch;
    public String name;
    public String strPackage;
    public double price;
    
    
    //Constructor
    public MerchAbstract(String strTypeOfMerch, String name, String strPackage, double price){
        this.strTypeOfMerch = strTypeOfMerch;
        this.name = name;
        this.strPackage = strPackage;
        this.price = price;
    }
    //Methods
    public void HeaderDescription() {
        System.out.println("Congratulations!\n"+name+" is one of our finest selections of "+strTypeOfMerch);
    }
    public void displayPrice() {
        System.out.println("One item costs "+price+" SEK.");
    }
    
}
