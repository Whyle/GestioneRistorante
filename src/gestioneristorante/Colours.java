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
    
    RED(100,0),
    BLUE(0,100),
    GREEN(100,100);
    
    private Colours(int red, int blue){
        this.red=red;
        this.blue=blue;
    }
    
    private final int red;
    private final int blue;

    @Override
    public String toString() {
        return this.name()+ "(" + "red=" + this.red + ", blue=" + this.blue + '}';
    }
    
    
}
