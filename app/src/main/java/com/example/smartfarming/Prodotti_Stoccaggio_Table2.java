package com.example.smartfarming;

public class Prodotti_Stoccaggio_Table2 {
    private String prodotto;
    private String media;

    public String getProdotto(){
        return prodotto;
    }
    public void setProdotto(String prodotto){
        this.prodotto=prodotto;
    }
    public String getMedia(){
        return media;
    }
    public void setMedia(String media){
        this.media=media;
    }
    public Prodotti_Stoccaggio_Table2(String prodotto, String media) {
        this.prodotto=prodotto;
        this.media=media;
    }
}
