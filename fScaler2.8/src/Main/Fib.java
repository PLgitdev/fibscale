
package Main;
import Lyssikatos.DB.FileOperations;
import Lyssikatos.Bus.MarketAction;
import Lyssikatos.Bus.Target;
import Lyssikatos.Bus.Countable;
public class Fib {

    public static void main(String[] args) throws Exception {
        
        //File operations
        Console c = new Console(); 
         double quantity = c.getQuantity();
        FileOperations fO = new FileOperations();
        Double[] btcHighs = fO.getBtcHighsDoubles();
        Double[] btcPrices = fO.getBtcPriceDoubles();
        int j =0;
        for (int i = 0 ;i<btcPrices.length;i++){
            Target t = new Target(btcHighs,j);
            System.out.print("this is the new target: "+t.getTargetD()+"\n");
            MarketAction mA = new MarketAction(t,quantity,btcPrices);
            mA.buyAndScale();
            j = mA.getCount();
        }
    }
}



