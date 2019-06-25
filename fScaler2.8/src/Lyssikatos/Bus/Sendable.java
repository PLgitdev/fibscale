/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lyssikatos.Bus;


public interface Sendable 
{
    final public String APIKEY = "random";
    final public String MARKET = "USD-BTC";
    final public String USER_AGENT = "Mozilla/5.0";
    final public double QUANTITY = 1000.00;
    public void send() throws Exception;
    
}
