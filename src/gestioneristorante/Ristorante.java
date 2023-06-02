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
public class Ristorante {

    private Prenotazione prenotato;
    private Tavolo tavolo;
    private int n_tavoli_presenti;

    /**
     * costruttore di default: inizializzo il prenotato,il numero di tavolo, la dimensione del tavolo
     */
    public Ristorante() {
        this.prenotato= new Prenotazione();
        this.n_tavoli_presenti = 0;
        this.tavolo = new Tavolo();
    }

    /**
     * costruttore parametrico
     *
     * @param prenotato 
     * @param n_tavoli_presenti numero del tavolo
     * @param tavolo la dimensione del tavolo
     */
    public Ristorante(Prenotazione prenotato,Tavolo tavolo, int n_tavoli_presenti) {
        this.prenotato=prenotato;
        this.n_tavoli_presenti = n_tavoli_presenti;
        this.tavolo = new Tavolo();

    }
    
    public Ristorante(Ristorante ris){
        this.prenotato=ris.prenotato;
        this.n_tavoli_presenti=ris.n_tavoli_presenti;
        this.tavolo=ris.tavolo;
        
    }

    public Prenotazione getPrenotato() {
        return prenotato;
    }

    public void setPrenotato(Prenotazione prenotato) {
        this.prenotato = prenotato;
    }

    
    /**
     * metodo get tavolo
     *
     * @return tavolo
     */
    public Tavolo getTavolo() {
        return tavolo;
    }

    /**
     * metodo set tavolo
     *
     * @param tavolo tavolo
     */
    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    /**
     * metodo get tavoli
     *
     * @return tavoli
     */
    public int getNTavoli() {
        return n_tavoli_presenti;
    }

    /**
     * metodo set tavoli
     *
     * @param n_tavoli_presenti tavoli
     */
    public void setNTavoli(int n_tavoli_presenti) {
        this.n_tavoli_presenti = n_tavoli_presenti;
    }

    /**
     * metodo equals
     *
     * @param r tavolo da mettere a confronto
     * @return se i tavoli sono uguali o no
     */
    public boolean equals(Ristorante r) {
        return this.tavolo == r.tavolo;
    }

    /**
     * metodo toString
     *
     * @return tavolo, il numero massimo si tavoli presenti nel ristorante
     */
   
    @Override
    public String toString() {
        return "Ristorante{" + "prenotato=" + prenotato + ", tavolo=" + tavolo + ", n_tavoli_presenti=" + n_tavoli_presenti + '}';
    }

    
    

}
