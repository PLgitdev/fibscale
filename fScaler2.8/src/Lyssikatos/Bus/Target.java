
package Lyssikatos.Bus;
import java.util.Objects;

/**
 *
 * @author P
 */
public class Target  {
    public int targetI;
    private double targetD;
    
    public Target(Double[] btcH,int j)
    {
    for (int i =j;i<=btcH.length;i++){
        if (btcH[i]>=0&&Objects.equals(btcH[i], btcH[i+1])){
        this.targetD = btcH[i]; 
        this.targetI = i;
        break;}}
  
   }
  
    public int getTargetI() {
        return targetI;
    }

    public void setTargetI(int targetI) {
        this.targetI = targetI;
    }

    public double getTargetD() {
        return targetD;
    }

    public void setTargetD(double targetD) {
        this.targetD = targetD;
    }
}