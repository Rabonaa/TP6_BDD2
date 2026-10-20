package tp.ecole.model;

/**
 * POJO représentant un cours de la base COURS.
 */
public class Cours {

    // Attributs correspondant aux colonnes de la table COURS
    private int numCours;
    private String nom;
    private int nbHeures;
    private int annee;

    /**
     * Constructeur sans argument.
     */
    public Cours() {
    }

    /**
     * Constructeur avec tous les attributs.
     */
    public Cours(int numCours, String nom, int nbHeures, int annee) {
        this.numCours = numCours;
        this.nom = nom;
        this.nbHeures = nbHeures;
        this.annee = annee;
    }

    // Getter et setter de numCours

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    // Getter et setter de nom

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et setter de nbHeures

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    // Getter et setter de annee

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * Retourne une représentation lisible du cours.
     */
    @Override
    public String toString() {
        return "Cours{" +
                "numCours=" + numCours +
                ", nom='" + nom + '\'' +
                ", nbHeures=" + nbHeures +
                ", annee=" + annee +
                '}';
    }
}