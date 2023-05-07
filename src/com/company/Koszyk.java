package com.company;

import java.util.ArrayList;

public class Koszyk {
    ArrayList<All_Kategores> koszyk_room = new ArrayList<>();
    Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
    }

    @Override
    public String toString() {
        return "Koszyk{" +
                "koszyk_room=" + koszyk_room +
                ", klient=" + klient +
                '}';
    }
}
