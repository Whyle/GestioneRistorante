/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

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

    /**
     * costruttore di default : inizializzo il nome, lista dei tavoli
     *
     * @param nome nome del prenotato
     * @param lista_tavoli lista dei tavoli
     * @throws TavoliEccezioni da lanciare nel caso si verificasse un errore
     */
    public Archivio(String nome, Tavolo[] lista_tavoli) throws TavoliEccezioni {
        this.nome = nome;
        if (lista_tavoli.length > N_MAX_TAVOLI_PRENOTATO) {
            throw new TavoliEccezioni();
        }
        tavolo_prenotato = new Tavolo[N_MAX_TAVOLI_PRENOTATO];
        for (int i = 0; i < lista_tavoli.length; i++) {
            this.tavolo_prenotato[i] = new Tavolo(lista_tavoli[i]);
        }

        n_tavoli_prenotati = lista_tavoli.length;
        tavolo_presenti = new Ristorante[N_MAX_TAVOLI_PRESENTI];
        n_tavoli_presenti = 0;
        prenotato = new Prenotazione[N_MAX_PRENOTATI];
        n_prenotati = 0;
    }

    /**
     * COSTRUTTORE DI COPIA : realizzo una copia
     *
     * @param a
     */
    public Archivio(Archivio a) {
        this.nome = a.nome;

        tavolo_prenotato = new Tavolo[N_MAX_TAVOLI_PRENOTATO];
        for (int i = 0; i < a.tavolo_prenotato.length; i++) {
            this.tavolo_prenotato[i] = new Tavolo(a.tavolo_prenotato[i]);
        }
        n_tavoli_prenotati = a.n_tavoli_prenotati;

        prenotato = new Prenotazione[N_MAX_PRENOTATI];
        for (int i = 0; i < a.prenotato.length; i++) {
            this.prenotato[i] = new Prenotazione(a.prenotato[i]);
        }
        n_prenotati = a.n_prenotati;

        tavolo_presenti = new Ristorante[N_MAX_TAVOLI_PRESENTI];
        for (int i = 0; i < a.tavolo_presenti.length; i++) {
            this.tavolo_presenti[i] = new Ristorante(a.tavolo_presenti[i]);
        }
        n_tavoli_presenti = a.n_tavoli_presenti;
    }

    /**
     * GET NOME
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNPrenotati() {
        return n_prenotati;
    }

    public int getNTavoliPrenotati() {
        return n_tavoli_prenotati;
    }

    public int getNTavoliPresenti() {
        return n_tavoli_presenti;
    }

    public static int getN_MAX_PRENOTATI() {
        return N_MAX_PRENOTATI;
    }

    public static int getN_MAX_TAVOLI_PRENOTATO() {
        return N_MAX_TAVOLI_PRENOTATO;
    }

    public static int getN_MAX_TAVOLI_PRESENTI() {
        return N_MAX_TAVOLI_PRESENTI;
    }

    /**
     * GET PRENOTATO - ricerca un prenotato per numero di telefono nell'array
     * dei prenotati al ristorante
     *
     * @param n_telefono numero di telfono del prenotato
     * @return l'oggetto Prenotato a cui appartiene il numero di telefono
     * cercata
     * @throws NonPrenotato da lanciare nel caso la persona non sia prenotata
     */
    public Prenotazione getPrenotato(int n_telefono) throws NonPrenotato {

        for (int i = 0; i < n_prenotati; i++) {
            if (prenotato[i].getNTelefono().equals(n_telefono)) {
                return new Prenotazione(prenotato[i]);
            }
        }
        throw new NonPrenotato();
    }

    /**
     * SET PRENOTATO - immatricolazione di un prenotato con la prenotazione del
     * posto al ristorante
     *
     * @param p oggeto Prenotazione
     * @throws PrenotazioneEccezioni lanciato nel caso ci sia un eccezione
     * @throws PrenotatoDublicato lanciato nel caso la persona sia già prenotato
     */
    public void setPrenotato(Prenotazione p) throws PrenotazioneEccezioni, PrenotatoDublicato {
        if (n_prenotati == N_MAX_PRENOTATI) {
            throw new PrenotazioneEccezioni(n_prenotati);
        }
        //se lo prenotato è gia presente lancio un eccezione
        for (int i = 0; i < n_prenotati; i++) {
            if (prenotato[i].equals(p)) {
                throw new PrenotatoDublicato();
            }
        }
        prenotato[n_prenotati] = new Prenotazione(p);
        n_prenotati++;
    }

    /**
     * REMOVE PRENOTATO - rimuovere il prenotato dalla prenotazione ricercando
     * il prenotato per il numero di telefono.In questo caso non è più
     * necessario mantenere traccia del tavolo assegnato.
     *
     * @param n_telefono numero di telefono del prenotato
     * @throws NonPrenotato se la persona non è prenotato
     */
    public void removePrenotato(int n_telefono) throws NonPrenotato {

        // ricerco prenotato
        boolean prenotato_trovato = false;
        int idx_prenotato = -1;
        for (int i = 0; i < n_prenotati && !prenotato_trovato; i++) {
            if (prenotato[i].getNTelefono().equals(n_telefono)) {
                prenotato_trovato = true;
                idx_prenotato = i;
            }
        }
        // se il prenotato non è presente lancio un eccezione
        if (!prenotato_trovato) {
            throw new NonPrenotato();
        }

        //elimino tutti i tavoli del prenotato
        for (int j = n_tavoli_presenti - 1; j >= 0; j--) {
            if (tavolo_presenti[j].getPrenotato().getNTelefono().equals(n_telefono)) {
                tavolo_presenti[j] = new Ristorante(tavolo_presenti[n_tavoli_presenti]);
                tavolo_presenti[n_tavoli_presenti - 1] = null;
                n_tavoli_presenti--;
            }
        }
        //elimino il prenotato
        prenotato[idx_prenotato] = new Prenotazione(prenotato[n_prenotati]);
        prenotato[n_prenotati - 1] = null;
        n_prenotati--;
    }

    /**
     * GET TAVOLO PRENOTATO - ricerca di un tavolo con il numero del tavolo
     * nell'array dei tavoli prenotati.
     *
     * @param n_del_tavolo numero del tavolo
     * @return l'oggetto tavolo indentificato con il numero di tavolo
     * @throws TavoloNonPresente se il tavolo ricercato non è presente
     * nell'array che contiene la lista dei tavoli all'interno del ristorante
     */
    public Tavolo getTavoloPrenotato(int n_del_tavolo) throws TavoloNonPresente {

        for (int i = 0; i < n_tavoli_prenotati; i++) {
            if (tavolo_prenotato[i].getNTavoli() == n_del_tavolo) {
                return new Tavolo(tavolo_prenotato[i]);
            }
        }
        throw new TavoloNonPresente();
    }

    public void setTavolo_presenti(Ristorante[] tavolo_presenti) {
        this.tavolo_presenti = tavolo_presenti;
    }

    /**
     * GET LISTA TAVOLO PRESENTI - restituisce la lista di tavoli che il
     * prenotato di cui viene dato il numero di telefono
     *
     * @param n_telefono numero di telefono del prenotato
     * @return un array di tavoli che contiene il tavolo prenotato del prenotato
     * @throws NonPrenotato lanciato nel caso la persona non sia prenotato
     * @throws ListaTavoliVuota lanciato nel caso se il numero di tavoli
     * prenotati è vuota
     */
    public Tavolo[] getListaTavoliPresenti(int n_telefono) throws NonPrenotato, ListaTavoliVuota {

        // verifico se la persona ha prenotato o no
        //ricerca del prenotato
        boolean prenotato_trovato = false;
        for (int i = 0; i < n_prenotati && !prenotato_trovato; i++) {
            if (prenotato[i].getNTelefono().equals(n_telefono)) {
                prenotato_trovato = true;
            }
        }

        // se non è prenotato lancio un eccezione
        if (!prenotato_trovato) {
            throw new NonPrenotato();
        }

        //contiano quanti sono i tavoli prenotati
        int n_tavolo_prenotato = 0;
        for (int i = 0; i < n_tavoli_presenti; i++) {
            if (tavolo_presenti[i].getPrenotato().getNTelefono().equals(n_telefono)) {
                n_tavolo_prenotato++;
            }
        }

        // se il numero di tavolo prenotato è vuoto lancio un eccezione
        if (n_tavolo_prenotato == 0) {
            throw new ListaTavoliVuota();
        }

        //inizializzo l'array con la dimensione opportuna data dal numero di
        //tavoli_presenti
        Tavolo[] lista_tavolo_prenotato = new Tavolo[n_tavolo_prenotato];
        int k = 0;
        for (int i = 0; i < n_tavoli_presenti; i++) {
            if (tavolo_presenti[i].getPrenotato().getNTelefono().equals(n_telefono)) {
                lista_tavolo_prenotato[k] = new Tavolo(tavolo_prenotato[i]);
                k++;
            }
        }
        return lista_tavolo_prenotato;
    }

    enum TipologiaPiatto {
        PRANZO, CENA
    }

    enum Piatti {

        PS("Pasta al sugo", "PS", 10, 3),
        PC("Polpettone di carne", "PC", 15, 5),
        PZ("Pizza", "PZ", 10, 7),
        RI("risotto", "RI", 8, 5),
        SC("spaghetti alla carbonara", "SC", 12, 8),
        RB("ragù alla bolognese", "RB", 10, 5);

        public final String nome;
        public final String codice;
        public final float prezzo;
        public final int n_ordinati;

        /**
         * costruttore prametrico : enum non si può usare per istanziare oggetti
         * e il costruttore deve essere privato perchè non è possibile creare
         * isatnze fuori dalla classe
         *
         * @param nome nome del piatto
         * @param codice codice del piatto
         * @param prezzo prezzo del piatto
         * @param n_ordinati numeri possibili ordinabili del piatto
         */
        private Piatti(String nome, String codice, float prezzo, int n_ordinati) {
            this.nome = nome;
            this.codice = codice;
            this.prezzo = prezzo;
            this.n_ordinati = n_ordinati;
        }

        // ovveride per la stampa dell'oggetto di tipo Piatti
        @Override
        public String toString() {
            return this.nome + "(" + this.codice + ")";
        }

    }

}
