package com.example.wawinternet.Modeles;


import android.content.Intent;

public class  ModelPaiement {
    private Integer id;
    private String quipaie;
    private String debit;
    private int Abonnement_id;
    private int codecarte;

    public ModelPaiement() {

    }



    public String getQuipaie() {
        return quipaie;
    }

    public void setQuipaie(String quipaie) {
        this.quipaie = quipaie;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public int getAbonnement_id() {
        return Abonnement_id;
    }

    public void setAbonnement_id(int Abonnement_id) {
        this.Abonnement_id = Abonnement_id;
    }

    public int getCodecarte() {
        return codecarte;
    }

    public void setCodecarte(int codecarte) {
        this.codecarte = codecarte;
    }

    public int getId() {
        return id;
    }
}
