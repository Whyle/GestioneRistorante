/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import gestioneristorante.Archivio.Piatti;

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
    public static final int MAX_PIATTI = 99;

    private Piatti[] lista_piatti = new Piatti[MAX_PIATTI];

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

    public Piatti[] getListaPiatti(){
        return lista_piatti;
    }
    /**
     * Aggiungere un piatto a primo posizione index non null
     * @param p un piatto 
     * @return posizione index dove il piatto viene inserito, altrimente -1
     */
    public int aggiungePiatto(Piatti p){
        int index = 0;
        while(index < MAX_PIATTI){
            if(lista_piatti[index] == null){
                lista_piatti[index] = p;
                return index;
            }
            index++;
        }
        return -1;
    }
    /**
     * Rimuovere un piatto da un index, poi viene spostato un posizione a sinistra
     * @param index il posizione dove vuole eliminare
     * @return true viene eliminato con successo, altrimente false
     */
    public boolean rimuoverePiatto(int index){
        if(index >= 0 && index < MAX_PIATTI){
            // spostare gli elementi a destra del index a un posizione a sinistra
            for(int i = index; i < MAX_PIATTI-1; i++){
                lista_piatti[i] = lista_piatti[i+1];
            }
            // evita ultimo elmento del lista va a copiare un vuoto
            lista_piatti[MAX_PIATTI-1] = null;
            return true;    
        }
        return false;
    }

    /**
     * Get il saldo attuale sul tavolo
     * @return il prezzo da pagare sul tavolo
     */
    public float saldoAttuale(){
        float totale = 0;
        for(int i = 0; i < MAX_PIATTI; i++){
            if(lista_piatti[i] != null){
                totale+=lista_piatti[i].prezzo;
            }
        }
        return totale;

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
    public Boolean isOccuppato(){
        return prenotazione != null;
    }
    
}
