public class Osoby {
    private String imie;                        //tworze zmienne
    private int wiek;

    public Osoby(String imie, int wiek){       //konstruktor
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public String toString(){
        return "\n" + imie + ": lat " + wiek;
    }   //zamienia w string
}
