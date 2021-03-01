
package vending_machine;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Richard Fehling
 */
public class Vending_Machine {


    public static void main(String[] args) {
    
        //Fill upp merchList from Inventory and fill upp credit
        Inventory.FillMerchList();
        MyWallet.AddToCredit();
        
        //Start of main loop continue shopping or not
        int input2;
        do {                      
            //Creating dynamic menu with input and select item
            int input1 = Menues.MakeMenuAndSelect();
        
            //Merchandise description and add to cart
            //HeaderDescription from abstract class inherit to all items
            Inventory.merchList.get(input1 - 1).HeaderDescription();
            //Description for object from derived class
            Inventory.DescriptionAndBuy(input1);
        
            //Continue shopping or checkout
            input2 = Menues.ContShoppingOrCheckout();

        } while (input2 == 1);

        //Shopping cart
        MyWallet.FindOutMyDebt();
        MyWallet.CheckOut();
        MyWallet.Balance();
        MyWallet.MoreCreditOrNot();
        MyWallet.Change();
        MyWallet.ByeBye();
        
    }
    
    //GetInput function integer
    public static int GetInput(){
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.next());
        return input;       
    }
        
    //GetInputString function String
    public static String GetInputString(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next().trim(); //Trim away space
        return input;
    }
}
       
      

        

   

