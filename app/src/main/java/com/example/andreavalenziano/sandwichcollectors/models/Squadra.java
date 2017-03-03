package com.example.andreavalenziano.sandwichcollectors.models;

/**
 * Created by AndreaValenziano on 03/03/17.
 */
public class Squadra {

    private int idSquadra; //PK
    private String nomeSquadra; //chiave di ricerca;

    public Squadra() {
    }

    public Squadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
    }

    public int getIdSquadra() {
        return idSquadra;
    }

    public void setIdSquadra(int idSquadra) {
        this.idSquadra = idSquadra;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }


}
