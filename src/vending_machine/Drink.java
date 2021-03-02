
package vending_machine;

import java.text.DecimalFormat;

/**
 *
 * @author Richard Fehling
 */
public class Drink extends MerchAbstract implements MerchInterface{
    //Attributes
    public String strStillOrSparkling;
    public boolean yes;
    //public static double debit;
   
    
    
    //Constructor
    public Drink(String strTypeOfMerch, String name, String strPackage, double price, String strStillOrSparkling){
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
        DecimalFormat df = new DecimalFormat("#.00");
        yes = false;
        System.out.println("It costs "+df.format(price)+" SEK.");
        System.out.print("If you want this item press the key \"y\" for yes and \"n\" for no: "); 
        String input = Vending_Machine.GetInputString();
        if((input.equals("y")) || (input.equals("Y"))){
            MyWallet.shoppingCart.add(this);
            yes = true;
        } else System.out.println("No purchase, enter only letter \"y\" for purchase.");
    }

    @Override
    public void Use() {
        if(yes)System.out.println("\nIf your credit is good, you'll soon be drinking your "+name+"!");      
    }    
}
