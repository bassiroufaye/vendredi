package com.example.wawinternet.Modeles;

public class ModelTicket {
    private String ref;
    private String typeticket;
    private String autre;
    private String priorite;
    private String duree;


    public ModelTicket() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTypeticket() {
        return typeticket;
    }

    public void setTypeticket(String typeticket) {
        this.typeticket = typeticket;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
