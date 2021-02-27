
package vending_machine;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class MyWallet {
    //Attributes
    static double myCredit = 0;
    public static double myDebit = 0;
    static double balance;
    static String strBalance;
    static int valueCoin1 = 10;
    static int valueCoin5 = 50;
    static int valueCoin10 = 100;
    static int valueBill20 = 200;
    //Create shoppingCart ArrayLists
    static ArrayList <String> shoppingCartType = new ArrayList<>();
    static ArrayList <String> shoppingCartName = new ArrayList<>();
    static ArrayList <Double> shoppingCartPrice = new ArrayList<>();
    
    
    //Constructor not applicapple as I only need one wallet static variables and methods instead
   /* public Wallet(double myCredit, double myDebit){
        this.myCredit = myCredit;
        this.myDebit = myDebit;       
    }
   */
    //Methods
    static void AddToCredit(){
        boolean wrongNumber;
        do {            
            wrongNumber = true;
            System.out.println("\nVending Machine");
            System.out.println("_________________");
            System.out.println("\nPut money in the machine: ");
            System.out.println("1 You have value "+valueCoin1+" SEK in coin 1 SEK");
            System.out.println("2 You have value "+valueCoin5+" SEK in coin 5 SEK");
            System.out.println("3 You have value "+valueCoin10+" SEK in coin 10 SEK");
            System.out.println("4 You have value "+valueBill20+" SEK in bill 20 SEK");
            System.out.println("5 EXIT");
            System.out.println("Your current credit: "+myCredit);
            System.out.print("Select a number to add to yor credit: ");
            try {
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
                        wrongNumber = false;
                        break;
                    default:
                        wrongNumber = true;
                        break;
                }
                              
            } catch (Exception e) {
                wrongNumber = true;
            }            
        } while (wrongNumber);  
    }

    
    static void Balance(){
       /* 
        DecimalFormat df = new DecimalFormat("#.00");//For looks only, 2 decimals
        balance = myCredit - myDebit;
        strBalance = df.format(balance);        
        System.out.println("Saldot på ditt konto är "+strBalance+" SEK");
        */
    }   
    static void CheckOut(){
        DecimalFormat df = new DecimalFormat("#.00");
        //Display items in shopping cart
        if(!shoppingCartName.isEmpty()){
            System.out.println("\nYou've ordered the following item/items:");
            for (String name : shoppingCartName) {
                System.out.println(name);         
            }
        } else System.out.println("\nYou've bought no items");
        
        //Now find out myDebit
        for (Double price : shoppingCartPrice) {
            myDebit += price;        
        }
        System.out.println("Total debit is: "+df.format(myDebit)+" SEK.");
        
        //Find out finanses
        System.out.println("Your credit is: "+df.format(myCredit)+" SEK.");
        if(myCredit < myDebit)System.out.println("\nTo little funds, we will return any credit provided and stop the program.");
        else{
            System.out.println("You have sufficient funds, your items will be delivered and any excess credit returned to you.");
            
            //check what type of mercandise to make use of Use methods.
            boolean drink = false;
            boolean food = false;
            boolean merchandise = false;
            for (String type : shoppingCartType) {
                if(type.equals("drink"))drink = true;
                if(type.equals("food"))food = true;
                if(type.equals("merchandise"))merchandise = true;     
            }
        }
        
        
        
        
    }
}
