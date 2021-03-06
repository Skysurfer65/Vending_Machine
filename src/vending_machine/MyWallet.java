
package vending_machine;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Richard Fehling
 */
public class MyWallet {
    //Class member variables all set to private static
    private static double myCredit = 0;
    private static double myDebit = 0;
    private static double balance;
    private static int credReturn;
    //Hardcoded value of users wallet, here 10 coins/bills of all values
    private static int valueCoin1 = 10;
    private static int valueCoin5 = 50;
    private static int valueCoin10 = 100;
    private static int valueBill20 = 200;
    private static int valueBill50 = 500;
    private static int valueBill100 = 1000;

    //Create shoppingCart ArrayLists
    static ArrayList<MerchAbstract> shoppingCart = new ArrayList<>();
    

    //Methods
    static void AddToCredit(){
        boolean wrongNumber;//Boolean for wrong entry and also enter more money
        do {            
            wrongNumber = true;
            //Menu
            System.out.println("\nVending Machine");
            System.out.println("_________________");
            System.out.println("\nPut money in the machine: ");
            System.out.println("1 You have 1 SEK coins to a value of "+valueCoin1+" SEK.");
            System.out.println("2 You have 5 SEK coins to a value of "+valueCoin5+" SEK.");
            System.out.println("3 You have 10 SEK coins to a value of "+valueCoin10+" SEK.");
            System.out.println("4 You have 20 SEK bills to a value of "+valueBill20+" SEK.");
            System.out.println("5 You have 50 SEK bills to a value of "+valueBill50+" SEK.");
            System.out.println("6 You have 100 SEK bills to a value of "+valueBill100+" SEK.");
            System.out.println("7 EXIT to select items or finish checkout.");
            System.out.println("Your current credit: "+myCredit);
            System.out.print("Select a number to add to yor credit: ");
            try {
                //Input switchcase
                int input = Vending_Machine.GetInput();
                switch(input){
                    case 1:
                        if(valueCoin1 > 0){
                        myCredit += 1;
                        valueCoin1 -= 1;    
                        }                     
                        break;
                    case 2:
                        if(valueCoin5 >= 5){
                        myCredit += 5;
                        valueCoin5 -= 5;    
                        }                       
                        break;
                    case 3:
                        if(valueCoin10 >= 10){
                        myCredit += 10;
                        valueCoin10 -= 10;    
                        }                 
                        break;
                    case 4:
                        if(valueBill20 >= 20){
                        myCredit += 20;
                        valueBill20 -= 20;     
                        }
                        break;
                    case 5:
                        if(valueBill50 >= 50){
                        myCredit += 50;
                        valueBill50 -= 50;     
                        }
                        break;
                    case 6:
                        if(valueBill100 >= 100){
                        myCredit += 100;
                        valueBill100 -= 100;     
                        }
                        break;
                    case 7:
                        wrongNumber = false;//Breaks out of switchcase if selected to EXIT
                        break;
                    default:
                        wrongNumber = true;//Wrong number return to menu in this method
                        break;
                }
                              
            } catch (Exception e) {
                wrongNumber = true;//Exception handling return to menu in this method
            }            
        } while (wrongNumber);//Loopconditions wrong numeric value, exception or user don't select to exit 
    }
    
    static void FindOutMyDebt(){
        //Now find out myDebit
        for (MerchAbstract price : shoppingCart) {
            myDebit += price.price;        
        }        
    }
      
    static void CheckOut(){
        //DecimalFormat to show price nicely with two digits
        DecimalFormat df = new DecimalFormat("0.00");
        //Display items in shopping cart or if it's empty
        if(!shoppingCart.isEmpty()){
            System.out.println("\nYou've ordered the following item/items:");
            for (MerchAbstract name : shoppingCart) {
                System.out.println(name.name);
            }
        } else System.out.println("\nYou've bought no items");

        System.out.println("Total debit is: "+df.format(myDebit)+" SEK.");
        
        //Find out finanses
        System.out.println("Your credit is: "+df.format(myCredit)+" SEK.");
        if(myCredit < myDebit)System.out.println("\nTo little funds!!!");
        else{
            if(!shoppingCart.isEmpty())System.out.println("You have sufficient funds, your items will be delivered and any excess credit returned to you.");
            else System.out.println("Your excess credit will be returned to you.");
        }
    }
    
    static void Balance(){
        balance = myCredit - myDebit;      
        if(balance == 0)credReturn = 0;
        else if(balance < 0)credReturn = (int)myCredit;
        else credReturn = (int)balance;//double to int will take away digits and will work as round to floor
    }
    
    static void MoreCreditOrNot(){
        if(balance < 0){
            //Menu for options to add credit or EXIT
            System.out.println("You may add credit or EXIT, we will return any excess credit");
            System.out.println("Select:\n1 To add credit\n2 EXIT");
            boolean wrongNumber = false;//Value set to false not to display error message on first run
            int input = 0;
            do {         
                if(wrongNumber)System.out.println("Enter CORRECT number."); //Error meassage if not a valid number or exception
                wrongNumber = false;
                try {
                    System.out.print("Make your choice: ");
                    input = Vending_Machine.GetInput();
                    System.out.println("");
                    if(1 > input || input > 2)wrongNumber = true;//Loop if wrong number
                }
            catch(Exception e){
            System.out.println("Enter a numeric value, try again"); //Error Exception
            wrongNumber = true;//Loop if exception
            }           
            } while (wrongNumber);//Loop while wrong numeric value, exception
            if(input == 1){
                //If user decides to add credit we reuse the following methods
                AddToCredit();
                Balance();
                CheckOut();                
            }          
        }
    }
    
    static void Change(){
        int billsOf1000 = 0;
        int billsOf500 = 0;
        int billsOf200 = 0;
        int billsOf100 = 0;
        int billsOf50 = 0;
        int billsOf20 = 0;
        int coinsOf10 = 0;
        int coinsOf5 = 0;
        int coinsOf1 = 0;
        String text = "";
        
    System.out.println("\nTotal amount returned will be "+credReturn+" SEK.");
        while(credReturn != 0) {           
            if(credReturn >= 1000){
                billsOf1000 = (int)(credReturn / 1000);
                credReturn = credReturn - billsOf1000 * 1000;
            } else if(credReturn >= 500){
                billsOf500 = (int)(credReturn / 500);
                credReturn = credReturn - billsOf500 * 500;
            } else if(credReturn >= 200){
                billsOf200 = (int)(credReturn / 200);
                credReturn = credReturn - billsOf200 * 200;
            } else if(credReturn >= 100){
                billsOf100 = (int)(credReturn / 100);
                credReturn = credReturn - billsOf100 * 100;
            } else if(credReturn >= 50){
                billsOf50 = (int)(credReturn / 50);
                credReturn = credReturn - billsOf50 * 50;
            } else if(credReturn >= 20){
                billsOf20 = (int)(credReturn / 20);
                credReturn = credReturn - billsOf20 * 20;
            } else if(credReturn >= 10){
                coinsOf10 = (int)(credReturn / 10);
                credReturn = credReturn - coinsOf10 * 10;
            } else if (credReturn >= 5){
                coinsOf5 = 1;//No need for division here since criteria was return change with highest value coins/bills
                credReturn -= 5;
            } else{
                coinsOf1 = credReturn;
                credReturn = 0;
            } 
        }
        //Printout for credReturn, tried other technique for adding to text string "text"
        if(balance != 0){
        System.out.println("It will be provided as follows:");
        if(billsOf1000 != 0)text += "\n"+billsOf1000+" bills of 1000 SEK.";
        if(billsOf500 != 0)text += "\n"+billsOf500+" bills of 500 SEK.";
        if(billsOf200 != 0)text += "\n"+billsOf200+" bills of 200 SEK.";
        if(billsOf100 != 0)text += "\n"+billsOf100+" bills of 100 SEK.";
        if(billsOf50 != 0)text += "\n"+billsOf50+" bills of 50 SEK.";
        if(billsOf20 != 0)text += "\n"+billsOf20+" bills of 20 SEK.";
        if(coinsOf10 != 0)text += "\n"+coinsOf10+" coins of 10 SEK.";
        if(coinsOf5 != 0)text += "\n"+coinsOf5+" coins of 5 SEK.";
        if(coinsOf1 != 0)text += "\n"+coinsOf1+" coins of 1 SEK.";
        System.out.println(text);        
        }      
    }
    
    static void ByeBye(){
        System.out.println("\nThank you for shopping with Vending Machine!");
    }
}
