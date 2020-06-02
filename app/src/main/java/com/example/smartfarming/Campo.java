package com.example.smartfarming;

public class Campo {
    private String nomeCampo;

    public void setNomeCampo(String nomeCampo){
        this.nomeCampo=nomeCampo;
    }
    public String getNomeCampo(){
        return nomeCampo;
    }
    public Campo(String nomeCampo){
        this.nomeCampo=nomeCampo;
    }
}
