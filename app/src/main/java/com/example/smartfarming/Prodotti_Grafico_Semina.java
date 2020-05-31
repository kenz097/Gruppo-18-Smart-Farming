package com.example.smartfarming;

public class Prodotti_Grafico_Semina {
    String prodotto;
    int percentuale;

    public void setProdotto(String prodotto){
        this.prodotto=prodotto;
    }
    public String getProdotto(){
        return prodotto;
    }
    public void setPercentuale(int percentuale){
        this.percentuale=percentuale;
    }
    public int getPercentuale(){
        return percentuale;
    }
    public Prodotti_Grafico_Semina(String prodotto, int percentuale){
        this.prodotto=prodotto;
        this.percentuale=percentuale;
    }

}
