/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lyssikatos.Bus;
import Lyssikatos.DB.UrlLBuy;
import Lyssikatos.DB.UrlLSell;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author P
 */
public class MarketAction implements Calculator, Runnable, Countable {
private double sellOne = 0.0;
private double sellTwo = 0.0;
private double sellThree = 0.0;
private double sellFour = 0.0;
private double buy = 0.0;
private double quantity = 0.0;
public Target t;
public Double[] n;
private int count =0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
  public MarketAction(Target t,Double quantity,Double[] n){
      this.t = t;
      this.quantity = quantity;
      this.n = n;
  }
  
@Override      
    public void buyAndScale(){
     double gR =(1+Math.sqrt(5))/2;
        boolean[] TandF = new boolean [n.length];
        boolean[] tFall = new boolean [n.length];
        
        sellOne = 0.0;
        sellTwo = 0.0;
        sellThree = 0.0;
        sellFour = 0.0;
        buy = 0.0;
       
        for(int i = t.getTargetI();i<n.length;i++)
        {
//            System.out.print(n[i]);
            double compare = Math.pow(gR, n[i]-1);
            if (compare <=  n[i])
            {  
               TandF[i] = true;
               System.out.println (n[i] + " is a golden ratio number " +TandF[i]);
            }
            else if (7.64<=(t.getTargetD()/n[i])&&7.66>=(t.getTargetD()/n[i])){
                tFall[i] = true;
                buy = n[i];
                double rate = buy;
                //enter apikey market quanity rate
                UrlLBuy limitBuy = new UrlLBuy(quantity,rate);
                try {limitBuy.send();
                } catch (Exception ex) {
                Logger.getLogger(MarketAction.class.getName()).log(Level.SEVERE, null, ex);
                }
                   System.out.println("enter at "+ buy +" " + tFall[i]);
                   sellOne = buy + (buy/76.4); //safest
                   sellTwo = buy + (buy/38.2);
                   sellThree = buy + (buy/5);
                   UrlLSell limitSellOne = new UrlLSell(quantity*(.25),sellOne);
                   UrlLSell limitSellTwo = new UrlLSell(quantity*(.25),sellTwo);
                   UrlLSell limitSellThree = new UrlLSell(quantity*(.50),sellThree);
                try{limitSellOne.send();limitSellTwo.send();
                    limitSellThree.send();
                   } catch (Exception ex) {
                    Logger.getLogger(MarketAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;}
            else if (6.18<=(t.getTargetD()/n[i])&&6.20>=(t.getTargetD()/n[i])){
                   tFall[i] = true;
                   System.out.println("**Prebuy 6.18 = "+n[i]+"**");
                   buy += n[i];
                   System.out.println("enter at "+ buy +" " + tFall[i]);
                                   
                   sellOne = buy + (buy/76.4); //safest
                   sellTwo = buy + (buy/61.8);
                   sellThree = buy + (buy/50);
                   
                   System.out.println("**sell at "+sellOne +" "+tFall[i]+"**");
                   System.out.println("**sell two at "+sellTwo+" "
                           +tFall[i]+"**");
              
                   System.out.println("**sell three at "+sellThree+" "
                           +tFall[i]+"**");
                                     break;}
             else if(3.819<=(t.getTargetD()/n[i])&&3.820>=(t.getTargetD()/n[i])){
                   tFall[i] = true;//buy put bid at n[i]
                   System.out.print("**Prebuy 3.189 "+n[i]);
                   buy += n[i];
                   System.out.println("enter at "+ buy +" " + tFall[i]);
                   sellOne = buy + (buy/61.8); //safest
                   sellTwo = buy + (buy/50);
                   sellThree = buy + (buy/38.2);
                   System.out.println("**sell at "+sellOne +" "+tFall[i]+"**");
                   System.out.println("**sell two at "+sellTwo+" "
                           +tFall[i]+"**");
                   System.out.println("**sell three at "+sellThree+" "
                           +tFall[i]+"**");
            break;}
            else if(2.36<=(t.getTargetD()/n[i])&&2.37>=(t.getTargetD()/n[i])){
                tFall[i] = true;
                System.out.println("**Prebuy 2.36 = "+n[i]+"**");
                buy += n[i];
                double rate = buy;
                System.out.println("enter at "+ buy +" " + tFall[i]);
                UrlLBuy limitBuy = new UrlLBuy(.003412,rate);
                try {limitBuy.send();} catch (Exception ex) 
                {
                    Logger.getLogger
                        (MarketAction.class.getName()).log(Level.SEVERE, null, ex);
                }
                   sellOne = buy + (buy/61.8); //safest
                   sellTwo = buy + (buy/50);
                   sellThree = buy + (buy/38.2);
                   sellFour = buy + (buy/23.6);
                    UrlLSell limitSellOne = new UrlLSell(quantity*(.25),sellOne);
                   UrlLSell limitSellTwo = new UrlLSell(quantity*(.25),sellTwo);
                   UrlLSell limitSellThree = new UrlLSell(quantity*(.10),sellThree);
                   UrlLSell limitSellFour = new UrlLSell(quantity*(.40),sellFour);
                try{limitSellOne.send();limitSellTwo.send();
                    limitSellThree.send();limitSellFour.send();
                   } catch (Exception ex) {
                    Logger.getLogger(MarketAction.class.getName()).log(Level.SEVERE, null, ex);}
                   break;}
            else if(n[i]>t.getTargetD()){ this.count =i;
               break;}
        else {TandF[i] = false;System.out.println(n[i]+" "+ TandF[i]); this.count=i;}
           
         
    }
}
   @Override
   public void run(){
       MarketAction.this.buyAndScale();  
   }
    public double getBuy() {
        return buy;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Target getT() {
        return t;
    }

    public void setT(Target t) {
        this.t = t;
    }

    public Double[] getN() {
        return n;
    }

    public void setN(Double[] n) {
        this.n = n;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSellOne() {
        return sellOne;
    }

    public void setSellOne(double sellOne) {
        this.sellOne = sellOne;
    }

    public double getSellTwo() {
        return sellTwo;
    }

    public void setSellTwo(double sellTwo) {
        this.sellTwo = sellTwo;
    }

    public double getSellThree() {
        return sellThree;
    }

    public void setSellThree(double sellThree) {
        this.sellThree = sellThree;
    }

    public double getSellFour() {
        return sellFour;
    }

    public void setSellFour(double sellFour) {
        this.sellFour = sellFour;
    }
}
     
   
    

