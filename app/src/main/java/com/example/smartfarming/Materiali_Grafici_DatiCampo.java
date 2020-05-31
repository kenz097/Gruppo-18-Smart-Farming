package com.example.smartfarming;

public class Materiali_Grafici_DatiCampo {
    private String tipo;
    private int percentuale;

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public void setPercentuale(int percentuale){
        this.percentuale=percentuale;
    }
    public int getPercentuale(){
        return percentuale;
    }
    public Materiali_Grafici_DatiCampo(String tipo, int percentuale){
        this.tipo=tipo;
        this.percentuale=percentuale;
    }

}
