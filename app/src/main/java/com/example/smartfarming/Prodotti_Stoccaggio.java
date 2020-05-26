package com.example.smartfarming;

public class Prodotti_Stoccaggio {
        private String nomeProdotto;
        private String stato;

        public String getNomeProdotto(){
            return nomeProdotto;
        }
        public void setNomeProdotto(String nomeProdotto){
            this.nomeProdotto=nomeProdotto;
        }
        public String getStato(){
            return stato;
        }
        public void setStato(String stato){
            this.stato=stato;
        }

        public Prodotti_Stoccaggio(String nomeProdotto, String stato){
            this.nomeProdotto=nomeProdotto;
            this.stato=stato;
        }
}
