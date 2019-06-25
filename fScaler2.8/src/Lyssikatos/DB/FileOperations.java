
package Lyssikatos.DB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonReader;



public class FileOperations 
{
    
    private Double[] btcHighsDoubles;
    private Double[] btcPriceDoubles;
public FileOperations (){
        String btcHS = "C:/Users/P/Desktop/data/txt/output.txt";
    Path btcH = Paths.get(btcHS);
    File btcHighs = btcH.toFile();
    
    String[] btcDataSArray = new String[1247];
     this.btcHighsDoubles = new Double[1247];
    try (BufferedReader in = new BufferedReader(new FileReader(btcHighs));
            JsonReader reader = Json.createReader(in))
        {
       JsonArray jArray = reader.readArray();
        for (int i =0; i<btcDataSArray.length; i++)
        {
        JsonNumber  hPricesN = jArray.getJsonObject(i).getJsonNumber("high");
        String  stringH = hPricesN.toString();
        this.btcHighsDoubles [i] = Double.parseDouble(stringH);
      }
}catch (Exception e){
             System.out.println(e);
             }
 
String btcDS = "C:/Users/P/Desktop/data/txt/output.txt";
    Path btcD = Paths.get(btcDS);
    File btcDoubles = btcD.toFile();
     this.btcPriceDoubles = new Double[1247];
      try (BufferedReader in = new BufferedReader (new FileReader(btcDoubles));
              JsonReader reader = Json.createReader(in))
      {    JsonArray wPrices= reader.readArray();
      for (int i =0; i<1247;i++) {
       BigDecimal p  = wPrices.getJsonObject(i)
               .getJsonNumber("weightedAverage").bigDecimalValue();
       String pS = p.toString();
        this.btcPriceDoubles [i] = Double.parseDouble(pS);
     }
}catch (Exception e){
             System.out.println(e);
             }
}


    public Double[] getBtcHighsDoubles() {
        return btcHighsDoubles;
    }

    public void setBtcHighsDoubles(Double[] btcHighsDoubles) {
        this.btcHighsDoubles = btcHighsDoubles;
    }

    public Double[] getBtcPriceDoubles() {
        return btcPriceDoubles;
    }

    public void setBtcPriceDoubles(Double[] btcPriceDoubles) {
        this.btcPriceDoubles = btcPriceDoubles;
    }
}


      
