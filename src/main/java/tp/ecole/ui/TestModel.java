package tp.ecole.ui;

import tp.ecole.model.Eleve;
import tp.ecole.model.Cours;
import tp.ecole.model.Resultat;

import java.time.LocalDate;

public class TestModel {

    public static void main(String[] args) {

        System.out.println("===== TEST DES CLASSES DU MODELE =====");

        // Création d'un objet Eleve avec le constructeur complet
        Eleve eleve = new Eleve(
                1,
                "Dupont",
                "Alice",
                LocalDate.of(2004, 5, 17),
                60,
                2,
                "F"
        );

        // Création d'un objet Cours avec le constructeur complet
        Cours cours = new Cours(
                1,
                "Programmation",
                30,
                2
        );

        // Création d'un objet Resultat avec le constructeur complet
        Resultat resultat = new Resultat(
                1,
                1,
                15.5
        );

        // Affichage des objets grâce à leur méthode toString()
        System.out.println();
        System.out.println("Élève créé :");
        System.out.println(eleve);

        System.out.println();
        System.out.println("Cours créé :");
        System.out.println(cours);

        System.out.println();
        System.out.println("Résultat créé :");
        System.out.println(resultat);

        System.out.println();
        System.out.println("===== FIN DU TEST =====");
    }
}