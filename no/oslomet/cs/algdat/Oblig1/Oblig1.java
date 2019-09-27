package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import org.w3c.dom.xpath.XPathResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        int m = 0;

        for (int i = 1; i < a.length; i++) {
            m = i;

            if (a[m - 1] > a[m]) {
                int midlertid = a[m];
                a[m] = a[m - 1];
                a[m - 1] = midlertid;

            }
        }
        return a[a.length - 1];

        // 1 + 1 + 1 + n + n - 1 + x + 3(n - 1) + 8x + 1
        // f(n) = 5n + 9x
    }


    public static int ombyttinger(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        int m = 0;
        int teller = 0;

        for (int i = 1; i < a.length; i++) {
            m = i;


            if (a[m - 1] > a[m]) {
                int midlertid = a[m];
                a[m] = a[m - 1];
                a[m - 1] = midlertid;
                teller++;
            }
        }

        return teller;

        // Hvor er det flest ombyttinger?
        // Når er det ferrest?
        // Hva blir det i gjennomsnitt?
        // Er denne maks-metoden bedre enn de man har sett tidligere?


    }


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        int ulike = 0;

        if(a.length > 1) {
            int tallet = a[0];
            for (int i = 1; i < a.length; i++) {
                if (tallet > a[i]) throw new IllegalStateException("Tabellen er ikke sortert!");
                tallet = a[i];
            }
        }
        if(a.length >= 1){
            ulike = 1;
            int temp = a[0];
            for(int i = 1; i < a.length; ++i){
                if(a[i] != temp){
                    ulike++;
                    temp = a[i];
                }
            }
        } return ulike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        if (a.length < 1) {
            return 0;
        }

        int teller = 0;

        for (int i = 0; i < a.length; i++) {
            boolean ulik = false;

            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    ulik = true;
                    break;
                }
            }
            if (!ulik) {
                teller++;
            }
        }
        return teller;
    }


    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        if (a.length < 1) return;
        int venstre = a[0];
        int hoyre = a.length-1;

        int odde = 0;
        for (int i :a){
            if (i % 2 != 0){
                odde++;
            }
        }

        for (int i = 0; i < odde; ++i){

            if(a[i] % 2 == 0){
                venstre = a[i];

                for (int j = hoyre; j >= odde; --j){
                    if (a[j] % 2 != 0){
                        hoyre = j; a[i] = a[j]; a[j] = venstre;

                        break;
                    }
                }
            }
        }

        quickSort(a,0,odde-1);
        quickSort(a,odde,a.length-1);
    }

    public static int partisjon(int a[],int start,int slutt){

        int venstre = start-1;
        for(int i = start; i< slutt; i++) {
            if (a[i] <= a[slutt]) {
                venstre++;
                bytt(a,venstre,i);
            }

        }
        bytt(a,venstre+1, slutt);
        return venstre+1;


    }
    public static void quickSort(int[] a,int start, int slutt){
        if(start < slutt){
            int midt= partisjon(a,start,slutt);

            quickSort(a,start,midt-1);
            quickSort(a,midt+1,slutt);
        }
    }


    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }



    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length < 1) {
            return;
        }


        char siste = a[a.length - 1];

        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }

        a[0] = siste;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k){
        int n = a.length;

        if (n < 2){
            return;
        }

        k %= n;
        char[] kopitemp = new char[Math.abs(k)];

        int indekser = 0;


        if (k > 0) {
            for (int i = n-k; i<n; i++) {
                kopitemp[indekser++] = a[i];
            }

            for (int i = n-k-1; i >= 0; i--) {
                a[k+i] = a[i];
                if (i < k){
                    a[i] = kopitemp[i];
                }
            }
        } else if (k < 0){
            k = Math.abs(k);

            for (int i = 0; i < k; i++){
                kopitemp[i] = a[i];
            }

            for (int i = 0; i <= n-k-1; i++){
                a[i] = a[k+i];
            }

            for(int i = 0; i < kopitemp.length; i++){
                a[n-i-1] = kopitemp[k-i-1];
            }
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        int minStr = Math.min(s.length(), t.length());
        StringBuilder array = new StringBuilder();


        for (int i = 0; i < minStr; i++) {
            array.append(s.charAt(i)).append(t.charAt(i));
        }
        array.append(s.substring(minStr)).append(t.substring(minStr));


        return array.toString();

    }


    /// 7b)
    public static String flett(String... s) {


        int lengde = 0;
        String array = "";

        for(String lagrer : s) {
            lengde += lagrer.length();
        }

        int [] c = new int[s.length];



        for(int i = 0; i<lengde; i++){

            for(int j = 0; j < s.length; j++){

                if(c[j] < s[j].length()){

                    array += s[j].toCharArray()[c[j]];
                    c[j]++;
                }
            }
        }
        return array;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        //hjelpetabeller for aa ikke endre på opprinnelige arrayet
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

        if(a.length<3){
            throw new NoSuchElementException("Tabellen har ferre enn 3 elementer.");
        }

        int [] lengde = new int [3];
        for(int i = 0; i<lengde.length; i++){
            lengde[i] = a[i];
        }
        int [] array = indekssortering(lengde);

        int pos1 = 0;
        int pos2 = 1;
        int pos3 = 2;

        pos1 = array[0];
        pos2 = array[1];
        pos3 = array[2];

        int en = a[pos1];
        int to = a[pos2];
        int tre = a[pos3];

        for(int i = 3; i < a.length; i++){
            if(a[i] < tre) {
                if (a[i] < to) {
                    if (a[i] < en) {
                        pos3 = pos2;
                        tre = to;

                        pos2 = pos1;
                        to = en;

                        pos1 = i;
                        en = a[pos1];
                    } else {
                        pos3 = pos2;
                        tre = to;

                        pos2 = i;
                        to = a[pos2];
                    }
                } else {
                    pos3 = i;
                    tre = a[pos3];
                }
            }
        }
        return new int[] {pos1, pos2, pos3};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {

        char[] alfabet={'A','B','C','D','E','F',
                'G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T',
                'U','V','W','X','Y','Z','Æ','Ø','Å'};

        for(int i = 0; i< alfabet.length; i++){

            if(alfabet[i] == bokstav) {
                return i;
            }

        }
        return 31;
    }

    public static void mengde(char[] a,int[] b){

        for (char i : a) {
            b[bokstavNr(i)] +=1 ;
        }
    }

    public static boolean inneholdt(String a, String b) {
        int length=32;

        char[] Achars=a.toCharArray();
        char[] Bchars=b.toCharArray();


        int[] mengdeA = new int[length];
        int[] mengdeB = new int[length];

        mengde(Achars,mengdeA);
        mengde(Bchars,mengdeB);

        for(int i=0;i<length-2;i++){
            if(mengdeB[i] < mengdeA[i]){
                return false;
            }
        }
        return true;
    }

}  // Oblig1
