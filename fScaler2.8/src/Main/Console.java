/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.Scanner;
/**
 *
 * @author P
 */
public class Console {
    public Scanner sc = new Scanner(System.in);
    
    public Double getQuantity (){
    String s = sc.next();
    
    Double d = Double.parseDouble(s);
    return d;
    }
  }
