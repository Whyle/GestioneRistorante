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
public class Tavolo {

    private int numero_del_tavolo;
    private int capienza;

    /**
     * costruttore di default: inizializzo il numero di tavolo, numeri di posti al tavolo
     */
    public Tavolo() {
        this.numero_del_tavolo = 0;
        this.capienza = 0;
    }

    /**
     * costruttore parametrico
     *
     * @param numero_del_tavolo numero di tavolo
     * @param capienza numero di posti al tavolo
     */
    public Tavolo(int numero_del_tavolo, int capienza) {
        this.numero_del_tavolo = numero_del_tavolo;
        this.capienza = capienza;
    }

    /**
     * costruttore di copia
     *
     * @param t tavolo di cui fare la copia
     */
    public Tavolo(Tavolo t) {
        this.numero_del_tavolo = t.numero_del_tavolo;
        this.capienza = capienza;

    }

    /**
     * metodo get numero di tavoli
     *
     * @return il numero di tavoli
     */
    public int getNTavoli() {
        return numero_del_tavolo;

    }

    /**
     * metodo set numero di tavoli
     *
     * @param numero_del_tavolo il numero del tavolo
     */
    public void setNTavoli(int numero_del_tavolo) {
        this.numero_del_tavolo = numero_del_tavolo;
    }

    /**
     * metodo get numero di posti al tavolo
     *
     * @return il numero di posti al tavolo 
     */
    public int getNDiPostiAlTavolo() {
        return capienza;
    }

    /**
     * metodo set numero di posti al tavolo
     *
     * @param capienza il numero di posti al tavolo
     */
    public void setNDiPostiAlTavolo(int capienza) {
        this.capienza = capienza;
    }

    /**
     * metodo equals che confronta se i due tavoli sono uguali o no
     *
     * @param t tavolo da mettere a confronto
     * @return se i tavoli sono uguali o no
     */
    public boolean equals(Tavolo t) {
        return this.capienza == t.capienza;
    }

     /**
     * metodo toString
     *
     * @return il numero di tavolo, il numero di posti al tavolo 
     */
    
    @Override
    public String toString() {
        return "Tavolo{" + "numero_del_tavolo=" + numero_del_tavolo + ", capienza=" + capienza + '}';
    }
    
}
