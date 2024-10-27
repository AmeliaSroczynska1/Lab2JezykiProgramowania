public class Osoby {
    private String imie;
    private int wiek;

    public Osoby(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie(){
        return imie;
    }

    public int getwiek(){
        return wiek;
    }

    @Override
    public String toString(){
        return "\n" + imie + ": lat " + wiek;
    }
}
