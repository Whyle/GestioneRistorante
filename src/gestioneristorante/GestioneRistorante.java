/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import gestioneristorante.Archivio.Piatti;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author qiuyu
 */
public class GestioneRistorante {

    /**
     * Lista del ristorante che presente nella nostra sistema
     */
    public static ArrayList<Ristorante> lista_dei_ristorante = new ArrayList<Ristorante>();

    public static Ristorante ristoranteAttuale = null;

    private static Scanner scan;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        loadTest();
        menu();

    }

    public static void menu() {
        System.out.println("------------------");
        System.out.println("0) Aggiunge ristorente");
        System.out.println("1) Seleziona un ristorante");
        System.out.println("2) Exit");
        System.out.println("------------------");
        int selta = scan.nextInt();
        scan.nextLine();

        switch (selta) {
            case 0:
                aggiungeRistorante();
                menu();
                break;

            case 1:
                ristoranteAttuale = selezionaRistorante();
                gestioneRistorante();
                break;
        }
        // exit
    }

    public static void gestioneRistorante() {
        System.out.println("------------------");
        System.out.println(ristoranteAttuale.getNome() + " - " + ristoranteAttuale.getNTavoli());
        System.out.println("------------------");
        System.out.println("0) Aggiunge un prenotazione");
        System.out.println("1) Elimina un prenotazione");
        System.out.println("2) Gestire un tavolo");
        System.out.println("3) Indietro");
        System.out.println("------------------");
        int selta = scan.nextInt();
        scan.nextLine();

        switch (selta) {
            case 0:
                aggiungePrenotazione();
                gestioneRistorante();
                break;

            case 1:
                eliminaPrenotazione();
                gestioneRistorante();
                break;

            case 2:
                gestrioneTavolo();
                gestioneRistorante();
                break;

        }

    }

    public static void aggiungePrenotazione() {
        if (ristoranteAttuale.getListaDeiTavoli().size() == ristoranteAttuale.getNTavoli()) {
            System.out.println("I tavoli sono tutti occupati.");
            return;
        }
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Date: ");
        String date = scan.nextLine();
        System.out.print("Ore: ");
        String ore = scan.nextLine();
        System.out.print("Quanti: ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Numero telefono: ");
        String numero = scan.nextLine();

        Prenotazione nuovoPrenotazione = new Prenotazione(nome, date, ore, n, numero);
        ristoranteAttuale.nuovoPrenotazione(nuovoPrenotazione);
        System.out.println("--- OK ---");
    }

    public static void eliminaPrenotazione() {
        ArrayList<Prenotazione> listaPrenotazione = ristoranteAttuale.getTuttiPrenotazione();
        for (int i = 0; i < listaPrenotazione.size(); i++) {
            System.out.println(i + ") " + listaPrenotazione.get(i).getNome());
        }
        System.out.println(listaPrenotazione.size() + ") Indietro");
        int scelta;
        do {
            System.out.print("Inserisci opzione: ");
            scelta = scan.nextInt();
            scan.nextLine();
            if (scelta == listaPrenotazione.size()) {
                return;
            }
        } while (scelta < 0 || scelta >= listaPrenotazione.size());

        ristoranteAttuale.cancelaPrenotazione(listaPrenotazione.get(scelta));
        System.out.println("--- OK ---");
    }

    public static void gestrioneTavolo() {
        ArrayList<Tavolo> listaTavolo = ristoranteAttuale.getListaDeiTavoli();
        for (int i = 0; i < listaTavolo.size(); i++) {
            if (listaTavolo.get(i).getStatoOccupazione())
                System.out.println(i + ") OCCUPATO");
            else
                System.out.println(i + ") LIBERO");
        }

        System.out.println(listaTavolo.size() + ") Indietro");

        int scelta;
        do {
            System.out.print("Inserisci opzione: ");
            scelta = scan.nextInt();
            scan.nextLine();
            if (scelta == listaTavolo.size()) {
                return;
            }
        } while (scelta < 0 || scelta >= listaTavolo.size());

        gestioneTavolo(listaTavolo.get(scelta));
    }

    public static void gestioneTavolo(Tavolo tavolo) {
        System.out.println("------------------");
        System.out.println(ristoranteAttuale.getNome() + " - TAVOLO: " + tavolo.getNTavoli());
        System.out.println("------------------");
        System.out.println("0) Aggiunge un piatto");
        System.out.println("1) Elimina un piatto");
        System.out.println("2) Saldo");
        System.out.println("3) Indietro");
        System.out.println("------------------");
        int selta = scan.nextInt();
        scan.nextLine();

        switch (selta) {
            case 0:
                System.out.println("0) Pasta al sugo");
                System.out.println("1) Polpettone di carne");
                System.out.println("2) Pizza");
                System.out.println("3) risotto");
                System.out.println("4) spaghetti alla carbonara");
                System.out.println("5) ragù alla bolognese");
                System.out.println("6) Indietro");
                System.out.println("------------------");
                int pt = scan.nextInt();
                scan.nextLine();
                switch (pt) {
                    case 0:
                        tavolo.aggiungePiatto(Piatti.PS);
                        break;
                    case 1:
                        tavolo.aggiungePiatto(Piatti.PC);
                        break;
                    case 2:
                        tavolo.aggiungePiatto(Piatti.PZ);
                        break;
                    case 3:
                        tavolo.aggiungePiatto(Piatti.RI);
                        break;
                    case 4:
                        tavolo.aggiungePiatto(Piatti.SC);
                        break;
                    case 5:
                        tavolo.aggiungePiatto(Piatti.RB);
                        break;
                }
                gestioneTavolo(tavolo);
                break;

            case 1:
                ArrayList<Piatti> listaPiatti = tavolo.getListaPiatti();
                for (int i = 0; i < listaPiatti.size(); i++)
                    System.out.println(i + ") " + listaPiatti.get(i).nome);
                System.out.println(listaPiatti.size() + ") Indietro");
                System.out.println("------------------");
                int scelta;
                do {
                    System.out.print("Inserisci opzione: ");
                    scelta = scan.nextInt();
                    scan.nextLine();
                    if (scelta == listaPiatti.size()) {
                        break;
                    }
                } while (scelta < 0 || scelta >= listaPiatti.size());
                listaPiatti.remove(scelta);
                System.out.println("--- OK ---");
                gestioneTavolo(tavolo);
                break;

            case 2:
                ArrayList<Piatti> listaPiatti2 = tavolo.getListaPiatti();
                float totale = 0;
                for (int i = 0; i < listaPiatti2.size(); i++) {
                    System.out.println(i + ") " + listaPiatti2.get(i).nome);
                    totale += listaPiatti2.get(i).prezzo;
                }
                System.out.println("------------------");
                System.out.println("Totale: " + totale);
                break;

        }

    }

    public static void aggiungeRistorante() {
        System.out.print("Inserisci nome del ristorante: ");
        String nome = scan.nextLine();
        int ntavolo;
        do {
            System.out.print("Inserisci numero di tavolo disponibile: ");
            ntavolo = scan.nextInt();
            scan.nextLine();
        } while (ntavolo <= 0);
        Ristorante nuovoRistorante = new Ristorante(nome, ntavolo);
        lista_dei_ristorante.add(nuovoRistorante);
        System.out.println("---Aggiunto con sucesso---");
    }

    public static Ristorante selezionaRistorante() {
        System.out.println("---- lista dei ristoranti ----");
        for (int i = 0; i < lista_dei_ristorante.size(); i++) {
            System.out.println(i + ")" + lista_dei_ristorante.get(i).getNome());
        }
        System.out.println("Non ci sono ristorante");
        return null;
    }

    public static void loadTest() {
        // creazione di un ristorante
        Ristorante ristoranteTest = new Ristorante("RISTORANTE DI TEST", 30);
        lista_dei_ristorante.add(ristoranteTest);

        // aggiunge dei prenotazione
        Prenotazione pre1 = new Prenotazione("Mario Rossi", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3203203200");
        Prenotazione pre2 = new Prenotazione("Maria Riva", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3303303300");
        Prenotazione pre3 = new Prenotazione("Marco Colombo", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3403403400");
        Prenotazione pre4 = new Prenotazione("Luca Magni", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3403403400");

        ristoranteTest.nuovoPrenotazione(pre1);
        ristoranteTest.nuovoPrenotazione(pre2);
        ristoranteTest.nuovoPrenotazione(pre3);
        ristoranteTest.nuovoPrenotazione(pre4);

        Tavolo tavoloPre1 = ristoranteTest.getTavolo(pre1);
        Tavolo tavoloPre2 = ristoranteTest.getTavolo(pre2);
        Tavolo tavoloPre3 = ristoranteTest.getTavolo(pre3);
        Tavolo tavoloPre4 = ristoranteTest.getTavolo(pre4);

        tavoloPre1.aggiungePiatto(Piatti.PC);
        tavoloPre1.aggiungePiatto(Piatti.PZ);
        tavoloPre2.aggiungePiatto(Piatti.RI);
        tavoloPre2.aggiungePiatto(Piatti.RB);

        // creazione di un ristorante
        Ristorante ristoranteTest2 = new Ristorante("RISTORANTE DI TEST 2", 15);
        lista_dei_ristorante.add(ristoranteTest2);

        // aggiunge dei prenotazione
        Prenotazione pre12 = new Prenotazione("Roberto Rossi", LocalDate.now().toString(), LocalTime.now().toString(),
                2, "3200000000");
        Prenotazione pre22 = new Prenotazione("Maria Motta", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3300000000");
        Prenotazione pre32 = new Prenotazione("Elena Colombo", LocalDate.now().toString(), LocalTime.now().toString(),
                2, "3400000000");
        Prenotazione pre42 = new Prenotazione("Luigi Magni", LocalDate.now().toString(), LocalTime.now().toString(), 2,
                "3500000000");

        ristoranteTest2.nuovoPrenotazione(pre12);
        ristoranteTest2.nuovoPrenotazione(pre22);
        ristoranteTest2.nuovoPrenotazione(pre32);
        ristoranteTest2.nuovoPrenotazione(pre42);

        Tavolo tavoloPre12 = ristoranteTest.getTavolo(pre12);
        Tavolo tavoloPre22 = ristoranteTest.getTavolo(pre22);
        Tavolo tavoloPre32 = ristoranteTest.getTavolo(pre32);
        Tavolo tavoloPre42 = ristoranteTest.getTavolo(pre42);

        tavoloPre12.aggiungePiatto(Piatti.RI);
        tavoloPre42.aggiungePiatto(Piatti.RB);

        System.out.println("Parametri di prova sono caricati con sucesso.");
    }

}
