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
public class NonPrenotato extends Exception {

    public NonPrenotato() {
    }

    @Override
    public String toString() {
        return "NonPrenotato  - la persona ricercato non risulta prenotato!";
    }
}
