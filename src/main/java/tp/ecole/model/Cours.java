package tp.ecole.model;

/**
 * POJO représentant un cours de la base COURS.
 *
 * Schéma SQL de référence :
 *   NUM_COURS  NUMERIC(4)  PK
 *   NOM        VARCHAR(20)
 *   NBHEURES   NUMERIC(2)
 *   ANNEE      NUMERIC(1)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés correspondant aux colonnes ci-dessus.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher le cours de façon lisible.
 * =====================================================================
 */
public class Cours {

    // TODO : déclarez les attributs privés (numCours, nom, nbHeures, annee)
    private int numCours;
    private String nom;
    private double nbHeures;
    private int annee;

    // TODO : constructeur par défaut
    public Cours(){}
    // TODO : constructeur avec tous les paramètres
    public Cours(int numCours, String nom, double nbHeures, int annee){
        this.numCours = numCours;
        this.nom = nom;
        this.nbHeures = nbHeures;
        this.annee = annee;
    }
    // TODO : getters et setters
    public int getNumCours(){return numCours;}
    public String getNom(){return nom;}
    public double getNbHeures(){return nbHeures;}
    public int getAnnee(){return annee;}

    public void setNumCours(int numCours){this.numCours = numCours;}
    public void setNom(String nom){this.nom = nom;}
    public void setnbHeures(double nbHeures){this.nbHeures = nbHeures;}
    public void setannee(int annee){this.annee = annee;}

    // TODO : toString()
    @Override
    public String toString(){
        return "COURS " + numCours + " :"
                + "\nNom du cours : " + nom
                + "\nNombre d'heures : " + nbHeures
                + "\nAnnee : " + annee + "\n";
    }
}
