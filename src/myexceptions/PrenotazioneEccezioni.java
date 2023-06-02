/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexceptions;

/**
 *
 * @author qiuyu
 */
public class PrenotazioneEccezioni extends Exception {

    public static final int CODE_NOME_VUOTO = 1001;
    public static final int CODE_NUMERO_ERRORE = 1002;
    public static final int CODE_MAX_PRENOTATI = 30;

    private int code;

    public PrenotazioneEccezioni(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        switch (code) {
            case CODE_NOME_VUOTO:
                return "il nome non può essere vuoto.";
            case CODE_NUMERO_ERRORE:
                return "il numero di telefono non è corretto.";
            case CODE_MAX_PRENOTATI:
                return "hai raggiunto il numero massimo di prenotazione";
            default:
                return "Errore nell'inserimento del data.";
        }
    }
}
