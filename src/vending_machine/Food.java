
package vending_machine;

import java.text.DecimalFormat;

/**
 *
 * @author Richard Fehling
 */
public class Food extends MerchAbstract implements MerchInterface{
    //Attributes
    private final boolean glutenFree;
    private boolean yes;//Boolean for purchase
    
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
        if(yes)System.out.println("\nIf your credit is good, you'll soon eat your "+name+" and smile!");
    }    
}
