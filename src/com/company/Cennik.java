package com.company;

import java.util.ArrayList;

public class Cennik {

    private static Cennik Inst = null;
    ArrayList<Cennik_Kino> ConstCennik = new ArrayList<>();


    public static Cennik pobierzCennik() {
        if (Inst == null) {
            Inst = new Cennik();
        }
        return Inst;
    }

    public static Cennik getInst() {
        return Inst;
    }

    public ArrayList<Cennik_Kino> getConstCennik() {
        return ConstCennik;
    }

    public void dodaj(String kategoria, String nazwa, int cena_Po, int cena_Do, int urzadzenie, int cena_z_aboniment) {
        ConstCennik.add(new Cennik_Kino(kategoria, nazwa, cena_Po, cena_Do, urzadzenie, cena_z_aboniment));
    }

    public void dodaj(String kategoria, String nazwa, int urzadzenie, int cena_Po, int cena_Do) {
        ConstCennik.add(new Cennik_Kino(kategoria, nazwa, urzadzenie, cena_Po, cena_Do));
    }

    public void dodaj(String kategoria, String nazwa, int cena_bez_aboniment, int cena_z_aboniment) {
        ConstCennik.add(new Cennik_Kino(kategoria, nazwa, cena_bez_aboniment, cena_z_aboniment));
    }

    public void dodaj(String kategoria, String nazwa) {
        ConstCennik.add(new Cennik_Kino(kategoria, nazwa));
    }
}

class Cennik_Kino{
    private String kategoria;
    private String nazwa;
    private int urzadzenie; // 3 za 12
    private int cena_z_aboniment; // 5 zl
    private int cena_Do; // 4 zl za jeden (bez abonimentu)
    private int cena_Po; // 6 zl za jeden (bez abonimentu)
    private int cena_bez_aboniment;
    private int CENA;

    public int getCENA() {
        return CENA;
    }

    public Cennik_Kino(String kategoria, String nazwa, int urzadzenie, int cena_z_aboniment, int cena_Do, int cena_Po) {
        this.kategoria = kategoria;
        this.nazwa = nazwa;
        this.urzadzenie = urzadzenie;
        this.cena_z_aboniment = cena_z_aboniment;
        this.cena_Do = cena_Do;
        this.cena_Po = cena_Po;
    }


    public Cennik_Kino(String kategoria, String nazwa, int urzadzenie, int cena_po, int cena_do) {
        this.kategoria = kategoria;
        this.nazwa = nazwa;
        this.urzadzenie = urzadzenie;
        this.cena_Po = cena_po;
        this.cena_Do = cena_do;
    }

    public Cennik_Kino(String kategoria, String nazwa, int cena_bez_aboniment, int cena_z_aboniment) {
        this.kategoria = kategoria;
        this.nazwa = nazwa;
        this.cena_bez_aboniment = cena_bez_aboniment;
        this.cena_z_aboniment = cena_z_aboniment;
    }

    public Cennik_Kino(String kategoria, String nazwa) {
        this.kategoria = kategoria;
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getUrzadzenie() {
        return urzadzenie;
    }

    public int getCena_z_aboniment() {
        return cena_z_aboniment;
    }

    public int getCena_Do() {
        return cena_Do;
    }

    public int getCena_Po() {
        return cena_Po;
    }

    public int getCena_bez_aboniment() {
        return cena_bez_aboniment;
    }

    public boolean CheckFilm(All_Kategores kategores) {
        return (this.nazwa.equals(kategores.getNazwa()) && (this.urzadzenie == kategores.getUrzadzenie()));
    }
}
