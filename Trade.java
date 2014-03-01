

package altrader;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.json.*;

public class Trade {
    
    public String outPut;
    
    public void getFunds() throws Exception{
        URL getFunds = new URL("http://coinchan.org/Tests/btertest.php?pass=testpass&function=getFunds");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(getFunds.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
         System.out.println(inputLine);
         in.close();
    }
    
    public void getOpenOrders() throws Exception{
        URL getOrder = new URL("http://coinchan.org/Tests/btertest.php?pass=testpass&function=openOrders");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(getOrder.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
         System.out.println(inputLine);
         in.close();
    }
         
     public void buy(String PAIR,String VOLUME) throws Exception{
        URL getBuy = new URL("http://coinchan.org/Tests/btertest.php?pass=testpass&function=trade&type=buy"+"&pair="+PAIR+"&volume="+VOLUME);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(getBuy.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
         System.out.println(inputLine);
         in.close();
         
     }
     
     public void sell(String PAIR,String VOLUME) throws Exception{
        URL getBuy = new URL("http://coinchan.org/Tests/btertest.php?pass=testpass&function=trade&type=buy"+"&pair="+PAIR+"&volume="+VOLUME);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(getBuy.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
         System.out.println(inputLine);
         in.close();
        
         }
     
         public void getPrice() throws IOException{
             
            System.out.println("Currency One:");
            Scanner reader = new Scanner(System.in);
            String currencyOne=reader.next();
             System.out.println("Currency Two:");
             Scanner readerTwo = new Scanner(System.in);
            String currencyTwo=readerTwo.next();
        

             URL url = new URL("http://coinchan.org/Tests/altcointicker.php?USER=Admin&PASS=Lemonparty&CURRENCYONE="+currencyOne+"&CURRENCYTWO="+currencyTwo);
             BufferedReader in = new BufferedReader(
             new InputStreamReader(url.openStream()));

                String inputLine;
              while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
          
          in.close();
         }
         
         
     

        
}


    
