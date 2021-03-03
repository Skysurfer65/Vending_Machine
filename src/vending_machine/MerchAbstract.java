
package vending_machine;

/**
 *
 * @author Richard Fehling
 */
abstract public class MerchAbstract {
    //Attributs
    public final String strTypeOfMerch;
    public final String name;
    public final String strPackage;
    public final double price;
    
    
    //Constructor
    public MerchAbstract(String strTypeOfMerch, String name, String strPackage, double price){
        this.strTypeOfMerch = strTypeOfMerch;
        this.name = name;
        this.strPackage = strPackage;
        this.price = price;
    }
    
    //Methods
    //Generic description for all class objects that inherit this abstract class
    public void HeaderDescription() {
        System.out.println("Congratulations!\n"+name+" is one of our finest selections of "+strTypeOfMerch);
    }
    /*
    //Generic price information for all class objects that inherit this abstract class
    public void displayPrice() {
        System.out.println("One item costs "+price+" SEK.");
    }
    */
}
