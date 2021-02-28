
package vending_machine;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class MyWallet {
    //Attributes
    static double myCredit = 0;
    static double myDebit = 0;
    static double balance;
    static int credReturn;
    static int valueCoin1 = 10;
    static int valueCoin5 = 50;
    static int valueCoin10 = 100;
    static int valueBill20 = 200;
    static int valueBill50 = 500;
    static int valueBill100 = 1000;

    //Create shoppingCart ArrayLists
    static ArrayList<MerchAbstract> shoppingCart = new ArrayList<>();
    

    //Methods
    static void AddToCredit(){ //TODO increase to 100SEK bills
        boolean wrongNumber;
        do {            
            wrongNumber = true;
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

      
    static void CheckOut(){
        DecimalFormat df = new DecimalFormat("#.00");
        //Display items in shopping cart
        if(!shoppingCart.isEmpty()){
            System.out.println("\nYou've ordered the following item/items:");
            for (MerchAbstract name : shoppingCart) {
                System.out.println(name.name);         
            }
        } else System.out.println("\nYou've bought no items");
        
        //Now find out myDebit
        for (MerchAbstract price : shoppingCart) {
            myDebit += price.price;        
        }
        System.out.println("Total debit is: "+df.format(myDebit)+" SEK.");
        
        //Find out finanses
        System.out.println("Your credit is: "+df.format(myCredit)+" SEK.");
        if(myCredit < myDebit)System.out.println("\nTo little funds, we will return any credit provided and stop the program.");
        else{
            System.out.println("You have sufficient funds, your items will be delivered and any excess credit returned to you.");
        }
    }
    static void Balance(){
        balance = myCredit - myDebit;
        
        if(balance == 0);
        else if(balance < 0)credReturn = (int)myCredit; //double till int automatiskt avrundning neråt
        else credReturn = (int)balance;
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
                coinsOf5 = 1;
                credReturn -= 5;
            } else{
                coinsOf1 = credReturn;
                credReturn = 0;
            } 
        }
        //Printout for credReturn
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
    static void ByBy(){
        System.out.println("\nThank you for shopping with Vending Machine!");
      
        /*
        //Check type of merchandise and make use of Use     
        boolean drink = false;
        boolean food = false;
        boolean merchandise = false;       
        for (MerchAbstract type : shoppingCart) {
            if(type.strTypeOfMerch.equals(drink))drink = true;
            if(type.strTypeOfMerch.equals(food))food = true;
            if(type.strTypeOfMerch.equals(merchandise))merchandise = true;         
        }
        //TODO Use Methods check drink for drink in merchList then could change Use to static..
        */
    }
}
