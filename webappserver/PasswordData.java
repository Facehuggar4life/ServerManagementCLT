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
public class PasswordData{
    public int[] key;
    public int  index;
    PasswordData(int[] key, int index){
        this.key = key;
        this.index = index;
    }
    public int[] returnKey(){
        return key;
    }
    public int returnIndex(){
        return index;
    }
}
