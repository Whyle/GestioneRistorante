/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import java.util.ArrayList;

/**
 *
 * @author qiuyu
 */
public class Tavolo {

    private int numero_del_tavolo;

    /*
     * Se ugugale null, il tavolo è libero.
     */
    private Prenotazione prenotazione;

    private ArrayList<Piatti> lista_piatti = new ArrayList<Piatti>();

    /**
     * costruttore di default: inizializzo il numero di tavolo, prenotazione
     */
    public Tavolo(int numero_del_tavolo) {
        this.numero_del_tavolo = numero_del_tavolo;
        this.prenotazione = null;
    }
    /**
     * costruttore parametrico
     *
     * @param numero_del_tavolo numero di tavolo
     * @param prenotazione un prenotazione effetuato
     */
    public Tavolo(int numero_del_tavolo, Prenotazione prenotazione) {
        this.numero_del_tavolo = numero_del_tavolo;
        this.prenotazione = prenotazione;
    }

    /**
     * costruttore di copia
     * copiare un tavolo esistente in un nuovo tavolo
     *
     * @param t tavolo di cui fare la copia
     */
    public Tavolo(Tavolo t) {
        this.numero_del_tavolo = t.numero_del_tavolo;
        this.prenotazione = t.prenotazione;
    }

    /**
     * Aggiungere un piatto ul tavolo
     * @param p un piatto 
     */
    public void aggiungePiatto(Piatti p){
        this.lista_piatti.add(p);
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
     * metodo get prenotazione
     *
     * @return il prenotazione del tavolo
     */
    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    
    /**
     * metodo ser prenotazione
     *
     */
    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    /**
     * metodo equals che confronta se i due tavoli sono uguali o no
     *
     * @param t tavolo da mettere a confronto
     * @return se i tavoli sono uguali entambi numero del tavolo e stesso prenotazione
     */
    public boolean equals(Tavolo t) {
        return this.numero_del_tavolo == t.numero_del_tavolo && this.prenotazione.toString()==t.prenotazione.toString();
    }

     /**
     * metodo toString
     *
     * @return il numero di tavolo, il numero di posti al tavolo 
     */
    
    @Override
    public String toString() {
        return "Tavolo { numero_del_tavolo=" + numero_del_tavolo + ", Prenotazione=" + prenotazione.toString() + '}';
    }

    /**
     * metodo get lo stato del occupazione del tavolo
     * @return true il tavolo e' occupato da un prenotazione, viceversa false
     */
    public Boolean getStatoOccupazione(){
        return prenotazione != null;
    }
    
}
