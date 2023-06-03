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
public class TavoliEccezioni extends Exception {
    public TavoliEccezioni(){
    }

    @Override
    public String toString() {
        return "TavoliEccezioni- tutti i tavoli del ristorante sono prenotati" ;
    }
   
    
}
