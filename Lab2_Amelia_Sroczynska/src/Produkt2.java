class Produkt2 implements Comparable<Produkt2>{
    private String nazwa;
    private double cena;

    public Produkt2(String nazwa, double cena) {        //konstruktor
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {                          //tworzę dostęp za pomocą getterów
        return nazwa;
    }

    public double getCena() {                          //tworzę dostęp za pomocą getterów
        return cena;
    }

    @Override
    public int compareTo(Produkt2 innyProdukt) {       //porównuję
        return Double.compare(this.cena, innyProdukt.getCena());
    }

    @Override
    public String toString() {                          //zamieniam na String
        return nazwa + " - " + cena;
    }
}
