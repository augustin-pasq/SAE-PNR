package modele;

import modele.donnee.EspeceBatracien;
import modele.donnee.EspeceObservee;
import modele.donnee.Lieu;
import modele.donnee.ObsBatracien;
import modele.traitement.Graphe;
import modele.traitement.Sommet;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Scenario class for the traitement package
 *
 * @author Groupe SAE PNR 1D1
 */
public class ScenarioTraitement {
    /**
     * Entry point of the program
     *
     * @param args arguments of the program
     */
    public static void main(String[] args) {
        p("## Scenario de traitement");
        ArrayList<Sommet> sommets = testSommet();
        testGraphe(sommets);
    }

    /**
     * Test the Sommet class
     *
     * @return ArrayList of Sommet
     */
    private static ArrayList<Sommet> testSommet() {
        p("--- Test de la classe Sommet ---");

        Date date = new Date(162523025);
        Time heure = new Time(80000000);
        Lieu lieu = new Lieu(268045.333, 6744460.457);
        ObsBatracien obs = new ObsBatracien(12, date, heure, lieu, new ArrayList<>(), new int[]{1, 3, 2, 5},
                EspeceBatracien.CALAMITE);
        Sommet s1 = new Sommet(obs);
        Sommet s2 = new Sommet(78, lieu, date, EspeceObservee.BATRACIEN);
        Sommet s3 = new Sommet(98, lieu, date, EspeceObservee.BATRACIEN);
        Sommet s4 = new Sommet(35, lieu, date, EspeceObservee.BATRACIEN);
        Sommet s5 = null;
        try {
            s5 = new Sommet(-5, lieu, date, EspeceObservee.BATRACIEN);
        } catch (Exception e) {
            p("Exception : " + e.getMessage() + " ; OK");
        }

        p("Sommet s1 : " + s1);
        p("Sommet s2 : " + s2);
        p("Sommet s3 : " + s3);
        p("Sommet s4 : " + s4);
        p("Sommet s5 : " + s5);

        p("");

        s1.setId(0);
        p("s1.setId(0) = " + s1.getId());
        s1.setDate(new Date(162523025));
        p("s1.setDate(new Date(1)) = " + s1.getDate());
        s1.setCoordLieu(new Lieu(500, 6000000));
        p("s1.setCoordLieu(new Lieu(1, 6506512)) = " + s1.getCoordLieu());
        s1.setEspece(EspeceObservee.LOUTRE);
        p("s1.setEspece(EspeceObservee.LOUTRE) = " + s1.getEspece());

        p("");

        s2.setId(1);
        p("s2.setId(1) = " + s2.getId());
        s2.setDate(new Date(2));
        p("s2.setDate(new Date(2)) = " + s2.getDate());
        s2.setCoordLieu(new Lieu(500, 6000000));
        p("s2.setCoordLieu(new Lieu(2, 6985410)) = " + s2.getCoordLieu());
        s2.setEspece(EspeceObservee.BATRACIEN);
        p("s2.setEspece(EspeceObservee.BATRACIEN) = " + s2.getEspece());

        p("");

        s3.setId(2);
        p("s3.setId(2) = " + s3.getId());
        s3.setDate(new Date(3));
        p("s3.setDate(new Date(3)) = " + s3.getDate());
        s3.setCoordLieu(new Lieu(3, 6995410));
        p("s3.setCoordLieu(new Lieu(3, 6995410)) = " + s3.getCoordLieu());
        s3.setEspece(EspeceObservee.BATRACIEN);
        p("s3.setEspece(EspeceObservee.BATRACIEN) = " + s3.getEspece());

        p("");

        s4.setId(3);
        p("s4.setId(3) = " + s4.getId());
        s4.setDate(new Date(4));
        p("s4.setDate(new Date(4)) = " + s4.getDate());
        s4.setCoordLieu(new Lieu(4, 6995410));
        p("s4.setCoordLieu(new Lieu(4, 6995410)) = " + s4.getCoordLieu());
        s4.setEspece(EspeceObservee.BATRACIEN);
        p("s4.setEspece(EspeceObservee.BATRACIEN) = " + s4.getEspece());

        p("");

        p("s1.calculeDist(s2) = " + s1.calculeDist(s2));
        p("s2.calculeDist(s1) = " + s2.calculeDist(s1));
        p("s1.calculeDist(s3) = " + s1.calculeDist(s3));
        p("s3.calculeDist(s1) = " + s3.calculeDist(s1));
        p("s1.calculeDist(s4) = " + s1.calculeDist(s4));
        p("s4.calculeDist(s1) = " + s4.calculeDist(s1));

        ArrayList<Sommet> ret = new ArrayList<Sommet>();
        ret.add(s1);
        ret.add(s2);
        ret.add(s3);
        ret.add(s4);
        // ret.add(s5); Sommet nul

        p("");
        ret.forEach(System.out::println);
        p("\n");

        return ret;
    }

    /**
     * Test de la classe Graphe
     *
     * @param sommets Liste de sommets
     */
    private static void testGraphe(ArrayList<Sommet> sommets) {
        p("--- Test de la classe Graphe ---");

        HashMap<Sommet, ArrayList<Sommet>> hashMap = new HashMap<>();

        ArrayList<Sommet> sommet0 = new ArrayList<>(); // Id : 0
        sommet0.add(sommets.get(0));
        sommet0.add(sommets.get(1));
        sommet0.add(sommets.get(2));
        sommet0.add(sommets.get(3));

        ArrayList<Sommet> sommet1 = new ArrayList<>(); // Id : 1
        sommet1.add(sommets.get(0));

        ArrayList<Sommet> sommet2 = new ArrayList<>(); // Id : 2
        sommet2.add(sommets.get(0));
        sommet2.add(sommets.get(3));
        // sommets3.add(sommets.get(4));

        ArrayList<Sommet> sommet3 = new ArrayList<>(); // Id : 3
        sommet3.add(sommets.get(0));
        sommet3.add(sommets.get(2));
        // sommets4.add(sommets.get(4));

        hashMap.put(sommets.get(0), sommet0);
        hashMap.put(sommets.get(1), sommet1);
        hashMap.put(sommets.get(2), sommet2);
        hashMap.put(sommets.get(3), sommet3);

        /*
         * Graph looks like
         *
         * 0 - 1
         * |\
         * | \
         * |  \
         * 3 - 2
         *
         */

        Graphe g1 = new Graphe(hashMap);
        Graphe g2 = new Graphe(g1);

        p("");

        p("--- toString()");
        p(g1);

        p("");

        p("--- getSommetsVoisins");
        p("g1.getSommetsVoisins() >>> " + g1.getSommetsVoisins() + "\n");
        p("g2.getSommetsVoisins() >>> " + g2.getSommetsVoisins());

        p("");

        p("--- nbSommets()");
        p("g1.nbSommets() = 4 >>> " + g1.nbSommets());
        p("g2.nbSommets() = 4 >>> " + g2.nbSommets());

        p("");

        p("--- nbAretes()");
        p("g1.nbAretes() = 5 >>> " + g1.nbAretes());
        p("g2.nbAretes() = 5 >>> " + g2.nbAretes());

        p("");

        p("--- estDansGraphe()");
        p("g1.estDansGraphe(2) = true >>> " + g1.estDansGraphe(2));
        p("g2.estDansGraphe(2) = true >>> " + g2.estDansGraphe(2));
        p("g1.estDansGraphe(6) = false >>> " + g1.estDansGraphe(6));
        p("g1.estDansGraphe(9) = false >>> " + g1.estDansGraphe(9));

        p("");

        p("--- calculeDegre()");
        p("g1.calculeDegre(0) = 4  >>> " + g1.calculeDegre(0));
        p("g1.calculeDegre(1) = 1 >>> " + g1.calculeDegre(1));
        p("g2.calculeDegre(2) = 2 >>> " + g2.calculeDegre(2));
        p("g2.calculeDegre(3) = 2 >>> " + g2.calculeDegre(3));

        p("");

        p("--- calculeDegres()");
        HashMap<Sommet, Integer> degres = g1.calculeDegres();
        for (Sommet s : degres.keySet())
            p("id : " + s.getId() + " >>> " + degres.get(s));

        p("");

        p("--- somMaxDegree()");
        p("g1.somMaxDegre() = 0  >>> " + g1.somMaxDegree().getId());

        p("");

        p("--- sontVoisins()");
        p("g1.sontVoisins(0,0) = true >>> " + g1.sontVoisins(0, 0));
        p("g1.sontVoisins(0,2) = true >>> " + g1.sontVoisins(0, 2));
        p("g1.sontVoisins(2,0) = true >>> " + g1.sontVoisins(2, 0));
        p("g1.sontVoisins(2,3) = true >>> " + g1.sontVoisins(2, 3));
        p("g1.sontVoisins(3,1) = false >>> " + g1.sontVoisins(3, 1));
        p("g1.sontVoisins(1,3) = false >>> " + g1.sontVoisins(1, 3));

        p("");

        // Adding an isolated vertex
        HashMap<Sommet, ArrayList<Sommet>> hashMap2 = new HashMap<>(hashMap);
        hashMap2.put(new Sommet(4, new Lieu(5500, 6000000), new Date(0), EspeceObservee.BATRACIEN),
                new ArrayList<Sommet>());
        Graphe g3 = new Graphe(hashMap2);

        p("--- existeChemin()");
        p("g3.existeChemin(0,1) = true >>> " + g3.existeChemin(0, 1));
        p("g3.existeChemin(1,0) = true >>> " + g3.existeChemin(1, 0));
        p("g3.existeChemin(0,2) = true >>> " + g3.existeChemin(0, 2));
        p("g3.existeChemin(2,0) = true >>> " + g3.existeChemin(2, 0));
        p("g3.existeChemin(0,4) = false >>> " + g3.existeChemin(0, 4));
        p("g3.existeChemin(4,0) = false >>> " + g3.existeChemin(4, 0));
        p("g3.existeChemin(2,4) = false >>> " + g3.existeChemin(2, 4));
        p("g3.existeChemin(4,2) = false >>> " + g3.existeChemin(4, 2));

        p("");

        p("--- voisins()");
        p("g1.voisins(0) >>> (id) [0, 1, 2, 3] \n" + g1.voisins(0) + "\n");
        p("g1.voisins(1) >>> (id) [0] \n" + g1.voisins(1) + "\n");
        p("g1.voisins(2) >>> (id) [0, 3] \n" + g1.voisins(2) + "\n");
        p("g1.voisins(3) >>> (id) [0, 2] \n" + g1.voisins(3) + "\n");

        p("");

        p("--- ajouteArete()");
        p(g3);
        p("g3.ajouteArete(0, 4) = true >>> " + g3.ajouteArete(0, 4));
        p("g3.ajouteArete(1, 4) = true >>> " + g3.ajouteArete(1, 4));
        p("g3.ajouteArete(2, 2) = true >>> " + g3.ajouteArete(2, 2));
        p("g3.ajouteArete(1, 5) = false >>> " + g3.ajouteArete(1, 5));
        p("");
        p("New " + g3);

        // p("");

        p("--- retireArete()");
        p(g3);
        p("g3.retireArete(0, 4) = true >>> " + g3.retireArete(0, 4));
        p("g3.retireArete(1, 4) = true >>> " + g3.retireArete(1, 4));
        p("g3.retireArete(2, 2) = true >>> " + g3.retireArete(2, 2));
        p("g3.retireArete(1, 5) = false >>> " + g3.retireArete(1, 5));
        p("");
        p("New " + g3);

        // p("");

        p("--- matriceAdjacence()");
        p(g3);
        p("g3.matriceAdjacence() >>>");

        int[][] adj = g1.matriceAdjacence();
        for (int[] y : adj) {
            for (int x : y)
                System.out.print(x + " ");
            p("");
        }

        p("");

        p("--- estConnexe()");
        p("g1.estConnexe() = true >>> " + g1.estConnexe());
        p("g3.estConnexe() = false >>> " + g3.estConnexe());

        p("");

        p("--- composanteConnexe()");
        p("g1.composanteConnexe() = >>> " + g1.composanteConnexe());
        p("g3.composanteConnexe() = >>>\n" + g3.composanteConnexe());

        p("");

        p("--- excentricite()");
        p("g1.excentricite() = 1 >>> " + g1.excentricite(0));
        p("g1.excentricite() = 2 >>> " + g1.excentricite(2));
        p("g3.excentricite() = -1 >>> " + g3.excentricite(0));
        p("g3.excentricite() = -1 >>> " + g3.excentricite(2));

        p("");

        p("--- rayon()");
        p("g1.rayon() = 1 >>> " + g1.rayon());
        p("g3.rayon() = -1 >>> " + g3.rayon());

        p("");

        p("--- diametre()");
        p("g1.diametre() = 2 >>> " + g1.diametre());
        p("g3.diametre() = -1 >>> " + g3.diametre());
    }

    /**
     * Shorthand for System.out.println()
     *
     * @param o the object to print
     */
    private static void p(Object o) {
        System.out.println(o);
    }
}
