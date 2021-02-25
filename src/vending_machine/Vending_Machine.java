/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bax Musik
 */
public class Vending_Machine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inventory
        Drink cocaCola= new Drink("drink", "Coca-Cola", "33cl can", 18, "sparkling");
        Drink orangeJuice = new Drink("drink", "Orange-Juice", "50cl bottle", 22, "still");
        Food hamSandwich = new Food("food", "Hamsandwich", "150 grams", 25, false);
        Food veggieSandwich = new Food("food", "Veggiesandwich", "100 grams", 30, true);
        Merchandise capBlue = new Merchandise("merchandise", "Baseball Cap Blue", "mesh net", 50, "blue");
        Merchandise CapRed= new Merchandise("merchandise", "Baseball Cap Red", "mesh net", 50, "red");
        
       
        //Creating ArrayList from all objects
        ArrayList<MerchAbstract> merchList = new ArrayList<>();
        
        merchList.add(cocaCola);
        merchList.add(orangeJuice);
        merchList.add(hamSandwich);
        merchList.add(veggieSandwich);
        merchList.add(capBlue);
        merchList.add(CapRed);
        
        
        //Creating dynamic menu with input 
        int input = 0;
        do {            
         boolean wrongNumber = false;
        
        
        do {
            
            if(wrongNumber)System.out.println("Enter CORRECT number.");
            wrongNumber = false;
            System.out.println("Vending Machine");
            System.out.println("_________________");
           
                        
            int n = 1;
            for (MerchAbstract i : merchList) {
                System.out.println( n +" "+ i.name);
                n++;} 
            try {
                System.out.print("Select one option for further details: ");
                input = GetInput();
                System.out.println("");
                if(1 > input || input > merchList.size())wrongNumber = true;
            }
            catch(Exception e){
            System.out.println("Enter a numeric value, try again");
            wrongNumber = true;
            }           
        } while (wrongNumber);
        
        
        //Merchandise description and add to cart
        merchList.get(input - 1).HeaderDescription();
        String itemDescription = merchList.get(input - 1).name;
        switch(itemDescription){
            case "Coca-Cola":
                cocaCola.Description();
                cocaCola.Buy();             
                break;
            case "Orange-Juice":
                orangeJuice.Description();
                orangeJuice.Buy();
                break;
            case "Hamsandwich":
                hamSandwich.Description();
                hamSandwich.Buy();
                break;
            case "Veggiesandwich":
                veggieSandwich.Description();
                veggieSandwich.Buy();
                break;
            case "Baseball Cap Blue":
                capBlue.Description();
                capBlue.Buy();
                break;
            case "Baseball Cap Red":
                CapRed.Description();
                CapRed.Buy();
                break;
            default:
                break;            
        }
            
        //Continue shopping or checkout      
        System.out.println("\n1 Continue shopping\n2 Check-out to collect items");
        
        do {
            
            if(wrongNumber)System.out.println("Enter CORRECT number.");
            wrongNumber = false;
            try {
                System.out.print("Make your choice: ");
                input = GetInput();
                System.out.println("");
                if(1 > input || input > 2)wrongNumber = true;
            }
            catch(Exception e){
            System.out.println("Enter a numeric value, try again");
            wrongNumber = true;
            }           
        } while (wrongNumber);           
        } while (input == 1);

        //Shopping cart
        System.out.println("Total cost of ordered items: "+Drink.debit+" SEK.");
       
        
            
        
        
       
        
    }
        //Input function integer
        public static int GetInput(){
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.next());
        return input;       
        }
        //Input function string
        public static String GetInputString(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return input;       
        } 
        public static void BuyItem(){
            
        }
            
           
        
}
       
      

        

   

