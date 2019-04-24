package com.example.wawinternet.Modeles;


public class ModelPaiement {
    private int id;

    private String quipaie;
    private String debit;
    private String reference;
    private String codecarte;

    public ModelPaiement(int id, String quipaie, String debit, String reference, String codecarte) {
        this.id = id;
        this.quipaie = quipaie;
        this.debit = debit;
        this.reference = reference;
        this.codecarte = codecarte;
    }

    public ModelPaiement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCodecarte() {
        return codecarte;
    }

    public void setCodecarte(String codecarte) {
        this.codecarte = codecarte;
    }
}
