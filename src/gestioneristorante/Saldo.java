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
public class Saldo {
/*
    enum TipologiaPiatto {
        PRIMO, SECONDO, DOLCE, BEVANDE
    }

    enum Piatti {

        PS("Pasta al sugo", 10, 3);

        public final String nome;
        public final float prezzo;
        public final int n_ordinati;

        private Piatti(String nome, float prezzo, int n_ordinati) {
            this.nome = nome;
            this.prezzo = prezzo;
            this.n_ordinati = n_ordinati;
        }

        @Override
        public String toString() {
            return this.nome + "(" + this.nome + ")";
        }

    }
    */
    
    // Enum Types: tipi enumerativi
    // collezione di costanti esplicitamente elencate in una lista (enumerazione)
    // (classe di oggetti costanti)
    // tutte le enum estendono la classe java.lang.Enum
    // poichè non c'è eredità multipla in java non possono estendere altre classi
    // esempio semplice di Enum
    enum GiornoSettimana {
        LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
    }

    // esempio strutturato di Enum
    enum Element {
        H("Hydrogen", "H", 1, 1.008f),
        HE("Helium", "He", 2, 4.0026f),
        LI("Lithium", "Li", 3, 6.941f),
        BE("Beryllium", "Be", 4, 9.0122f);
        // ogni costante può avere una lista di parametri associati
        // l'unica differenza con le classi è che gli attributi di una enum 
        // sono final (poichè sono caratteristiche di un oggetto costante) 
        // e solitamente public (per poter accedere ai valori delle costanti)
        public final String symbol;
        public final String label;
        public final int atomicNumber;
        public final float atomicWeight;

        // l'enum non si può usare per istanziare oggetti
        // il costruttore deve essere privato perchè non è possibile creare isatnze fuori dalla classe
        private Element(String label, String symbol, int atomicNumber, float atomicWeight) {
            this.label = label;
            this.symbol = symbol;
            this.atomicNumber = atomicNumber;
            this.atomicWeight = atomicWeight;
        }

        // override per la stampa dell'oggetto di tipo Element
        // se non si overrida il metodo di default della classe Enum stampa 
        // il nome simbolico della costante (H, HE, LI)
        @Override
        public String toString() {
            return this.label + "(" + this.symbol + ")";
        }

    }

    public static void main(String[] args) {

        // inizializzazione
        GiornoSettimana oggi = GiornoSettimana.LUNEDI;
        // i valori delle costanti di tipo enum si utilizzano con il nome 
        // della costante preceduto dal nome della classe EnumName.CONST_NAME
        // stampa del valore della costante -> il nome della costante
        System.out.println("oggi è " + oggi);

        // metodi predefiniti della classe java.lang.Enum
        // ordinal() resutituisce il numero della costante in ordine nell'eleneco di definizione
        // compareTo(enum e) restituisce la differenza tra this.ordinal ed e.ordinal
        // name() restutisce il nome di definizione della costante
        // values() restituisce un array di tutte le costanti della enum
        System.out.println("numero atomico del litio: " + Element.LI.atomicNumber);
        System.out.println("ordinale del litio: " + Element.LI.ordinal());
        System.out.println("Litio comparedTo Berillio: " + Element.LI.compareTo(Element.BE));
        Element[] els = Element.values();
        // array di tutti gli elementi inseriti nella enum Elements
        System.out.println("lista elementi nella enum Elements");
        for (int i = 0; i < els.length; i++) {
            System.out.println(els[i]);
        }
        // i tipi enumerativi possono essere usati in uno switch (sono paragonabili ad interi)
        Element e = Element.BE;
        switch (e) {
            case H:
                System.out.println("questo è l'idrogeno");
                break;
            case HE:
                System.out.println("questo è l'elio");
                break;
            default:
                System.out.println("questo è un elemento che non è elio nè idrogeno");
        }

    }

}
