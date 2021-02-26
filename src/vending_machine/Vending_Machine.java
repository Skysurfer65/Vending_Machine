
package vending_machine;
import java.util.ArrayList;
import java.util.Scanner;


public class Vending_Machine {


    public static void main(String[] args) {
    
        //Fill upp merchList from Inventory
        Inventory.FillMerchList();
        
        //Creating dynamic menu with input 
        int input = 0;
        do {            
            boolean wrongNumber = false; //Setting boolean for continue shopping     
        do {           
            if(wrongNumber)System.out.println("Enter CORRECT number."); //Error if not a valid number or Exception
            wrongNumber = false; //Setting boolean for first selection of item
            System.out.println("Vending Machine");
            System.out.println("_________________");
           
            //Make selection menu
            MakeMenu(Inventory.merchList);
            
            //Choice one item for description and purchase
            System.out.print("Select one option for further details: ");
            try {             
                input = GetInput(); //Calling input function
                System.out.println(""); //Just for cosmetics
                if(1 > input || input > Inventory.merchList.size())wrongNumber = true;
            }
            catch(Exception e){
            System.out.println("Enter a numeric value, try again"); //Error Exception
            wrongNumber = true;
            }           
        } while (wrongNumber);
        
        
        //Merchandise description and add to cart
        Inventory.merchList.get(input - 1).HeaderDescription(); //Header from abstract class inherit to all items
        Inventory.DescriptionAndBuy(input);
        
 
        //Continue shopping or checkout      
        System.out.println("\n1 Continue shopping\n2 Check-out to collect items");
        
        do {
            
            if(wrongNumber)System.out.println("Enter CORRECT number."); //Error if not a valid number or Exception
            wrongNumber = false;
            try {
                System.out.print("Make your choice: ");
                input = GetInput();
                System.out.println("");
                if(1 > input || input > 2)wrongNumber = true;
            }
            catch(Exception e){
            System.out.println("Enter a numeric value, try again"); //Error Exception
            wrongNumber = true;
            }           
        } while (wrongNumber);           
        } while (input == 1);

        //Shopping cart
        //System.out.println("Total cost of ordered items: "+MyWallet.myDebit+" SEK.");
        MyWallet.Balance();
       
        
    }
        //Input function integer
        public static int GetInput(){
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.next());
        return input;       
        }

        public static void MakeMenu(ArrayList merchList){
            int n = 1;
            for (MerchAbstract i : Inventory.merchList) {
                System.out.println( n +" "+ i.name);
                n++;}           
        }
              
}
       
      

        

   

