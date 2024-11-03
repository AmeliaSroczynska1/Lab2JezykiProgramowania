import java.util.Scanner;
import java.util.*;

public class Main {

    public static void zad1(){
        //Zaimplementuj program, który przyjmuje od użytkownika ciąg liczb i przechowuje je w zbiorze typu
        // HashSet i TreeSet. Następnie wyświetl różnice między HashSet a TreeSet w kontekście kolejności
        // elementów.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ciąg liczb oddzielonych spacjami: ");

        String ciag = scanner.nextLine();               //pobieram z klawiatury

        Set<Integer> hashSet = new HashSet<>();          //tworze
        Set<Integer> treeSet = new TreeSet<>();

        String[] liczbyString = ciag.split(" ");  //Rozdzielam ciag na pojedyncze liczby ale jako stringi

        for(String liczba : liczbyString){
            int liczby = Integer.parseInt(liczba);       //Zamieniam stringi na liczby
            hashSet.add(liczby);                         //dodaje do hashSet
            treeSet.add(liczby);                         //dodaje do treeSet
        }

        System.out.println("HashSet: ");
        for(int element : hashSet) {
            System.out.println(element);                     //wyświetlam zbior HashSet
        }

        System.out.println("TreeSet: ");
        for(int element : treeSet) {
            System.out.println(element);                     //wyświetlam zbior TreeSet
        }

        System.out.println("Jak widać, liczby w HashSet są układane w losowej kolejności," + //wyświetlam wnioski
                " w TreeSet są sortowane w kolejności rosnącej. Oba zbiory ignorują duplikaty.");

        scanner.close();
    }

    public static void zad2(){
        //Stwórz program, który dodaje, usuwa i modyfikuje elementy w dwóch listach typu ArrayList i
        // LinkedList. Następnie zmierz czas wykonywania tych operacji i porównaj wyniki.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilu elementową listę chcesz (może być dużo): ");

        int iloscElementow = scanner.nextInt();

        List<Integer> arrayList = new ArrayList<>();        //tworze listy
        List<Integer> linkedList = new LinkedList<>();


        //Mierzenie czasu dodawania do ArrayList
        long czasStartowy = System.nanoTime();              //pobieram czas kiedy zaczynam dodawac

        for(int i = 0; i < iloscElementow; i++){            //dodaję wszystkie elementy do arrayList
            arrayList.add(i);
        }

        long czasKoncowy = System.nanoTime();               //pobieram czas kiedy kończy dodawać
        long czasDodawaniaArray = czasKoncowy-czasStartowy; //obliczam ostateczny czas dodawania

        System.out.println("Czas dodawania " + iloscElementow + " elementów do ArrayList to " + czasDodawaniaArray + " nanosekund");      //wyświetlam wynik


        //Mierzenie czasu dodawania do LinkedList
        czasStartowy = System.nanoTime();                   //pobieram czas kiedy zaczynam modyfikować

        for (int i = 0; i < iloscElementow; i++){           //dodaję wszystkie elementy do linkedList
            linkedList.add(i);
        }

        czasKoncowy = System.nanoTime();                     //pobieram czas kiedy kończy dodawać
        long czasDodawaniaLinked = czasKoncowy-czasStartowy; //obliczam ostateczny czas dodawania

        System.out.println("Czas dodawania " + iloscElementow + " elementów do LinkedList to " + czasDodawaniaLinked + " nanosekund");      //wyświetlam wynik


        //Mierzenie czasu modyfikacji w ArrayList
        czasStartowy = System.nanoTime();                   //pobieram czas kiedy zaczynam modyfikować

        for (int i = 0; i < iloscElementow; i++){           //modyfikuję kazdy element (podnosze do kwadratu)
            arrayList.set(i, (int) Math.pow(arrayList.get(i), 2));
        }

        czasKoncowy = System.nanoTime();                      //pobieram czas kiedy kończy dodawać
        long czasModyfikacjiArray = czasKoncowy-czasStartowy; //obliczam ostateczny czas modyfikowania

        System.out.println("Czas modyfikacji " + iloscElementow + " elementów w ArrayList to " + czasModyfikacjiArray + " nanosekund");      //wyświetlam wynik


        //Mierzenie czasu modyfikacji w LinkedList
        czasStartowy = System.nanoTime();                   //pobieram czas kiedy zaczynam modyfikować

        for (int i = 0; i < iloscElementow; i++){           //modyfikuję kazdy element
            linkedList.set(i, (int) Math.pow(linkedList.get(i), 2));
        }

        czasKoncowy = System.nanoTime();                       //pobieram czas kiedy kończy dodawać
        long czasModyfikacjiLinked = czasKoncowy-czasStartowy; //obliczam ostateczny czas modyfikowania

        System.out.println("Czas modyfikacji " + iloscElementow + " elementów w LinkedList to " + czasModyfikacjiLinked + " nanosekund");      //wyświetlam wynik


        //Mierzenie czasu usuwania w ArrayList
        czasStartowy = System.nanoTime();                   //pobieram czas kiedy zaczynam modyfikować

        for (int i = iloscElementow-1; i >= 0; i--){        //usuwam wszystkie elementy
            arrayList.remove(i);
        }

        czasKoncowy = System.nanoTime();                    //pobieram czas kiedy kończy dodawać
        long czasUsuwaniaArray = czasKoncowy-czasStartowy;  //obliczam czas usuwania

        System.out.println("Czas usuwania " + iloscElementow + " elementów z ArrayList to " + czasUsuwaniaArray + " nanosekund");      //wyświetlam wynik


        //Mierzenie czasu usuwania w LinkedList
        czasStartowy = System.nanoTime();                   //pobieram czas kiedy zaczynam modyfikować

        for (int i = iloscElementow-1; i >= 0; i--){        //usuwam wszystkie elementy
            linkedList.remove(i);
        }

        czasKoncowy = System.nanoTime();                    //pobieram czas kiedy kończy dodawać
        long czasUsuwaniaLinked = czasKoncowy-czasStartowy; //obliczam czas usuwania

        System.out.println("Czas usuwania " + iloscElementow + " elementów z LinkedList to " + czasUsuwaniaLinked + " nanosekund");      //wyświetlam wynik

        scanner.close();

        System.out.println("Na podstawie wyników tego programu porównującego czas wykonywania operacji dodawania, modyfikacji i usuwania \n" +
                "elementów w dwóch typach list (ArrayList i LinkedList) można zauważyć, że ArrayList zwykle wykazuje lepszą wydajność \n" +
                "przy dodawaniu i modyfikacji, podczas gdy LinkedList może być korzystniejszy przy usuwaniu elementów, szczególnie gdy \n" +
                "usuwamy je z początku lub środka listy.");
    }

    public static void zad3(){
        //Stwórz aplikację, która umożliwia użytkownikowi przechowywanie par klucz-wartość w mapie typu
        // HashMap i TreeMap. Po dodaniu kilku elementów, zwróć uwagę na różnice w kolejności kluczy w
        // obu mapach.

        Map<Integer, String> hashMap = new HashMap<>();     //tworzę HashMap i TreeMap
        Map<Integer, String> treeMap = new TreeMap<>();

        hashMap.put(2, "Mleko");                            //dodaję wartości i  klucze do hashMap
        hashMap.put(1, "Woda");
        hashMap.put(4, "Chleb");
        hashMap.put(5, "Sok");
        hashMap.put(3, "Jabłko");
        hashMap.put(4, "Makaron");      //wartość zostanie nadpisana
        hashMap.put(32, "Pomarańcza");
        hashMap.put(14, "Smietana");


        treeMap.put(2, "Mleko");                            //dodaję wartości i  klucze do treeMap
        treeMap.put(1, "Woda");
        treeMap.put(4, "Chleb");
        treeMap.put(5, "Sok");
        treeMap.put(3, "Jabłko");
        treeMap.put(4, "Makaron");      //wartość zostanie nadpisana
        treeMap.put(32, "Pomarańcza");
        treeMap.put(14, "Smietana");

        System.out.println("HashMap: ");                    //Wyświetlam
        for(Map.Entry<Integer, String> pozycja : hashMap.entrySet()){
            System.out.println(pozycja.getKey() + " - " + pozycja.getValue());
        }

        System.out.println("\nTreeMap: ");

        for(Map.Entry<Integer, String> pozycja : treeMap.entrySet()){
            System.out.println(pozycja.getKey() + " - " + pozycja.getValue());
        }

        System.out.println("\nJak widać, HashMap nie gwarantuje nam żadnej konkretnej kolejności wartości. W TreeMap elementy sortowane są zgodnie z " +
                "kolejnością kluczy. Ważną cechą mapy, którą \nteż tutaj sprawdziłam jest to, że jeśli podam taki sam klucz jak już jest w mapie, wartość " +
                "zostanie nadpisana.");
    }

    public static void zad4(){
        //Zaprojektuj klasę reprezentującą produkt z identyfikatorem (np. numerem seryjnym) i ceną.
        // Zaimplementuj nadpisywanie metod equals() i hashCode(). Następnie stwórz zbiór HashSet i
        // dodaj kilka produktów. Spróbuj dodać ten sam produkt ponownie i zobacz, jakie będą wyniki.

        HashSet<Produkt> produkty = new HashSet<>();

        Produkt produkt1 = new Produkt(15, 10.50);
        Produkt produkt2 = new Produkt(2, 120);
        Produkt produkt3 = new Produkt(38, 13.70);
        Produkt produkt4 = new Produkt(9, 26.55);
        Produkt produkt5 = new Produkt(11, 48.50);
        Produkt produkt6 = new Produkt(6, 173.80);
        Produkt produkt7 = new Produkt(2, 120);         //nie doda się bo powtórka

        produkty.add(produkt1);
        produkty.add(produkt2);
        produkty.add(produkt3);
        produkty.add(produkt4);
        produkty.add(produkt5);
        produkty.add(produkt6);
        produkty.add(produkt7);                                  //nie doda się bo powtórka

        System.out.println("Zbiór HashSet (format: id - cena): ");
        for(Produkt produkt : produkty) {
            System.out.println(produkt);
        }

        System.out.println("\nJak widać, HashSet nie sortuje elementów. Program usuwa duplikaty");
    }

    public static void zad5(){
        //Stwórz listę obiektów reprezentujących osoby, gdzie każda osoba ma imię i wiek. Napisz
        // komparator, który sortuje tę listę na podstawie wieku. Następnie posortuj listę za pomocą
        // komparatora i wyświetl wynik.

        List<Osoby> osoby = new ArrayList<>();             //tworze liste

        osoby.add(new Osoby("Amelia", 21));     //dodaję osoby
        osoby.add(new Osoby("Kuba", 23));
        osoby.add(new Osoby("Krzysiu", 19));
        osoby.add(new Osoby("Adam", 17));
        osoby.add(new Osoby("Maciej", 22));


        System.out.println("Lista osób przed posortowaniem: ");
        for(Osoby osoba : osoby){
            System.out.println(osoba);
        }

        osoby.sort(Comparator.comparingInt(o -> o.wiek));           //sortuję za pomocą Comparator

        System.out.println("\nLista osób po posortowaniu: ");
        for(Osoby osoba : osoby){
            System.out.println(osoba);
        }
    }

    public static void zad6(){
        //Stwórz mapę TreeMap, w której klucze reprezentują nazwy miast, a wartości ilości ludności.
        // Napisz komparator, który sortuje mapę według ilości ludności. Wyświetl posortowaną mapę.

        Map<String, Integer> treeMap = new TreeMap<>();                     //tworzę treeMap

        treeMap.put("Wrocław", 673700);                                     //uzupełniam zbiór danymi
        treeMap.put("Gdańsk", 470000);
        treeMap.put("Zakopane", 27000);
        treeMap.put("Sopot", 35000);
        treeMap.put("Toruń", 195000);


        System.out.println("TreeMap: ");                                    //wyświetlam nieposortowany treeMap
        for(Map.Entry<String, Integer> pozycja : treeMap.entrySet()){
            System.out.println(pozycja.getKey() + " - " + pozycja.getValue());
        }

        Map<String, Integer> sortedMap = new TreeMap<>(                     //sortuję za pomocą Comparator
                (miasto1, miasto2) -> treeMap.get(miasto1).compareTo(treeMap.get(miasto2))
        );

//        Map<String, Integer> sortedMap = new TreeMap<>(                   //druga wersja, nie wiem czy dobra
//                Comparator.comparing(treeMap::get)
//        );

        sortedMap.putAll(treeMap);                                          //dodaję wszystko z powrotem

        System.out.println("\nPosortowany TreeMap: ");                      //wyświetlam posortowane
        for(Map.Entry<String, Integer> pozycja : sortedMap.entrySet()) {
            System.out.println(pozycja.getKey() + " - " + pozycja.getValue());
        }
    }

    public static void zad7(){
        //Zaimplementuj klasę reprezentującą książkę z polami takimi jak: tytuł, autor i numer ISBN.
        // Napisz metody equals() i hashCode(), aby porównywały książki na podstawie numeru ISBN.
        // Następnie stwórz HashSet i dodaj kilka książek o tym samym numerze ISBN, a także kilka różnych.
        // Przeanalizuj wynik.



    }

    public static void zad8(){
        //Stwórz klasę reprezentującą produkt z polami, takimi jak nazwa i cena. Zaimplementuj interfejs
        // Comparable, aby produkty były porównywane na podstawie ceny. Stwórz listę produktów i posortuj
        // ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.

    }

    public static void zad8_1() {
        //Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania produktów według nazwy.
        //Wyświetl wynik i porównaj go z poprzednim.



    }

    public static void zad9(){
        //Stwórz mapę, w której kluczami są niestandardowe obiekty, np. reprezentujące adresy. Nadpisz
        // metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie. Dodaj kilka
        // elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych
        // kluczy.



    }

    public static void zad10(){
        //Stwórz klasę reprezentującą samochód z polami, takimi jak marka, model i rok produkcji. Napisz
        //komparator, który sortuje samochody najpierw według marki, a następnie według modelu. Stwórz
        // listę samochodów i posortuj ją za pomocą tego komparatora. Wyświetl posortowaną listę.



    }

    public static void zad10_1(){
        //Rozwiń zadanie, aby tym razem użyć niestandardowego komparatora, który sortuje samochody na
        //podstawie rocznika od najstarszego do najnowszego. Wyświetl wynik i porównaj go z poprzednim.



    }

    public static void zad11(){
        //Stwórz klasę reprezentującą rzekę. Rzeka ma nazwę w języku polskim, niemieckim i czeskim,
        //nazwę rzeki, do której wpływa oraz przebieg (pole typu String). Następnie stwórz kolekcję
        //(typ do samodzielnego wyboru) umożliwiającą przechowywanie rzek i wyświetlanie ich w zadanym
        //porządku (wg. języka nazw).



    }

    public static void zad11_1(){
        //przebieg jest kolekcją punktów (double lat,lon;), a nie opisem słownym



    }

    public static void zad11_2(){
        //zaproponuj rozwiązanie umożliwiające wyświetlanie bez konieczności każdorazowego sortowania
        //przy zmianie języka



    }

    public static void zad11_3(){
        //dodaj możliwość filtracji rzek umożliwiając wyświetlanie dorzecza danej rzeki



    }


    public static void main(String[] args) {
        System.out.println("Proszę wybrać numer zadania, którego rozwiązaniesz zobaczyć. Rozwiązałam 11 zadań: ");

        Scanner scanner = new Scanner(System.in);

        String wybor = scanner.nextLine();

        switch(wybor){
            case "1":
                zad1();
                break;

            case "2":
                zad2();
                break;

            case "3":
                zad3();
                break;

            case "4":
                zad4();
                break;

            case "5":
                zad5();
                break;

            case "6":
                zad6();
                break;

            case "7":
                zad7();
                break;

            case "8":
                zad8();
                break;

            case "9":
                zad9();
                break;

            case "10":
                zad10();
                break;

            case "11":
                zad11();
                break;

            default:
                System.out.println("Nie podałeś prawidłowego znaku. Możesz wybrać tylko liczby 1-11.");
                break;

        }
        scanner.close();
    }
}