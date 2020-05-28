package com.example.smartfarming;

public class Quantità_Stoccaggio {
    private String nomeProdotto;
    private int posizione;
    private int quantita;
    private int numProdotti;

    public String getNomeProdotto(){
        return nomeProdotto;
    }
    public void setNomeProdotto(String nomeProdotto){
        this.nomeProdotto=nomeProdotto;
    }
    public int getPosizione(){
        return posizione;
    }
    public void setPosizione(int posizione){
        this.posizione=posizione;
    }
    public int getQuantita(){
        return quantita;
    }
    public void setQuantita(int quantita){
        this.quantita=quantita;
    }
    public int getNumProdotti(){
        return numProdotti;
    }
    public void setNumProdotti(int numProdotti){
        this.numProdotti=numProdotti;
    }
    public Quantità_Stoccaggio(String nomeProdotto, int posizione, int quantita, int numProdotti){
        this.nomeProdotto=nomeProdotto;
        this.posizione=posizione;
        this.quantita=quantita;
        this.numProdotti=numProdotti;
    }
}

