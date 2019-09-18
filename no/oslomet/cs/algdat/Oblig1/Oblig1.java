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
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1)return 1;

        int teller = 0;
        int verdi = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (!(a[i+1] >= a[i])){
                throw new IllegalStateException("Tabellen er ikke sortert!");
            }
            if (a[i] > verdi) {
                verdi = a[i];
                teller++;
            } else if (a[i] == verdi) {
                verdi = a[i];
            }

        }
        return teller;

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
        /*
        int odde = 0;
        int partall = 0;

        if(a.length< 1) return;



        for (int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0) {
                partall++;
            }else {
                int temp = a[i];
                a[i] = a[odde];
                a[odde] = temp;
                odde++;
            }
        }
        quicksortering(a, 0,odde);
        quicksortering(a, odde, a.length);
    }
    */
        if (a.length < 1) return;
        int Odde = finnOdde(a);

        int venstre = 0;
        int hoyre = a.length - 1;
            while(venstre<hoyre) {

                while (venstre < Odde && hoyre >= Odde && a[venstre] % 2 != 0) venstre++;
                while (venstre < Odde && hoyre >= Odde && a[hoyre] % 2 == 0) hoyre--;


                if ((a[venstre] % 2) == 0 && (a[hoyre] % 2) != 0) {
                    bytt(a, venstre++, hoyre--);

                } else if ((a[venstre] % 2) == 0 && (a[hoyre] % 2) == 0) {
                    hoyre--;

                } else if ((a[venstre] % 2) != 0 && (a[hoyre] % 2) != 0) {
                    venstre++;

                } else if ((a[venstre] % 2) != 0 && (a[hoyre] % 2) == 0) {
                    venstre++;
                    hoyre--;
                }
                //Arrays.sort(a, 0, Odde);
                //Arrays.sort(a, Odde, a.length);
                quicksortering(a, 0,Odde);
                quicksortering(a, Odde, a.length);
                //Fungerer kun med Array.sort
            }
    }

    public static int partisjonering(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                bytt(arr, arr[i], arr[j]);
            }
        }

        bytt(arr, arr[i+1], arr[end]);
        return i+1;
    }

    public static void quickSort(int a[], int start, int slutt) {
        if (start < slutt) {
            int partisjonsIndex = partisjonering(a, start, slutt);

            quickSort(a, start, partisjonsIndex - 1);
            quickSort(a, partisjonsIndex + 1, slutt);
        }
    }

        public static int partisjonering(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    public static void quicksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = partisjonering(a, v, h, (v + h) / 2);  // bruker midtverdien
        quicksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        quicksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void quicksortering(int[] a, int fra, int til)   // sorterer hele tabellen
    {
        quicksortering0(a, fra, til-1);
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

   public static int finnOdde(int[] a) {
        int Odde = 0;

        for (int i = 0; i < a.length; i++) {
            if ((a[i] % 2) != 0) {
                Odde++;
            }
        }
        return Odde;
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
    public static void rotasjon(char[] a, int k) {
        if (k == 0 || a.length == 1) {                        //hvis antall rotasjoner er 0 eller
            return;                                         //hvis det kun er ett tall i arrayet, gjores ingenting
        }


        if (k < 0) {                                         //roterer mot venstre hvis k er negativ
            int venstre = k - (2 * k);                        //positivt antall rotasjoner mot venstre

            for (int i = 1; i <= venstre; i++) {              //forste for-loop er antall rotasjoner
                int j;                                       //andre for-loop flytter alle tallene en gang til venstre
                char forste = a[0];

                for (j = 0; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }

                a[a.length - 1] = forste;
            }
        } else {                                                 //roterer mot høyre ellers
            for (int i = 1; i <= k; i++) {
                rotasjon(a);
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

        int enVerd = 0;
        int toVerd = 0;
        int treVerd = 0;

        int en = Integer.MAX_VALUE;
        int to = Integer.MAX_VALUE;
        int tre = Integer.MAX_VALUE;




        for (int i = 0; i < a.length; i++) {
            boolean ta = false;

            for (int j = 0; j<a.length; j++){
                if (a[i] < en) {
                    tre = to;
                    to = en;
                    en = a[i];
                    enVerd = i;
                    ta = true;
                    break;

                } else if (a[i] < to) {
                    tre = to;
                    to = a[i];
                    toVerd = i;
                    ta = true;
                    break;

                } else if (a[i] < tre) {
                    tre = a[i];
                    treVerd = i;
                    ta = true;
                    break;

                }
            }


        }

        return new int[]{enVerd, toVerd, treVerd};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b){
        if (a.length() > b.length()) return false;

        int[] antall = new int[256];

        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n; i++) antall[a.charAt(i)]++;

        for (int i = 0; i < antall.length; i++) if (antall[i] > 0) return false;

        return true;
    }

}  // Oblig1
