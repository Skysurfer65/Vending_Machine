
package vending_machine;

import java.text.DecimalFormat;
import java.util.Scanner;


public class MyWallet {
    //Attributes
    static double myKredit = 0;
    public static double myDebit;
    static double balance;
    static String strBalance;
    
    
    //Constructor not applicapple as I only need one wallet static variables and methods instead
   /* public Wallet(double myKredit, double myDebit){
        this.myKredit = myKredit;
        this.myDebit = myDebit;       
    }
   */
    //Methods
    static void AddToCredit(){
        boolean notANumber;
        do {            
            notANumber = false;
            System.out.print("Put money in the machine: ");
            Scanner scan = new Scanner(System.in);
            try {
                int kredit = scan.nextInt();
                myKredit += kredit;                
            } catch (Exception e) {
                notANumber = true;
            }
            
        } while (notANumber);  
    }

    
    static void Balance(){
        DecimalFormat df = new DecimalFormat("#.00");//For looks only, 2 decimals
        balance = myKredit - myDebit;
        
        strBalance = df.format(balance);
        
        
        System.out.println("Saldot på ditt konto är "+strBalance+" SEK");
    }   
    
}
