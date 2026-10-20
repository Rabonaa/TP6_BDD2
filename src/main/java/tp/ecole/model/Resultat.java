package tp.ecole.model;

/**
 * POJO représentant un résultat (inscription + note) de la base RESULTATS.
 *
 * Schéma SQL de référence :
 *   NUM_ELEVE  NUMERIC(6)  PK, FK -> ELEVES
 *   NUM_COURS  NUMERIC(4)  PK, FK -> COURS
 *   POINTS     NUMERIC(3)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés (numEleve, numCours, points).
 *      Vous pouvez également ajouter des champs calculés ou enrichis
 *      (ex. nomCours, nomEleve) pour faciliter l'affichage.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher le résultat de façon lisible.
 *
 * =====================================================================
 */
public class Resultat {

    // TODO : déclarez les attributs privés (numEleve, numCours, points)
    private int numEleve;
    private int numCours;
    private double points;

    // TODO : constructeur par défaut
    public Resultat(){}

    // TODO : constructeur avec tous les paramètres
    public Resultat(int numEleve, int numCours, double points){
        this.numEleve = numEleve;
        this.numCours = numCours;
        this.points = points;
    }

    // TODO : getters et setters
    public int getNumEleve(int numEleve){return numEleve;}
    public int getNumCours(int numCours){return numCours;}
    public double getPoints(double points){return points;}

    public void setNumEleve(int numEleve){this.numEleve = numEleve;}
    public void setNumCours(int numCours){this.numCours = numCours;}
    public void setPoints(double points){this.points = points;}

    // TODO : toString()
    @Override
    public String toString(){
        return "RESULTAT : "
                + "\nELEVE : " + numEleve
                + "\nCOURS : "+ numCours
                + "\nPoints : " + points + "\n";
    }
}
