/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import java.util.ArrayList;

import myexceptions.ListaTavoliVuota;
import myexceptions.NonPrenotato;
import myexceptions.PrenotatoDublicato;
import myexceptions.PrenotazioneEccezioni;
import myexceptions.TavoliEccezioni;
import myexceptions.TavoloNonPresente;

/**
 *
 * @author qiuyu
 */
public class Archivio {

    private String nome;
    private Prenotazione[] prenotato;
    private Tavolo[] tavolo_prenotato;
    private Ristorante[] tavolo_presenti;
    private int n_prenotati;
    private int n_tavoli_prenotati;
    private int n_tavoli_presenti;
    private final static int N_MAX_PRENOTATI = 30;
    private final static int N_MAX_TAVOLI_PRENOTATO = 5;
    private final static int N_MAX_TAVOLI_PRESENTI = 30;

    // /**
    //  * costruttore di default : inizializzo il nome, lista dei tavoli
    //  *
    //  * @param nome nome del prenotato
    //  * @param lista_tavoli lista dei tavoli
    //  * @throws TavoliEccezioni da lanciare nel caso si verificasse un errore
    //  */
    // public Archivio(String nome, Tavolo[] lista_tavoli) throws TavoliEccezioni {
    //     this.nome = nome;
    //     if (lista_tavoli.length > N_MAX_TAVOLI_PRENOTATO) {
    //         throw new TavoliEccezioni();
    //     }
    //     tavolo_prenotato = new Tavolo[N_MAX_TAVOLI_PRENOTATO];
    //     for (int i = 0; i < lista_tavoli.length; i++) {
    //         this.tavolo_prenotato[i] = new Tavolo(lista_tavoli[i]);
    //     }

    //     n_tavoli_prenotati = lista_tavoli.length;
    //     tavolo_presenti = new Ristorante[N_MAX_TAVOLI_PRESENTI];
    //     n_tavoli_presenti = 0;
    //     prenotato = new Prenotazione[N_MAX_PRENOTATI];
    //     n_prenotati = 0;
    // }

    // /**
    //  * COSTRUTTORE DI COPIA : realizzo una copia
    //  *
    //  * @param a
    //  */
    // public Archivio(Archivio a) {
    //     this.nome = a.nome;

    //     tavolo_prenotato = new Tavolo[N_MAX_TAVOLI_PRENOTATO];
    //     for (int i = 0; i < a.tavolo_prenotato.length; i++) {
    //         this.tavolo_prenotato[i] = new Tavolo(a.tavolo_prenotato[i]);
    //     }
    //     n_tavoli_prenotati = a.n_tavoli_prenotati;

    //     prenotato = new Prenotazione[N_MAX_PRENOTATI];
    //     for (int i = 0; i < a.prenotato.length; i++) {
    //         this.prenotato[i] = new Prenotazione(a.prenotato[i]);
    //     }
    //     n_prenotati = a.n_prenotati;

    //     tavolo_presenti = new Ristorante[N_MAX_TAVOLI_PRESENTI];
    //     for (int i = 0; i < a.tavolo_presenti.length; i++) {
    //         this.tavolo_presenti[i] = new Ristorante(a.tavolo_presenti[i]);
    //     }
    //     n_tavoli_presenti = a.n_tavoli_presenti;
    // }

    // /**
    //  * GET NOME
    //  *
    //  * @return
    //  */
    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    // public int getNPrenotati() {
    //     return n_prenotati;
    // }

    // public int getNTavoliPrenotati() {
    //     return n_tavoli_prenotati;
    // }

    // public int getNTavoliPresenti() {
    //     return n_tavoli_presenti;
    // }

    // public static int getN_MAX_PRENOTATI() {
    //     return N_MAX_PRENOTATI;
    // }

    // public static int getN_MAX_TAVOLI_PRENOTATO() {
    //     return N_MAX_TAVOLI_PRENOTATO;
    // }

    // public static int getN_MAX_TAVOLI_PRESENTI() {
    //     return N_MAX_TAVOLI_PRESENTI;
    // }



    /**
     * GET TAVOLO PRENOTATO - ricerca di un tavolo con il numero del tavolo
     * nell'array dei tavoli prenotati.
     *
     * @param ristorante in quale ristorante
     * @param n_del_tavolo numero del tavolo
     * @return il tavolo
     * @throws TavoloNonPresente se il tavolo ricercato non è presente
     * nell'array che contiene la lista dei tavoli all'interno del ristorante
     */
    public Tavolo getTavoloPrenotato(Ristorante ristorante, int n_del_tavolo) throws TavoloNonPresente {
        if(n_del_tavolo < ristorante.getNTavoli() && n_del_tavolo >= 0){
            return ristorante.getListaDeiTavoli().get(n_del_tavolo);
        } else{
            throw new TavoloNonPresente();
        }
    }



    /**
     * GET LISTA TAVOLO PRESENTI - restituisce la lista di tavoli che il
     * prenotato di cui viene dato il numero di telefono
     *
     * @param ristorante in quale ristorante
     * @param n_telefono numero di telefono del prenotato
     * @return un array di tavoli che contiene il tavolo prenotato del prenotato
     * @throws NonPrenotato lanciato nel caso la persona non sia prenotato
     */
    public ArrayList<Tavolo> trovarePrenotazione(Ristorante risorante, int n_telefono) throws NonPrenotato, ListaTavoliVuota {

        ArrayList<Tavolo> elenco_di_prenotazione = new ArrayList<Tavolo>();
        
        // verifico se la persona ha prenotato o no
        //ricerca del prenotato
        for (int i = 0; i < risorante.getNTavoli(); i++) {
            if (risorante.getListaDeiTavoli().get(i).getPrenotazione().getNTelefono().equals(n_telefono)) {
                elenco_di_prenotazione.add(risorante.getListaDeiTavoli().get(i));
            }
        }

        // se non è prenotato lancio un eccezione
        if (elenco_di_prenotazione.isEmpty()) {
            throw new NonPrenotato();
        }

        return elenco_di_prenotazione;
    }

    enum TipologiaPiatto {
        PRANZO, CENA
    }


  enum Piatti {
        PS("Pasta al sugo", "PS", 10),
        PC("Polpettone di carne", "PC", 15),
        PZ("Pizza", "PZ", 10),
        RI("risotto", "RI", 8),
        SC("spaghetti alla carbonara", "SC", 12),
        RB("ragù alla bolognese", "RB", 10);
        
        public final String nome;
        public final String codice;
        public final float prezzo;
    
        /**
         * costruttore prametrico : enum non si può usare per istanziare oggetti
         * e il costruttore deve essere privato perchè non è possibile creare
         * isatnze fuori dalla classe
         *
         * @param nome nome del piatto
         * @param codice codice del piatto
         * @param prezzo prezzo del piatto

         */
        private Piatti(String nome, String codice, float prezzo) {
            this.nome = nome;
            this.codice = codice;
            this.prezzo = prezzo;
        }
    
        // ovveride per la stampa dell'oggetto di tipo Piatti
        @Override
        public String toString() {
            return this.nome + "(" + this.codice + ")";
        }
    
    }
    
    
}
