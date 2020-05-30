package com.example.smartfarming;

public class Prodotti_Semina_Table1 {
    private String nomeProdotto;
    private String percentuale;

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(String percentuale) {
        this.percentuale = percentuale;
    }
    public Prodotti_Semina_Table1(String nomeProdotto, String percentuale){
        this.nomeProdotto=nomeProdotto;
        this.percentuale=percentuale;
    }
}
