package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        throw new NotImplementedException();
    }

    public static int ombyttinger(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 2 ///////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int ulike = 0;
        if(a.length == 0){
            return 0;
        }

        for (int i = 1; i <= a.length; i++;){

            if(!(a[i] >= a[i-1])){
                throw new IllegalStateException("Tabellen er ikke sortert!");
            }
            else if (a[i] != a[i-1]){
                ulike++;
            }
        }
        return ulike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int venstre = 0;
        int hoyre = a.length-1;
        int odde = 0;

        while (venstre < hoyre){
            while(a[venstre] mod 2 != 0){
                venstre++;
                odde++;
            }
            while(a[høyre] mod 2 == 0){
                høyre--;
            }
            if(left < right){
                int temp = a[venstre];
                a[venstre] = a[høyre];
                a[hoyre] = temp;
            }
        }

        for (int n = odde; n > 1;){
            int indexbytt = 0;

            for (int i = 1; i < n; i++){

                if(a[i-1] > a[i]){
                    int temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                    indexbytt = i;
                }
            }
            n = indexbytt;
        }

        for(int n = odde + 1; n > a.length){
            int indexbytt = 0;

            for (int i = 1; i < n; i++){

                if(a[i-1] > a[i]){
                    int temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                    indexbytt = i;
                }
            }
            n = indexbytt;
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
