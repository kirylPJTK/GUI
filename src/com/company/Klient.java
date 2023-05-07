package com.company;

import java.util.ArrayList;

public class Klient extends Cennik{
    String klient_name;
    private double kwota;
    private boolean aboniment;
    ListaZyczen listaZyczen;
    Koszyk koszyk_klient;

    public Klient(String klient_name, int kwota, boolean aboniment) {
        this.klient_name = klient_name;
        this.kwota = kwota;
        this.aboniment = aboniment;
        listaZyczen = new ListaZyczen(new ArrayList<All_Kategores>());
        listaZyczen.klient1 = this;
    }

    public void dodaj(All_Kategores kategore) {
        listaZyczen.add(kategore);
    }

    public ListaZyczen pobierzListeZyczen() {
        return listaZyczen;
    }

    public static ArrayList<All_Kategores> CheckKategores(ArrayList<All_Kategores> check_k) {
        ArrayList<All_Kategores> kategor_this = new ArrayList<>();
        for (All_Kategores k : check_k) {
            for (Cennik_Kino c : pobierzCennik().ConstCennik) {
                if (c.CheckFilm(k) && c.getCENA() != -1)
                    kategor_this.add(k);
            }
        }
        return kategor_this;
    }

    public void przepakuj(Koszyk koszyk) {
        this.koszyk_klient = koszyk;
        ArrayList<All_Kategores> kateres_prepak = CheckKategores(listaZyczen);
        koszyk.koszyk_room.addAll(kateres_prepak);
        listaZyczen.removeAll(kateres_prepak);
    }

    public void zaplac(String metoda_platnosci, boolean enough) {
        if (metoda_platnosci == "karta") {
            kwota = kwota - kwota*0.2;
        }
        ArrayList<All_Kategores> delet_elem = new ArrayList<>();
        for (Cennik_Kino cennik_kino : Cennik.pobierzCennik().ConstCennik) {
            for (All_Kategores al : koszyk_klient.koszyk_room) {
                if (cennik_kino.CheckFilm(al)) {
                    while (aboniment ? kwota >= cennik_kino.getCena_z_aboniment() : kwota >= cennik_kino.getCena_bez_aboniment()){
                        if(aboniment) {
                            kwota = kwota - cennik_kino.getCena_z_aboniment();
                        } else
                            kwota = kwota - cennik_kino.getCena_bez_aboniment();
                    }
                    if (!enough) {
                        delet_elem.add(al);
                    }
                }
            }
        }
        koszyk_klient.koszyk_room.removeAll(delet_elem);
    }

    public String pobierzKoszyk() {
        return this.koszyk_klient.toString();
    }

    public double pobierzPortfel() {
        return kwota;
    }
}


class ListaZyczen extends ArrayList<All_Kategores> {
    Klient klient1;
    ArrayList<All_Kategores> all_kategores;

    public ListaZyczen(ArrayList all_kategores) {
        this.all_kategores = all_kategores;
    }

    @Override
    public String toString() {
        String print_all = klient1.klient_name + " :\n";
        for (All_Kategores alk :klient1.listaZyczen) {
            print_all += alk.getNazwa() + " ile: " + alk.getUrzadzenie() + " urządzenia ";
        }
        return print_all;
    }
}