/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

/**
 *
 * @author qiuyu
 */
public enum Colours {

    // per ogni colore ha 256 colori, quindi 0 - 255
    RED(255,0,0),
    BLUE(0,255,0),
    GREEN(0,0,255);
    
    private Colours(int red, int blue, int green){
        this.red=red;
        this.blue=blue;
        this.green=green;
    }
    
    private final int red;
    private final int blue;
    private final int green;

    @Override
    public String toString() {
        return this.name()+ "(" + "red=" + this.red + ", blue=" + this.blue + ", verde=" + this.green + '}';
    }
    
    
}
