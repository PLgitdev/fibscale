
package Lyssikatos.DB;

import Lyssikatos.Bus.Sendable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlLBuy implements Sendable 
{
        private double quant=0.0;
        private BigDecimal rate;
    public UrlLBuy(double quant, double rate){
      BigDecimal rateB = BigDecimal.valueOf(rate).setScale(8, RoundingMode.HALF_UP); 
    this.quant = quant;
    this.rate = rateB;
    }
    public UrlLBuy(){}
@Override
 public void send() throws Exception{
        String url = 
        ("https://api.bittrex.com/api/v1.1/market/buylimit?apikey="
                +APIKEY+"&market="+MARKET+"&quantity="+QUANTITY+"&rate="+rate);
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
           System.out.print(response.toString());}
 }
}
