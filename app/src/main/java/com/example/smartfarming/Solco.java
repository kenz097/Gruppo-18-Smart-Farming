package com.example.smartfarming;

public class Solco {
    public Solco(String solco,String profondita){
         this.solco=solco;
         this.profondita=profondita;
    }

    public String getProfondita() {
        return profondita;
    }

    public void setProfondita(String profondita) {
        this.profondita = profondita;
    }

    public void setNomeSolco(String solco) {
        this.solco = solco;
    }

    public String getNomeSolco() {
        return solco;
    }

    private String solco;
    private String profondita;
}

