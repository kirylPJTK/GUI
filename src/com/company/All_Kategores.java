package com.company;

public abstract class All_Kategores {
    private String nazwa;
    private int urzadzenie;
    private String kategori;

    public All_Kategores(String nazwa, int urzadzenie) {
        this.nazwa = nazwa;
        this.urzadzenie = urzadzenie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getUrzadzenie() {
        return urzadzenie;
    }
}

class Obyczaj extends All_Kategores {
    public Obyczaj(String nazwa, int urzadzenie) {
        super(nazwa, urzadzenie);
    }
}

class Sensacja extends All_Kategores {
    public Sensacja(String nazwa, int urzadzenie) {
        super(nazwa, urzadzenie);
    }
}

class Dramat extends All_Kategores {
    public Dramat(String nazwa, int urzadzenie) {
        super(nazwa, urzadzenie);
    }
}

class Komedia extends All_Kategores {
    public Komedia(String nazwa, int urzadzenie) {
        super(nazwa, urzadzenie);
    }
}
