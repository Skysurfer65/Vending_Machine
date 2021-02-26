
package vending_machine;

import java.util.ArrayList;


public class Inventory {
    
    //Inventory
    static Drink item1= new Drink("drink", "Coca-Cola", "33cl can", 18, "sparkling");
    static Drink item2 = new Drink("drink", "Orange-Juice", "50cl bottle", 22, "still");
    static Food item3 = new Food("food", "Hamsandwich", "150 grams", 25, false);
    static Food item4 = new Food("food", "Veggiesandwich", "100 grams", 30, true);
    static Merchandise item5 = new Merchandise("merchandise", "Baseball Cap Blue", "mesh net", 50, "blue");
    static Merchandise item6 = new Merchandise("merchandise", "Baseball Cap Red", "mesh net", 50, "red");
    static Merchandise item7 = new Merchandise("merchandise", "", "", 0, "");
    static Merchandise item8 = new Merchandise("merchandise", "", "", 0, "");
    static Merchandise item9 = new Merchandise("merchandise", "", "", 0, "");
    static Merchandise item10 = new Merchandise("merchandise", "", "", 0, "");
    
    
        
       
    //Creating ArrayList
    static ArrayList<MerchAbstract> merchList = new ArrayList<>();
    
    //Methods
    static void FillMerchList(){
        merchList.add(item1);
        merchList.add(item2);
        merchList.add(item3);
        merchList.add(item4);
        merchList.add(item5);
        merchList.add(item6);
        //merchList.add(item7);
        //merchList.add(item8);
        //merchList.add(item9);
        //merchList.add(item10);
        
    }
    static void DescriptionAndBuy(int input){
        switch(input){
            case 1:
                Inventory.item1.Description();
                Inventory.item1.Buy();             
                break;
            case 2:
                Inventory.item2.Description();
                Inventory.item2.Buy();
                break;
            case 3:
                Inventory.item3.Description();
                Inventory.item3.Buy();
                break;
            case 4:
                Inventory.item4.Description();
                Inventory.item4.Buy();
                break;
            case 5:
                Inventory.item5.Description();
                Inventory.item5.Buy();
                break;
            case 6:
                Inventory.item6.Description();
                Inventory.item6.Buy();
                break;
            case 7:
                Inventory.item7.Description();
                Inventory.item7.Buy();
                break;
            case 8:
                Inventory.item8.Description();
                Inventory.item8.Buy();
                break;
            case 9:
                Inventory.item9.Description();
                Inventory.item9.Buy();
                break;
            case 10:
                Inventory.item10.Description();
                Inventory.item10.Buy();
                break;
            default:
                break;            
        }
    }
}
