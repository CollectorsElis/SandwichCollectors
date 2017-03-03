package com.example.andreavalenziano.sandwichcollectors.models;

/**
 * Created by AndreaValenziano on 03/03/17.
 */

public class Figurina {
    private int idFigurina; //PK

    private int numFigurina;
    private int nome; //chiave di ricerca
    private int quantita;
    private Squadra squadra;
    private String sezione; //ENUM??

    public Figurina() {

    }

    public Figurina(int numFigurina, int nome, int quantita, Squadra squadra, String sezione) {
        this.numFigurina = numFigurina;
        this.nome = nome;
        this.quantita = quantita;
        this.squadra = squadra;
        this.sezione = sezione;

    }

    public int getNome() {
        return nome;
    }


    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Squadra getSquadra() {
        return squadra;
    }


    public String getSezione() {
        return sezione;
    }

    public int getIdFigurina() {
        return idFigurina;
    }


    public int getNumFigurina() {
        return numFigurina;
    }

    public void setIdFigurina(int idFigurina) {
        this.idFigurina = idFigurina;
    }
}
