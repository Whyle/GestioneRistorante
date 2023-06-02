/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexceptions;

/**
 *
 * @author qiuyu
 */
public class TavoloNonPresente extends Exception{
    
     public TavoloNonPresente() {
    }

    @Override
    public String toString() {
        return "tavolo non presente  - il tavolo non fa parte!";
    }
}
