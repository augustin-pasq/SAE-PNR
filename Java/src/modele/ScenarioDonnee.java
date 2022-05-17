package modele;

import modele.donnee.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;



public class ScenarioDonnee {
    public static void main(String[] args) {
        System.out.println("## Scenario de données");

        // Creation des objets
        ArrayList<Observateur> listeObs = new ArrayList<Observateur>(); 
        Observateur obs1 = new Observateur(1, "Le Ny", "Liam");
        Observateur obs2 = new Observateur(2, "Pasquier", "Augustin");
        Observateur obs3 = new Observateur(3, "Malivet", "Ervan");
        Observateur obs4 = new Observateur(4, "Ozanne", "Colin");
        Observateur obs5 = new Observateur(5, "Tabor", "Samuel");
        Observateur obsNull = new Observateur(5, null, null);
        Observateur obsVide = new Observateur(5, "", "");
        listeObs.add(obs1);
        listeObs.add(obs2);
        listeObs.add(obs3);
        listeObs.add(obs4);
        listeObs.add(obs5);

        
        // Test de la classe Chouette

        Chouette chouette = new Chouette("1", Sexe.MALE, EspeceChouette.HULOTTE);
        chouette.setIdChouette("2");
        chouette.setIdChouette(null);
        chouette.setLesObservations(null);
        chouette.setSexe(Sexe.FEMELLE);
        Sexe nonDefini = null;
        chouette.setSexe(nonDefini);
        EspeceChouette aucuneEspece = null;
        chouette.setEspece(aucuneEspece);


        Date today = new Date(17/05/2022);
        Time now = new Time(50000);
        Time minuit = new Time(0);
        Lieu vannes = new Lieu(47.6586772, -2.7599079);
        Lieu arradon = new Lieu(47.62798, -2.8229152);

        System.out.println("Changement du sexe de la chouette en femelle");
        System.out.println("Sexe : " + chouette.getSexe());
        System.out.println("Espece : " + chouette.getEspece());
        System.out.println("Id : " + chouette.getIdChouette());
        ObsChouette obsChouette = new ObsChouette(1, today, now, vannes, listeObs, TypeObservation.SONORE);
        ObsChouette obsChouette2 = new ObsChouette(2, today, now, vannes, listeObs, TypeObservation.VISUELLE);
        ObsChouette obsChouette3 = new ObsChouette(3, today, now, arradon, listeObs, TypeObservation.SONORE);

        // Ajouter des observations
        ArrayList<ObsChouette> listeObsChouette = new ArrayList<ObsChouette>();
        listeObsChouette.add(obsChouette);
        listeObsChouette.add(obsChouette2);
        listeObsChouette.add(obsChouette3);
        chouette.setLesObservations(listeObsChouette);

        System.out.println("Affichage des observations de la chouette : ");
        // TODO
        // Arrays.toString(listeObsChouette) ??
        // Afficher listeObsChouette 

        ObsChouette obsChouette4 = new ObsChouette(4, today, now, arradon, listeObs, TypeObservation.SONORE_VISUELLE);
        chouette.ajouterUneObs(obsChouette4);


        ObsChouette obsChouette5 = new ObsChouette(5, today, minuit, arradon, listeObs, TypeObservation.SONORE_VISUELLE);
        ObsChouette obsChouette6 = new ObsChouette(6, today, minuit, arradon, listeObs, TypeObservation.SONORE_VISUELLE);
        ArrayList<ObsChouette> listeObsChouetteNuit = new ArrayList<ObsChouette>();
        listeObsChouetteNuit.add(obsChouette5);
        listeObsChouetteNuit.add(obsChouette6);

        System.out.println("Il y a au total " + chouette.nbObs() + " observations pour cet chouette");
        if (chouette.nbObs() == 6) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }

        System.out.println("L'observation numero 2 est retirée");
        chouette.retireObs(2);
        
        System.out.println("Il y a au total " + chouette.nbObs() + " observations pour cet chouette");
        if (chouette.nbObs() == 5) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
        
        System.out.println("Toutes les observations ont été retirées");
        chouette.videObs();
        System.out.println("Il y a au total " + chouette.nbObs() + " observations pour cet chouette");
        if (chouette.nbObs() == 0) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }




        Lieu lieu = new Lieu(5, 5);
        NidGCI nd = new NidGCI(109, "Bellevue");



    }
}