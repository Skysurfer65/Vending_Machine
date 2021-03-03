
package vending_machine;

import java.text.DecimalFormat;

/**
 *
 * @author Richard Fehling
 */
public class Merchandise extends MerchAbstract implements MerchInterface{
    //Attributes
    private final String color;
    private boolean yes;//Boolean for purchase
    
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
        //DecimalFormat to show price nicely with two digits
        DecimalFormat df = new DecimalFormat("#.00");
        //Boolean set
        yes = false;
        System.out.println("It costs "+df.format(price)+" SEK.");
        System.out.print("If you want this item press the key \"y\" for yes and \"n\" for no: ");
        //Analyze input string if purchase or not
        String input = Vending_Machine.GetInputString();
        if((input.equals("y")) || (input.equals("Y"))){
            MyWallet.shoppingCart.add(this);
            yes = true;
        } 
        
    }

    @Override
    public void Use() {
        //If purchase println
        if(yes)System.out.println("\nIf your credit is good, you'll soon bring it out from the "+strPackage+" and put it on!");
    }    
}
