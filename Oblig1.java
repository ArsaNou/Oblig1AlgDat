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
        char siste = a[a.length-1];

        for(int i = a.length-2; i >= 0; i--){
            a[i+1] = a[i];
        }

        a[0] = siste;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if(k == 0 || a.length == 1){                        //hvis antall rotasjoner er 0 eller
            return;                                         //hvis det kun er ett tall i arrayet, gjores ingenting
        }

        if (k < 0){                                         //roterer mot venstre hvis k er negativ
            int venstre = k - (2*k);                        //positivt antall rotasjoner mot venstre

            for (int i = 0; i <= venstre; i++){              //forste for-loop er antall rotasjoner
                int j;                                       //andre for-loop flytter alle tallene en gang til venstre
                char forste = a[0];

                for (j = 0; j <= a.length-1; j++){
                    a[j] = a[j+1];
                }

                a[j] = forste;
            }
        }
        else {                                                 //roterer mot høyre ellers
            for (int i = 0; i <= k; i++){
                int j;
                char siste = a[a.length-1];

                for (int j = a.length-2; j >= 0; j--){
                    a[j+1] = a[j];
                }
                a[j] = siste;
            }
        }
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
        //hjelpetabeller for å ikke endre på opprinnelige arrayet
        int[] verdier = new int[a.length];
        int[] indekser = new int[a.length];


        //lager int som er storste mulige for å eliminere det minste hver gang vi finner den
        final int MAKS_MULIGE = Integer.MAX_VALUE;

        //kopierer opprinnelige arrayet over i hjelpetabell
        for (int i = 0; i < a.length; i++) verdier[i] = a[i];



        for (int i = 0; i < verdier.length; i++){

            //fungerer for å initialisere hjelpevariablene og resette hver loop
            int minsteindex = 0;
            int minste = verdier[0];

            for (int j= 0; j < verdier.length; j++){
                if(verdier[j] < minste){
                    //finner indeksen og setter minsteindeks lik den og minste verdi
                    minsteindex = j;
                    minste = verdier[j];
                }
            }
            //setter indekser-tabellens innhold når vi har funnet minsteindekser
            indekser[i] = minsteindex;
            //necessary for å kunne eliminere det minste tallet hver gang vi finner det
            //da hopper loopen over den neste gang
            verdier[minsteindex] = MAKS_MULIGE;
        }
        return indekser;
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
