import java.util.Objects;

public class Produkt {
    private int id;                                 //tworze zmienne
    private double cena;

    public Produkt(int id, double cena){            //konstruktor
        this.id = id;
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o){        //nadpisywanie metody equals()
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt product = (Produkt) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode(){                  //nadpisywanie hashCode()
        return Objects.hash(id);
    }

    @Override                               //zamienia w string
    public String toString(){
        return id  + " - " + cena;
    }
}
