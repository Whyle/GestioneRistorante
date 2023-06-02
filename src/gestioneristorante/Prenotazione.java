/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneristorante;

import myexceptions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author qiuyu
 */
public class Prenotazione {

    private String nome;
    private LocalDate data_di_prenotazione;
    private LocalTime ora_di_prenotazione;
    private int n_persone;
    private String n_telefono;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALY);

    /**
     * costruttore di default: inizializzo nome,la data di prenotazione, ora di
     * prenotazione, il numero di prenotazione e il numero di telefono
     */
    public Prenotazione() {
        this.nome = "";
        this.data_di_prenotazione = LocalDate.parse("01-01-2023", DATE_FORMAT);
        this.ora_di_prenotazione = LocalTime.parse("HH:mm", DATE_FORMAT);
        this.n_persone = 0;
        this.n_telefono = "";

    }

    /**
     * costruttore parametrico
     *
     * @param nome nome
     * @param data_di_prenotazione data di prenotazione
     * @param ora_di_prenotazione ora di prenotazione
     * @param n_persone numero di persone al tavolo
     * @param n_telefono numero di telefono
     */
    public Prenotazione(String nome, LocalDate data_di_prenotazione,
            String ora_di_prenotazione, int n_persone, String n_telefono) {

        this.nome = nome;
        this.data_di_prenotazione = LocalDate.parse("01-01-2023", DATE_FORMAT);
        this.ora_di_prenotazione = LocalTime.parse("13:00", DATE_FORMAT);
        this.n_persone = n_persone;
        this.n_telefono = n_telefono;
    }

    /**
     * metodo get nome
     *
     * @return attributo nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * metodo set nome
     *
     * @param nome nome
     * @throws PrenotazioneEccezioni da lanciare in caso il nome sia vuoto
     */
    public void setNome(String nome) throws PrenotazioneEccezioni {
        if (nome.isEmpty()) {
            throw new PrenotazioneEccezioni(PrenotazioneEccezioni.CODE_NOME_VUOTO);
        } else {
            this.nome = nome;
        }
    }

    /**
     * metodo get data di prenotazione
     *
     * @return data di prenotazione
     */
    public LocalDate getDataDiPrenotazione() {
        return data_di_prenotazione;
    }

    /**
     * metodo set numero di prenotazione
     *
     * @param data_di_prenotazione numero di prenotazione
     */
    public void setDataDiPrenotazione(LocalDate data_di_prenotazione) {
        this.data_di_prenotazione = data_di_prenotazione;
    }

    /**
     * metodo get ora di prenotazione
     *
     * @return ora di prenotazione
     */
    public LocalTime getOraDiPrenotazione() {
        return ora_di_prenotazione;
    }

    /**
     * metodo set ora di prenotazione
     *
     * @param ora_di_prenotazione numero di prenotazione
     */
    public void setOraDiPrenotazione(LocalTime ora_di_prenotazione) {
        this.ora_di_prenotazione = ora_di_prenotazione;
    }

    /**
     * metodo get numero di telefono
     *
     * @return il numero di telefono del cliente
     */
    public String getNTelefono() {
        return n_telefono;
    }

    /**
     * metodo set numero telefono
     *
     * @param n_telefono il numero di telefono
     * @throws PrenotazioneEccezioni da lanciare in caso il numero di telefono
     * non sia valida
     */
    public void setNTelefono(String n_telefono) throws PrenotazioneEccezioni {
        if (n_telefono.isEmpty() || n_telefono.length() < 10) {
            throw new PrenotazioneEccezioni(PrenotazioneEccezioni.CODE_NUMERO_ERRORE);
        } else {
            this.n_telefono = n_telefono;
        }

    }

    /**
     * costruttore di copia
     *
     * @param c cliente di cui fare la copia
     */
    public Prenotazione(Prenotazione c) {
        this.nome = c.nome;
        this.data_di_prenotazione = c.data_di_prenotazione;
        this.ora_di_prenotazione = c.ora_di_prenotazione;
        this.n_persone = c.n_persone;
        this.n_telefono = c.n_telefono;
    }

    /**
     * metoto toString
     *
     * @return nome,data di prenotazione ,ora di prenotazione, numero di
     * persone, numero di telefono
     */
    @Override
    public String toString() {
        return "Prenotazione{" + "nome=" + nome + ", data_di_prenotazione=" + data_di_prenotazione + ", ora_di_prenotazione=" + ora_di_prenotazione + ", n_persone=" + n_persone + ", n_telefono=" + n_telefono + '}';
    }

    /**
     * metodo equals che confronta se i due prenotati sono uguali o no
     *
     * @param p prenotato da confrontare
     * @return se i prenotati sono uguali o no
     */
    public boolean equals(Prenotazione p) {
        return this.nome == p.nome;
    }

}
