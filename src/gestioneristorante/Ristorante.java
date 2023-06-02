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
public class Ristorante {

    private String nome_del_ristorante;
    private int n_tavoli_presenti;
    private ArrayList<Tavolo> lista_dei_tavoli = new ArrayList<Tavolo>();

    /**
     * costruttore parametrico
     *
     * @param nome_del_ristorante numero del tavolo
     * @param tavolo la dimensione del tavolo
     */
    public Ristorante(String nome_del_ristorante, int n_tavoli_presenti) {
        this.nome_del_ristorante = nome_del_ristorante;
        this.n_tavoli_presenti  = n_tavoli_presenti;
        init();
    }
    
    /**
     * costruttore di copia
     * @param ris un Tistorante non vuoto
     */
    public Ristorante(Ristorante ris){
        this.nome_del_ristorante = ris.nome_del_ristorante;
        this.n_tavoli_presenti  = ris.n_tavoli_presenti;
    }

    /**
     * inizializza i tavoli del ristorante
     */
    private void init(){
        for(int i = 0; i < n_tavoli_presenti; i++){
            lista_dei_tavoli.add(i, new Tavolo(i, null));
        }
    }

    /**
     * Crea un nuovo prenotazione
     * @param prenotazione un prenotazione
     * @return il tavolo il quale scelto, null se tutti tavoli sono occupati
     */
    public Tavolo nuovoPrenotazione(Prenotazione prenotazione){
        for(int i = 0; i < n_tavoli_presenti; i++){
            if(!lista_dei_tavoli.get(i).getStatoOccupazione()){
                lista_dei_tavoli.get(i).setPrenotazione(prenotazione);
                return lista_dei_tavoli.get(i);
            }
        }
        return null;
    }

    /**
     * Cancellazione di un tavolo
     * @param prenotazione un prenotazione da cancellare
     * @return true cancellato, false errore
     */
    public Boolean cancelaPrenotazione(Prenotazione prenotazione){
        for(int i = 0; i < n_tavoli_presenti; i++){
            if(!lista_dei_tavoli.get(i).getPrenotazione().equals(prenotazione)){
                lista_dei_tavoli.get(i).setPrenotazione(null);
                return true;
            }
        }
        return false;
    }

    /**
     * prendere tutti tavoli
     * @return elenco di tutti i tavoli
     */
    public ArrayList<Tavolo> getListaDeiTavoli(){
        return lista_dei_tavoli;
    }

    /**
     * Ricavare tutti i prenotazione dai tutti i tavoli
     * @return un lista di prenotazione non nullo
     */
    public ArrayList<Prenotazione> getTuttiPrenotazione(){
        ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
        for(int i = 0 ; i < n_tavoli_presenti; i++){
            if(lista_dei_tavoli.get(i).getPrenotazione() != null){
                prenotazioni.add(lista_dei_tavoli.get(i).getPrenotazione());
            }
        }
        return prenotazioni;
    }

    public Tavolo getTavolo(Prenotazione prenotazione){
        for(int i = 0 ; i < n_tavoli_presenti; i++){
            if(lista_dei_tavoli.get(i).getPrenotazione().equals(prenotazione)){
                return lista_dei_tavoli.get(i);
            }
        }
        return null;
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
     * metodo get nome
     *
     * @return nome
     */
    public String getNome() {
        return nome_del_ristorante;
    }


    /**
     * metodo toString
     *
     * @return tavolo, il numero massimo si tavoli presenti nel ristorante
     */
   
    @Override
    public String toString() {
        return "Ristorante{" + "nome=" + nome_del_ristorante + ", numero di tavolo=" + n_tavoli_presenti + '}';
    }

    
    

}
