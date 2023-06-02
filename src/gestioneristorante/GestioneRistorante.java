/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import gestioneristorante.Archivio.Piatti;
import gestioneristorante.Archivio.TipologiaPiatto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import myexceptions.*;

/**
 *
 * @author qiuyu
 */
public class GestioneRistorante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //inizializzazione
        TipologiaPiatto PRANZO = TipologiaPiatto.PRANZO;

        System.out.println("la tipologia di piatto scelto è :" + PRANZO);

        System.out.println("code for red:");
        System.out.println(Colours.RED);

        System.out.println("il prezzo e numero ordinabile della pasta al sugo; prezzo:" + Piatti.PS.prezzo + " numero ordinabile:" + Piatti.PS.n_ordinati);
        System.out.println("il prezzo e numero ordinabile spaghetti alla carbonara; prezzo:" + Piatti.SC.prezzo + " numero ordinabile:" + Piatti.SC.n_ordinati);
        System.out.println("il prezzo e numero ordinabile ragù alla bolognese; prezzo:" + Piatti.RB.prezzo + " numero ordinabile:" + Piatti.RB.n_ordinati);
        System.out.println("il prezzo e numero ordinabile del risotto; prezzo:" + Piatti.RI.prezzo + " numero ordinabile:" + Piatti.RI.n_ordinati);

        // values() restituisce un array di tutte le costanti della enum
        Piatti[] pt = Piatti.values();

        // array di tutti gli elementi inseriti nella emum Piatti
        System.out.println("lista dei piatti nella enum Piatti");
        for (int i = 0; i < pt.length; i++) {
            System.out.println(pt[i]);
        }

        //switch piatti
        Piatti p = Piatti.RB;
        switch (p) {
            case PS:
                System.out.println("il piatto è la pasta al sugo ");
                break;
            case PZ:
                System.out.println("il piatto è la pizza");
                break;
            case RB:
                System.out.println("il piatto è la ragù alla bolognese");
                break;
            default:
                System.out.println("non è uno dei piatti presenti");

        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALY);

        Scanner scan = new Scanner(System.in);
        
        Prenotazione Marco = new Prenotazione("Marco", LocalDate.parse("01-05-2023", df), "13:30", 2, "331 7883 234");
        Prenotazione Marta = new Prenotazione("Marta", LocalDate.parse("11-06-2023", df), "13:00", 6, "331 5673 145");
        Prenotazione Giulia = new Prenotazione("Marco", LocalDate.parse("01-12-2023", df), "12:30", 4, "352 7623 988");
        Prenotazione Franco = new Prenotazione("Franco",LocalDate.parse("25-07-2023", df),"13:30",2,"331 7883 234");
   
        Tavolo n1 = new Tavolo(1,4);
        Tavolo n2 = new Tavolo(2,2);
        Tavolo n3 = new Tavolo(3,4);
        Tavolo n4 = new Tavolo(4,6);
        Tavolo n5 = new Tavolo(5,2);
        Tavolo n6 = new Tavolo(6,12);
       
        Ristorante Gianni= new Ristorante(Franco,n1,30);
        Ristorante Rossi= new Ristorante(Giulia,n3,30);
        Ristorante Delizia= new Ristorante(Marco,n1,30);
        Ristorante Mangia= new Ristorante(Marta,n1,30);
        
        
        
        
    }

}
