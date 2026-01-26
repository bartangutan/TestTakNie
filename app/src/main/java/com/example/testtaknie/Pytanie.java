package com.example.testtaknie;

public class Pytanie {
    private String tresc;
    private int idObrazka;
    private boolean poprawnaOdpowiedz;

    public Pytanie(String tresc, int idObrazka, boolean poprawnaOdpowiedz) {
        this.tresc = tresc;
        this.idObrazka = idObrazka;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public boolean isPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public void setPoprawnaOdpowiedz(boolean poprawnaOdpowiedz) {
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }
}
