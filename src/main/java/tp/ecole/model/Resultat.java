package tp.ecole.model;

/**
 * POJO représentant un résultat, c'est-à-dire
 * l'inscription d'un élève à un cours avec sa note.
 */
public class Resultat {

    // Attributs correspondant aux colonnes de la table RESULTATS
    private int numEleve;
    private int numCours;
    private double points;

    /**
     * Constructeur sans argument.
     */
    public Resultat() {
    }

    /**
     * Constructeur avec tous les attributs.
     */
    public Resultat(int numEleve, int numCours, double points) {
        this.numEleve = numEleve;
        this.numCours = numCours;
        this.points = points;
    }

    // Getter et setter de numEleve

    public int getNumEleve() {
        return numEleve;
    }

    public void setNumEleve(int numEleve) {
        this.numEleve = numEleve;
    }

    // Getter et setter de numCours

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    // Getter et setter de points

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    /**
     * Retourne une représentation lisible du résultat.
     */
    @Override
    public String toString() {
        return "Resultat{" +
                "numEleve=" + numEleve +
                ", numCours=" + numCours +
                ", points=" + points +
                '}';
    }
}