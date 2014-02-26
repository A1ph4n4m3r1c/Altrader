package altrader;

import java.net.*;
import java.io.*;
import java.util.Scanner;



public class Altrader {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------Altcoin Ticker 1.00-------------");
        System.out.println("Currency One:");
        Scanner reader = new Scanner(System.in);
        String currencyOne=reader.next();
        System.out.println("Currency Two:");
        Scanner readerTwo = new Scanner(System.in);
        String currencyTwo=readerTwo.next();
        

        URL oracle = new URL("http://coinchan.org/Tests/altcointicker.php?USER=Admin&PASS=Lemonparty&CURRENCYONE="+currencyOne+"&CURRENCYTWO="+currencyTwo);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
          
        in.close();
        System.out.println("--------------------DONE---------------------");
    }
}
