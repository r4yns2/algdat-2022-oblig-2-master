package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    public DobbeltLenketListe() {
        //Lage konstruktør for instansvariablene som peker på osv.
        this.hode = null;
        this.hale = null;
        this.antall = 0;
        this.endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        // Node<T> newNode =  new Node<T>(a); Ikke bruke denne.
        // Bruke a og lage for løkke for hode og hale.
        // Bruke sjekklisten i obligen.
        Objects.requireNonNull(a, "Tabellen a er null!");
        int i = 0;
        for (; i < a.length && a[i] == null; i++) {
        }
        if (i < a.length) {
            Node<T> current = hode = new Node<>(a[i]);
            antall++;
            for (i++; i < a.length; i++) {
                if (a[i] != null) {
                    current = current.neste = new Node<>(a[i]);
                    antall++;
                }
            }
            hale = current;
        }
    }

    public Liste<T> subliste(int fra, int til) {
        DobbeltLenketListe<T> sublist = new DobbeltLenketListe<>();
        fratilkontroll(antall,fra,til);
        Node<T> counter = hode;
        int temp = 0;
        while (counter != null){
            if (temp > fra && temp < til){
                sublist.leggInn(counter.verdi);
            }
            counter = counter.neste;
            temp++;
        }
        return sublist;
    }

    private static void fratilkontroll(int antall, int fra, int til){
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    @Override
    public int antall() {
        Node<T> tmp;
        tmp = this.hode;
        int i = 0;
        while(tmp != null) {
            i++;
            tmp = tmp.neste;
        }
        return i;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Verdi er null");
        if (antall == 0){
            hode = hale = new Node<>(verdi);
        }else{
            hale = hale.neste = new Node<>(verdi);
        }
        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    private Node<T> finnNode(int indeks){ // Oppgave 3. Finner ingen finnNode metode. Laget derfor en selv.

        if (indeks < antall()/2){
            Node<T> current = hode;
            if (tom()){
                throw new NullPointerException("Tabellen er tom");
            }
            for (int i=0;i<indeks;i++){
                current=current.neste;
            }
            return current;
        }else{
            Node<T> current = hale;
            for (int i=0;i<indeks;i++){
                current=current.forrige;
            }
            return current;
        }
    }


    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {

    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        if (nyverdi == null){
            throw new NullPointerException("Ugyldig verdi");
        }
        indeksKontroll(indeks,false);
        Node<T> current = finnNode(indeks);
        T gammelVerdi = current.verdi;
        current.verdi = nyverdi;
        endringer++;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder Lister = new StringBuilder();
        Lister.append("[");
        if (tom()){
            Lister.append("]");
            return Lister.toString();
        }else {
            Node<T> current = hode;
            Lister.append(current.verdi);
            current = current.neste;
            while(current != null) {
                Lister.append(", ").append(current.verdi);
                current = current.neste;
            }
            Lister.append("]");
            return Lister.toString();
        }
    }

    public String omvendtString() {
        StringBuilder Lister = new StringBuilder();
        Lister.append("[");
        if (tom()){
            Lister.append("]");
            return Lister.toString();
        }else {
            Node<T> current = hale;
            Lister.append(current.verdi);

            while(current != null) {
                current = current.forrige;
                Lister.append(", ").append(current.verdi);
                current = current.forrige;
            }
            Lister.append("]");
            return Lister.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


