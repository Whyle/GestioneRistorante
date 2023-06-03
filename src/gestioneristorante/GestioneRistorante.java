/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import gestioneristorante.Archivio.Piatti;

import java.util.Scanner;

/**
 *
 * @author qiuyu
 */
public class GestioneRistorante {

    /**
     * Lista del ristorante che presente nella nostra sistema
     */
    
    public static Ristorante[] lista_dei_ristorante;

    private static Scanner scan;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        lista_dei_ristorante = new Ristorante[Funzioni.MAX_RISTORANTE];



        loadTest();
        menu();

    }



    public static void menu() {
        System.out.println("------------------");
        System.out.println("0) Aggiunge ristorente");
        System.out.println("1) Seleziona un ristorante");
        System.out.println("2) Elimina un ristorante");
        System.out.println("3) Exit");
        System.out.println("------------------");
        int selta = scan.nextInt();
        scan.nextLine();

        switch (selta) {
            case 0: /* Aggiunge ristorente */
                if(Funzioni.contaRistorante(lista_dei_ristorante) != Funzioni.MAX_RISTORANTE){
                    aggiungeRistorante();
                }else{
                    System.out.println("Non e' piu' possibile di aggiungere ristorante.");
                }
                // torna menu
                menu();
                break;

            case 1: /* Seleziona un ristorante */
                if(Funzioni.contaRistorante(lista_dei_ristorante) != 0){
                    Ristorante ristorante = selezionaRistorante();
                    if(ristorante != null)
                        gestioneRistorante(ristorante);
                }else{
                    System.out.println("Non c'e' nessun ristorante.");
                }
                // torna menu
                menu();
                break;
            case 2: /* Elimina un ristorante */
                // stampa a video tutti i ristorante disponibile
                for(int i = 0; i < Funzioni.MAX_RISTORANTE; i ++){
                    if(lista_dei_ristorante[i] != null)
                        System.out.println(i + ") " + lista_dei_ristorante[i].getNome());
                }
                int scelta = Funzioni.scelta(scan);
                if(scelta < 0 || scelta >= Funzioni.MAX_RISTORANTE){
                    System.out.println("Numero scelto non valido.");
                }else{
                    // spostare gli elementi a destra del scelta a un posizione a sinistra
                    for(int i = scelta; i < Funzioni.MAX_RISTORANTE-1; i++){
                        lista_dei_ristorante[i] = lista_dei_ristorante[i+1];
                    }
                    // per non far copiare out of range
                    lista_dei_ristorante[Funzioni.MAX_RISTORANTE-1] = null;
                }
                // torna menu
                menu();
                break;

        }
        // exit
    }

    public static void gestioneRistorante(Ristorante ristorante) {
        System.out.println("------------------");
        System.out.println(ristorante.getNome() + " - Capienza: " + ristorante.getNTavoli());
        System.out.println("------------------");
        System.out.println("0) Aggiunge un prenotazione");
        System.out.println("1) Elimina un prenotazione");
        System.out.println("2) Gestire un tavolo");
        System.out.println("3) Indietro");
        System.out.println("------------------");
        int selta = scan.nextInt();
        scan.nextLine();

        switch (selta) {
            case 0: /* Aggiunge un prenotazione */
                aggiungePrenotazione(ristorante);
                gestioneRistorante(ristorante);
                break;

            case 1: /* Elimina un prenotazione */
                eliminaPrenotazione(ristorante);
                gestioneRistorante(ristorante);
                break;

            case 2: /* Gestire un tavolo */
                gestrioneTavolo(ristorante);
                gestioneRistorante(ristorante);
                break;

        }

    }

    public static void aggiungePrenotazione(Ristorante ristorante) {
        if (Funzioni.contaPostiOccuppati(ristorante.getListaDeiTavoli()) == ristorante.getNTavoli()) {
            System.out.println("I tavoli sono tutti occuppati.");
            return;
        }
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Date(dd-MM-yyyy): ");
        String date = scan.nextLine();
        System.out.print("Ore: ");
        String ore = scan.nextLine();
        System.out.print("Quanti: ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Numero telefono: ");
        String numero = scan.nextLine();

        Prenotazione nuovoPrenotazione = new Prenotazione(nome, date, ore, n, numero);
        ristorante.nuovoPrenotazione(nuovoPrenotazione);
        System.out.println("--- OK ---");
    }

    public static void eliminaPrenotazione(Ristorante ristorante) {
        Prenotazione[] listaPrenotazione = ristorante.getTuttiPrenotazione();
        for (int i = 0; i < listaPrenotazione.length; i++) {
            if(listaPrenotazione[i] != null)
                System.out.println(i + ") " + listaPrenotazione[i].getNome());
        }
        System.out.println(listaPrenotazione.length + ") Indietro");
        
        int scelta = Funzioni.scelta(scan);
        if (scelta == listaPrenotazione.length) {
            return; /* Indietro */
        }
        if(scelta < 0 || scelta >= listaPrenotazione.length){
            System.out.println("La scelta non e' valida");
            return; /* back */
        }

        ristorante.cancelaPrenotazione(listaPrenotazione[scelta]);
        
    }

    public static void gestrioneTavolo(Ristorante ristorante) {
        Tavolo[] listaTavolo = ristorante.getListaDeiTavoli();
        System.out.println("------------------");
        for (int i = 0; i < listaTavolo.length; i++) {
            if (listaTavolo[i].isOccuppato())
                System.out.println(i + ") " + listaTavolo[i].getPrenotazione().getNome());
            else
                System.out.println(i + ") LIBERO");
        }
        System.out.println("------------------");
        System.out.println(listaTavolo.length + ") Indietro");
       
        int scelta = Funzioni.scelta(scan);
        if (scelta == listaTavolo.length) {
            return; /* Indietro */
        }
        if(scelta < 0 || scelta >= listaTavolo.length){
            System.out.println("La scelta non e' valida");
            return; /* back */
        }
        if(listaTavolo[scelta].isOccuppato())
            gestioneTavolo(ristorante, listaTavolo[scelta]);
        else 
            System.out.println("Non puoi gestire questa tavolo.");
    }

    public static void gestioneTavolo(Ristorante ristorante, Tavolo tavolo) {
        System.out.println("------------------");
        System.out.println(ristorante.getNome() + " - TAVOLO: " + tavolo.getNTavoli());
        System.out.println("------------------");
        System.out.println("0) Aggiunge un piatto");
        System.out.println("1) Elimina un piatto");
        System.out.println("2) Saldo");
        System.out.println("3) Indietro");
        System.out.println("------------------");
        int selta = Funzioni.scelta(scan);

        switch (selta) {
            case 0: /* Aggiunge un piatto */
                aggiungerePiatto(tavolo);
                gestioneTavolo(ristorante, tavolo);
                break;

            case 1: /* Elimina un piatto */
                Piatti[] listaPiatti = tavolo.getListaPiatti();
                for (int i = 0; i < listaPiatti.length; i++){
                    if(listaPiatti[i] != null)
                        System.out.println(i + ") " + listaPiatti[i].nome);
                }
                System.out.println(listaPiatti.length + ") Indietro");
                System.out.println("------------------");
                int scelta = Funzioni.scelta(scan);
                if (scelta == listaPiatti.length) {
                    gestioneTavolo(ristorante, tavolo);
                    break; /* Indietro */
                }
                if(scelta < 0 || scelta >= listaPiatti.length){
                    System.out.println("La scelta non e' valida");
                    gestioneTavolo(ristorante, tavolo);
                    break; /* back */
                }
                tavolo.rimuoverePiatto(scelta);

                gestioneTavolo(ristorante, tavolo);
                break;

            case 2: /* Saldo */
                Piatti[] listaPiatti2 = tavolo.getListaPiatti();
                float totale = 0;
                for (int i = 0; i < listaPiatti2.length; i++) {
                    if(listaPiatti2[i] != null){
                        System.out.println(i + ") " + listaPiatti2[i].nome);
                        totale += listaPiatti2[i].prezzo;
                    }
                }
                System.out.println("------------------");
                System.out.println("Totale: " + totale);
                System.out.println("------------------");
                System.out.println("TAVOLO CHIUSO");
                System.out.println("------------------");

                ristorante.cancelaPrenotazione(tavolo.getPrenotazione());
                break;

        }

    }

    public static void aggiungerePiatto(Tavolo tavolo){
        System.out.println("0) Pasta al sugo");
        System.out.println("1) Polpettone di carne");
        System.out.println("2) Pizza");
        System.out.println("3) risotto");
        System.out.println("4) spaghetti alla carbonara");
        System.out.println("5) ragù alla bolognese");
        System.out.println("6) Indietro");
        System.out.println("------------------");
        int pt = Funzioni.scelta(scan);

        switch (pt) {
            case 0:
                tavolo.aggiungePiatto(Piatti.PS);
                break; /* continua eseguire dopo il switch */
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
            case 6:
                return;
            default:
                System.out.println("La scelta non valida.");
                return; /* esce dal aggiungerePiatto*/
        }
        System.out.println("--- OK ---");
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
        for(int i = 0; i < Funzioni.MAX_RISTORANTE; i++)
        {
            if(lista_dei_ristorante[i]==null){
                lista_dei_ristorante[i] = nuovoRistorante;
                break;
            }
        }
       
        System.out.println("--- OK ---");
    }

    public static Ristorante selezionaRistorante() {
        System.out.println("---- lista dei ristoranti ----");
        for (int i = 0; i < Funzioni.MAX_RISTORANTE; i++) {
            if(lista_dei_ristorante[i] != null)
                System.out.println(i + ")" + lista_dei_ristorante[i].getNome());
        }

        int scelta = Funzioni.scelta(scan);
        if(scelta < 0 || scelta >= Funzioni.MAX_RISTORANTE){
            System.out.println("La scelta non e' valida.");
            return null;
        }else{
            if(lista_dei_ristorante[scelta] == null){
                System.out.println("La scelta non e' valida.");
                return null;
            }else{
                return lista_dei_ristorante[scelta];
            }
        }
    }

    public static void loadTest() {
        // creazione di un ristorante
        Ristorante ristoranteTest = new Ristorante("RISTORANTE DI TEST", 30);
        lista_dei_ristorante[0] = ristoranteTest;

        // aggiunge dei prenotazione
        Prenotazione pre1 = new Prenotazione("Mario Rossi", "01-06-2023", "18:00", 2,
                "3203203200");
        Prenotazione pre2 = new Prenotazione("Maria Riva", "01-06-2023", "18:00", 2,
                "3303303300");
        Prenotazione pre3 = new Prenotazione("Marco Colombo", "01-06-2023", "18:00", 2,
                "3403403400");
        Prenotazione pre4 = new Prenotazione("Luca Magni", "01-06-2023", "18:00", 2,
                "3403403400");

        ristoranteTest.nuovoPrenotazione(pre1);
        ristoranteTest.nuovoPrenotazione(pre2);
        ristoranteTest.nuovoPrenotazione(pre3);
        ristoranteTest.nuovoPrenotazione(pre4);

        Tavolo tavoloPre1 = ristoranteTest.getTavolo(pre1);
        Tavolo tavoloPre2 = ristoranteTest.getTavolo(pre2);
        //Tavolo tavoloPre3 = ristoranteTest.getTavolo(pre3);
        //Tavolo tavoloPre4 = ristoranteTest.getTavolo(pre4);

        tavoloPre1.aggiungePiatto(Piatti.PC);
        tavoloPre1.aggiungePiatto(Piatti.PZ);
        tavoloPre2.aggiungePiatto(Piatti.RI);
        tavoloPre2.aggiungePiatto(Piatti.RB);

        // creazione di un ristorante
        Ristorante ristoranteTest2 = new Ristorante("RISTORANTE DI TEST 2", 15);
        lista_dei_ristorante[1] = ristoranteTest2;

        // aggiunge dei prenotazione
        Prenotazione pre12 = new Prenotazione("Roberto Rossi", "01-06-2023" , "18:00",
                2, "3200000000");
        Prenotazione pre22 = new Prenotazione("Maria Motta", "01-06-2023","18:00", 2,
                "3300000000");
        Prenotazione pre32 = new Prenotazione("Elena Colombo", "01-06-2023", "18:00",
                2, "3400000000");
        Prenotazione pre42 = new Prenotazione("Luigi Magni", "01-06-2023", "18:00", 2,
                "3500000000");

        ristoranteTest2.nuovoPrenotazione(pre12);
        ristoranteTest2.nuovoPrenotazione(pre22);
        ristoranteTest2.nuovoPrenotazione(pre32);
        ristoranteTest2.nuovoPrenotazione(pre42);




        Tavolo tavoloPre12 = ristoranteTest2.getTavolo(pre12);
        //Tavolo tavoloPre22 = ristoranteTest2.getTavolo(pre22);
        //Tavolo tavoloPre32 = ristoranteTest2.getTavolo(pre32);
        Tavolo tavoloPre42 = ristoranteTest2.getTavolo(pre42);

        tavoloPre12.aggiungePiatto(Piatti.RI);
        tavoloPre42.aggiungePiatto(Piatti.RB);

        System.out.println("Parametri di prova sono caricati con sucesso.");
    }

}
