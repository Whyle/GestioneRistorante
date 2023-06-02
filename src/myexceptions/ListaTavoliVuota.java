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
public class ListaTavoliVuota extends Exception{
    
     public ListaTavoliVuota() {
    }

    @Override
    public String toString() {
        return "ListaTavoliVuota  - la lista dei tavoli richeista risulta vuota!";
    }
}
