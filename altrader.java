/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package altrader;

import java.net.*;
import java.io.*;
import java.util.Scanner;



public class Altrader {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------Altrader PRE-ALPHA-------------");
        System.out.println("Enter Command to begin trading or type 'Man' for help");
        boolean keepAlive=true;
        
        while(keepAlive){
        System.out.println("------------------------------------------");
        Scanner userIn = new Scanner(System.in);
        System.out.print(">");String userInput=userIn.next();
        
        if(userInput.equals("Man")){
            System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Orders: Gets open orders from Bter account");
            System.out.println("------------------------------------------");
            System.out.println("Quit: Exits program");
            System.out.println("------------------------------------------");
            System.out.println("Buy: Enter into Altcoin purchase mode");
            System.out.println("------------------------------------------");
            System.out.println("Sell: Enter into Altcoin sell mode");
            System.out.println("------------------------------------------");
            System.out.println("AutoTrade: Enters Autotrade mode....ALPHA! Caution.");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
            
       
            
        }
        
        if(userInput.equals("Orders")){
            Trade tradeSession=new Trade();
            tradeSession.getOpenOrders();
            
        }
        
        if(userInput.equals("Quit")){
            keepAlive=false;
        }
        
        if(userInput.equals("Buy")){
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
            
            if(userInput.equals("Sell")){
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
