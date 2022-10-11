package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.Iterator;
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
        throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {
        Node newNode =  new Node(a);
        try {
            hode = null;
            hode.neste = hale;
            if (a.length != 0) {
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != null) {
                        Objects.requireNonNull(hale).neste = newNode;
                        antall++;
                        endringer++;
                        newNode.forrige = hale;
                        hale = newNode;
                        hale.neste = null;
                    }
                }
            }

        }catch (NullPointerException e){
            System.out.print("Tabellen a er null!");
        }
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
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
        return hode.neste == hale;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Verdi er null");
        Node<T> newNode = new Node<>(verdi);
        if (tom()){
            hode = hale = newNode;
            antall++;
            endringer++;
            hode.forrige=null;
            hale.neste=null;
        }else{
            hale.neste = newNode;
            antall++;
            endringer++;
            newNode.forrige = hale;
            hale = newNode;
            hale.neste = null;
        }
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks){ // Oppgave 3. Finner ingen finnNode metode. Laget derfor en selv.
        if (indeks < antall()/2){
            int i = 1;
            boolean sjekk = false;
            Node<T> current = hode;
            if (hode == null){
                throw new NullPointerException("Tabellen er tom");
            }
            while(current != null){
                if (indeks = current.verdi){
                    sjekk = true;
                    break;
                }
                current = current.neste;
                i++;
            }
        }
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
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
        String ut1 = "[";
        String ut2 = "]";
        if (hode == null){
            return ut1 + Lister + ut2;
        }else {
            Node<T> current = hode;
            while(current != hale) {
                Lister.append(current).append(", ");
                current = current.neste;
            }
            return ut1 + Lister + ut2;
        }
    }

    public String omvendtString() {
        StringBuilder Lister = new StringBuilder();
        String ut1 = "[";
        String ut2 = "]";
        if (hode == null){
            return ut1 + Lister + ut2;
        }else {
            Node<T> current = hale;
            while(current != hode) {
                Lister.append(current).append(", ");
                current = current.forrige;
            }
            return ut1 + Lister + ut2;
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


