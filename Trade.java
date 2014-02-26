

package altrader;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Trade {
    
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
         
    }
    
