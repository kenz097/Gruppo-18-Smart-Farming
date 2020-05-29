package com.example.smartfarming;

public class Quantita_Raccolta_Table {
    private String nomeProdotto;
    private String posizione;
    private String quantita;
    private String numProdotti;

    public String getNomeProdotto(){
        return nomeProdotto;
    }
    public void setNomeProdotto(String nomeProdotto){
        this.nomeProdotto=nomeProdotto;
    }
    public String getPosizione(){
        return posizione;
    }
    public void setPosizione(String posizione){
        this.posizione=posizione;
    }
    public String getQuantita(){
        return quantita;
    }
    public void setQuantita(String quantita){
        this.quantita=quantita;
    }
    public String getNumProdotti(){
        return numProdotti;
    }
    public void setNumProdotti(String numProdotti){
        this.numProdotti=numProdotti;
    }

    public Quantita_Raccolta_Table(String nomeProdotto, String posizione, String quantita, String numProdotti){

        this.nomeProdotto=nomeProdotto;
        this.posizione=posizione;
        this.quantita=quantita;
        this.numProdotti=numProdotti;
    }

}

