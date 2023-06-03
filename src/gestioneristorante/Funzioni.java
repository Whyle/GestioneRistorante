package gestioneristorante;

import java.util.Scanner;

public class Funzioni {

    public static final int MAX_RISTORANTE = 5;

    public static int contaRistorante(Ristorante[] lista_dei_ristorante){
        int numero_del_ristorante = 0;
        for(int i = 0; i < MAX_RISTORANTE; i++){
            if(lista_dei_ristorante[i]!=null)
                numero_del_ristorante++;
        }
        return numero_del_ristorante;
    }

    public static int scelta(Scanner scan){
        System.out.print("> ");
        int scelta = scan.nextInt();
        scan.nextLine();
        return scelta;
    }

    public static int contaPostiOccuppati(Tavolo[] listaDeiTavoli) {
        int counta = 0;
        for(int i = 0; i < listaDeiTavoli.length; i++){
            if(listaDeiTavoli[i].isOccuppato()){
                counta++;
            }
        }
        return counta;
    }




    
}
