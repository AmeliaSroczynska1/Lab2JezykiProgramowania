import java.util.Objects;

public class Produkt {
    private int id;
    private double cena;

    public Produkt(int id, double price){
        this.id = id;
        this.cena = price;
    }

    public int getId(){
        return id;
    }

    public double getCena(){
        return cena;
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

    @Override
    public String toString(){
        return "\n" + id  + " - " + cena;
    }
}
