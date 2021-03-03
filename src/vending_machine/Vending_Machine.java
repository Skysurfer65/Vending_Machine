
package vending_machine;
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
        int input;
        do {                      
            //Creating dynamic menu with select item input as return
            int input1 = Menues.MakeMenuAndSelect();
        
            //Merchandise description and add to cart
            //HeaderDescription from abstract class inherit to all items
            Inventory.merchList.get(input1 - 1).HeaderDescription();
            //Description for object from derived class
            Inventory.DescriptionAndBuy(input1);
        
            //Continue shopping or checkout
            input = Menues.ContShoppingOrCheckout();

        } while (input == 1);//Condition for main loop continue shopping or not

        //Shopping cart checkout
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
        int input = Integer.parseInt(scan.next());//Parse to int to safeguard exception handling
        return input;
    }
        
    //GetInputString function String
    public static String GetInputString(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next().trim(); //Trim away space
        return input;
    }
}
       
      

        

   

