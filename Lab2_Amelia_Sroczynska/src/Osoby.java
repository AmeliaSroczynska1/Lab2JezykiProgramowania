import java.util.Comparator;

public class Osoby {
    private String imie;                        //tworze zmienne
     int wiek;

    public Osoby(String imie, int wiek){       //konstruktor
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public String toString(){
        return imie + ": lat " + wiek;
    }   //zamienia w string
}
