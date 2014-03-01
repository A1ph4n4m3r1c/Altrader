/*
 * A1ph4n4m3r1c
 * 2-26-2014
*/

package altrader;

import java.net.*;
import java.io.*;
import java.util.Scanner;



public class Altrader {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------Altrader PRE-ALPHA-------------");  //ASCII fun
        System.out.println("Enter Command to begin trading or type 'Man' for help");  //Main command prompt
        boolean keepAlive=true;
        
        while(keepAlive){
        System.out.println("------------------------------------------");
        Scanner userIn = new Scanner(System.in);
        System.out.print(">");String userInput=userIn.next();
        
        if(userInput.equals("Man")){ //Opens Man page
            System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");  
            System.out.println("Orders: Gets open orders from Bter account");
            System.out.println("------------------------------------------");
            System.out.println("Quit: Exits program");
            System.out.println("------------------------------------------");
            System.out.println("Buy: Enter into Altcoin purchase mode");
            System.out.println("------------------------------------------");
            System.out.println("Sell: Enter into Altcoin sell mode");
            System.out.println("------------------------------------------");
            System.out.println("Getfunds: Grabs account funds");
            System.out.println("------------------------------------------");           
            System.out.println("AutoTrade: Enters Autotrade mode....ALPHA! Caution.");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
       
        }
        
         if(userInput.equals("Getprice")){  //Grabs account funds
            Trade tradeSession=new Trade();
            tradeSession.getPrice();
            
        }
        
        if(userInput.equals("Orders")){  //Grabs open orders from account
            Trade tradeSession=new Trade();
            tradeSession.getOpenOrders();
            
        }
        
        if(userInput.equals("Getfunds")){  //Grabs account funds
            Trade tradeSession=new Trade();
            tradeSession.getFunds();
            
        }
        
        if(userInput.equals("Quit")){  //Kills program
            keepAlive=false;
        }
        
        if(userInput.equals("Buy")){    //Enters purchase mode
            Scanner confirmBuy = new Scanner(System.in);
            System.out.println("ARE YOU SURE YOU WANT TO BUY? Y/N");
            System.out.print(">");String userActionBuy=confirmBuy.next();
            
            
            if(userActionBuy.equals("Y")){
             Trade tradeSession=new Trade();
             
             Scanner userPair = new Scanner(System.in);
             System.out.println("Pair? ex: ltc_btc");
             System.out.print(">");String PAIR=userIn.next();
             Scanner userVolume = new Scanner(System.in);
             System.out.println("Volume? Usually 100+");
             System.out.print(">");String VOLUME=userIn.next();
             
             tradeSession.buy(PAIR,VOLUME);
                
            }
        }
            
            if(userInput.equals("Sell")){   //Enters sell mode
            Scanner confirmSell = new Scanner(System.in);
            System.out.println("ARE YOU SURE YOU WANT TO SELL? Y/N");
            System.out.print(">");String userActionSell=confirmSell.next();
            
            
            if(userActionSell.equals("Y")){
             Trade tradeSession=new Trade();
             
             Scanner userPair = new Scanner(System.in);
             System.out.println("Pair? ex: ltc_btc");
             System.out.print(">");String PAIR=userIn.next();
             Scanner userVolume = new Scanner(System.in);
             System.out.println("Volume? Usually 100+");
             System.out.print(">");String VOLUME=userIn.next();
             
             tradeSession.sell(PAIR,VOLUME);
                
            }
            
            
        }
        
            
          
        
        
        
        }
        System.out.println("--------------------DONE---------------------");
    }
}
