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

        String[] liczbyString = ciag.split(" ");  //Rozdzielam ciag na liczby ale jako stringi

        for(String liczba : liczbyString){
            int liczby = Integer.parseInt(liczba);       //Zamieniam stringi na liczby
            hashSet.add(liczby);                         //dodaje do hashSet
            treeSet.add(liczby);                         //dodaje do treeSet
        }

        scanner.close();

        System.out.println(hashSet);                     //wyświetlam oba zbiory
        System.out.println(treeSet);

        System.out.println("Jak widać, liczby w HashSet są układane w losowej kolejności," + //wyświetlam wnioski
                " w TreeSet są sortowane w kolejności rosnącej. Oba zbiory ignorują duplikaty.");
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

        System.out.println("Na podstawie wyników programu porównującego czas wykonywania operacji dodawania, modyfikacji i usuwania " +
                "elementów w dwóch typach list (ArrayList i LinkedList) można zauważyć, że ArrayList zwykle wykazuje lepszą wydajność " +
                "przy dodawaniu i modyfikacji, podczas gdy LinkedList może być korzystniejszy przy usuwaniu elementów, szczególnie gdy " +
                "usuwamy je z początku lub środka listy. Różnice w czasach wykonywania operacji mogą być kluczowe w kontekście wyboru " +
                "odpowiedniej struktury danych w zależności od wymagań aplikacji.");

    }

    public static void zad3(){
        //Stwórz aplikację, która umożliwia użytkownikowi przechowywanie par klucz-wartość w mapie typu
        // HashMap i TreeMap. Po dodaniu kilku elementów, zwróć uwagę na różnice w kolejności kluczy w
        // obu mapach.



    }

    public static void zad4(){
        //Zaprojektuj klasę reprezentującą produkt z identyfikatorem (np. numerem seryjnym) i ceną.
        // Zaimplementuj nadpisywanie metod equals() i hashCode(). Następnie stwórz zbiór HashSet i
        // dodaj kilka produktów. Spróbuj dodać ten sam produkt ponownie i zobacz, jakie będą wyniki.


    }

    public static void zad5(){
        //Stwórz listę obiektów reprezentujących osoby, gdzie każda osoba ma imię i wiek. Napisz
        // komparator, który sortuje tę listę na podstawie wieku. Następnie posortuj listę za pomocą
        // komparatora i wyświetl wynik.




    }

    public static void zad6(){
        //Stwórz mapę TreeMap, w której klucze reprezentują nazwy miast, a wartości ilości ludności.
        // Napisz komparator, który sortuje mapę według ilości ludności. Wyświetl posortowaną mapę.



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
//        System.out.println("Proszę wybrać numer zadania, którego rozwiązaniesz zobaczyć. Rozwiązałam 11 zadań: ");
//
//        Scanner scanner = new Scanner(System.in);
//
//        String wybor = scanner.nextLine();
//
//        switch(wybor){
//            case "1":
//                zad1();
//                break;
//
//            case "2":
//                zad2();
//                break;
//
//            case "3":
//                zad3();
//                break;
//
//            case "4":
//                zad4();
//                break;
//
//            case "5":
//                zad5();
//                break;
//
//            case "6":
//                zad6();
//                break;
//
//            case "7":
//                zad7();
//                break;
//
//            case "8":
//                zad8();
//                break;
//
//            case "9":
//                zad9();
//                break;
//
//            case "10":
//                zad10();
//                break;
//
//            case "11":
//                zad11();
//                break;
//
//        }

        zad2();

        //scanner.close();
    }
}