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
public class PrenotatoDublicato extends Exception {

    public PrenotatoDublicato() {

    }

    @Override
    public String toString() {
        return "PrenotatoDuplicato  - la persona risulta già prenotato!";
    }
}
