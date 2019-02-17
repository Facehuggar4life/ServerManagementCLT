/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappserver;


/**
 *
 * @author owena
 */
public class WebAppServer {
    public static void main(String[] args) {
         DatabaseEntry instanceOfDatabase = new DatabaseEntry();
         Input instanceOfInput = new Input(instanceOfDatabase);
         instanceOfInput.dataCollection();
    }
    
}
