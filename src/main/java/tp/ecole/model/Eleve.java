package tp.ecole.model;

import java.time.LocalDate;

/**
 * POJO représentant un élève de la base ELEVES.
 *
 * Schéma SQL de référence :
 *   NUM_ELEVE  NUMERIC(6)  PK
 *   NOM        VARCHAR(25)
 *   PRENOM     VARCHAR(25)
 *   DATE_NAISSANCE DATE
 *   POIDS      NUMERIC(3)
 *   ANNEE      NUMERIC(1)
 *   GENRE      CHAR(1)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés correspondant aux colonnes ci-dessus.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher l'élève de façon lisible.
 *
 * TODO : Répondre à la question :
 *   En quoi ce modèle objet diffère-t-il du modèle relationnel ?
 * =====================================================================
 */
public class Eleve {

    // TODO : déclarez les attributs privés (numEleve, nom, prenom,
    //         dateNaissance, poids, annee, genre)
    private int numEleve;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Float poids;
    private int annee;
    private String genre;

    // TODO : constructeur par défaut
    public Eleve(int numEleve, String nom, String prenom, LocalDate dateNaissance,
                 Float poids, int annee, String genre){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.poids = poids;
        this.annee = annee;
        this.genre = genre;
    }

    // TODO : constructeur avec tous les paramètres


    // TODO : getters et setters

    // TODO : toString()
}
