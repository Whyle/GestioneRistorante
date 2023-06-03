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
public class Archivio {

 enum Piatti {
        PS("Pasta al sugo",  10),
        PC("Polpettone di carne", 15),
        PZ("Pizza", 10),
        RI("risotto",  8),
        SC("spaghetti alla carbonara",12),
        RB("ragù alla bolognese",  10);
        
        public final String nome;
        public final float prezzo;
    
        /**
         * costruttore prametrico : enum non si può usare per istanziare oggetti
         * e il costruttore deve essere privato perchè non è possibile creare
         * isatnze fuori dalla classe
         *
         * @param nome nome del piatto
         * @param prezzo prezzo del piatto

         */
        private Piatti(String nome, float prezzo) {
            this.nome = nome;
            this.prezzo = prezzo;
        }
    
        // ovveride per la stampa dell'oggetto di tipo Piatti
        @Override
        public String toString() {
            return this.nome + "(" + this.prezzo + ")";
        }
    
    }

    
    
}
