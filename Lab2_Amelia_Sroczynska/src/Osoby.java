import java.util.Comparator;

public class Osoby {
    private String imie;                        //tworze zmienne
    private int wiek;

    // Konstruktor
    public Osoby(String imie, int wiek) {       //konstruktor
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie() {                   //tworze dostep za pomocą getterów
        return imie;
    }

    public int getWiek() {                   //tworze dostep za pomocą getterów
        return wiek;
    }

    @Override
    public String toString() {               //zamienia w string
        return imie + ": lat " + wiek;
    }
}
