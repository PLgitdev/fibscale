/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lyssikatos.DB;

import Lyssikatos.Bus.Sendable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author P
 */
public class UrlLSell implements Sendable {

         private double quant;
         private BigDecimal rate;
public UrlLSell(double quant, double rate){

    BigDecimal rateB = BigDecimal.valueOf(rate).setScale(8, RoundingMode.HALF_UP);
    
    this.quant = quant;
    this.rate = rateB;
}

public UrlLSell(){}
    @Override
    public void send()throws Exception{
    String url = 
        ("https://api.bittrex.com/api/v1.1/market/selllimit?apikey="
                +APIKEY+"&market="+MARKET+"&quantity="+quant+"&rate="+rate);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending'GET request to URL : " + url);
        System.out.print("Response code : " + responseCode);
        StringBuffer response;
             try (BufferedReader in = new BufferedReader( 
                     new InputStreamReader(con.getInputStream()))) {
                 String inputLine;
                 response = new StringBuffer();
                 while ((inputLine = in.readLine()) != null){
                     response.append(inputLine);}
             }
        System.out.print(response.toString());
    } 
       public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}

