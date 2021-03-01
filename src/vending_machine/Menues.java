
package vending_machine;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Richard Fehling
 */
public class Menues {
    //MakeMenuAndSelect method
    public static int MakeMenuAndSelect(){
        int input = 0;
        boolean wrongNumber = false;
        do {               
            if(wrongNumber)System.out.println("Enter CORRECT number."); //Error if not a valid number or Exception
            wrongNumber = false; //Setting boolean for first selection of item
            System.out.println("\nVending Machine");
            System.out.println("_________________\n");
           
            //Make dynamic selection menu
            MakeMerchMenu(Inventory.merchList);
            
            //Choice one item for description and purchase
            System.out.print("Select one option for further details: ");
                try {             
                    input = Vending_Machine.GetInput(); //Calling input function
                    System.out.println(""); //Just for cosmetics
                    if(1 > input || input > Inventory.merchList.size())wrongNumber = true;
                }
                catch(Exception e){
                System.out.println("Enter a numeric value, try again"); //Error Exception
                wrongNumber = true;
                }           
        } while (wrongNumber); 
        return input;
    }
    
    //MakeMerchMenu method dynamic menu of merchList 
    public static void MakeMerchMenu(ArrayList merchList){
    DecimalFormat df = new DecimalFormat("#.00");
    int n = 1;
    for (MerchAbstract i : Inventory.merchList) {
        System.out.println( n +" "+i.name+"\t\t\t"+df.format(i.price)+" SEK.");
        n++;}           
    }
    
    //ContShoppingOrCheckout method
    public static int ContShoppingOrCheckout(){
    int input = 0;
    boolean wrongNumber = false;
    System.out.println("\n1 Continue shopping\n2 Check-out to collect items");       
    do {         
        if(wrongNumber)System.out.println("Enter CORRECT number."); //Error if not a valid number or Exception
        wrongNumber = false;
        try {
            System.out.print("Make your choice: ");
            input = Vending_Machine.GetInput();
            System.out.println("");
            if(1 > input || input > 2)wrongNumber = true;
        }
        catch(Exception e){
            System.out.println("Enter a numeric value, try again"); //Error Exception
            wrongNumber = true;
        }           
        } while (wrongNumber); 
        return input;
    }
}
