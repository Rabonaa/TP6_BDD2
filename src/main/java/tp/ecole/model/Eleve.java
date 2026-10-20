package tp.ecole.model;

import java.time.LocalDate;

/**
 * POJO représentant un élève de la base ELEVES.
 * TODO : Répondre à la question :
 * * En quoi ce modèle objet diffère-t-il du modèle relationnel ?
 * Réponse :
 * * Le modèle relationnel organise les données dans des tables composées
 * * de lignes et de colonnes. Une ligne de la table ELEVES représente
 * * un élève et les colonnes représentent ses différentes informations.
 * *
 * * Le modèle objet représente ces mêmes données sous la forme d'objets
 * * Java. Un objet Eleve contient des attributs, comme le nom et le prénom,
 * * ainsi que des méthodes, comme les getters et les setters.
 * *
 * * Une ligne de la table ELEVES correspond donc à un objet Eleve.
 * * Les DAO permettront ensuite de transformer les lignes SQL en objets
 * * Java et inversement.
 */
public class Eleve {

    // Attributs représentant les colonnes de la table ELEVES
    private int numEleve;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int poids;
    private int annee;
    private String genre;

    /**
     * Constructeur sans argument.
     */
    public Eleve() {
    }

    /**
     * Constructeur avec tous les attributs.
     */
    public Eleve(
            int numEleve,
            String nom,
            String prenom,
            LocalDate dateNaissance,
            int poids,
            int annee,
            String genre
    ) {
        this.numEleve = numEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.poids = poids;
        this.annee = annee;
        this.genre = genre;
    }

    // Getter et setter de numEleve

    public int getNumEleve() {
        return numEleve;
    }

    public void setNumEleve(int numEleve) {
        this.numEleve = numEleve;
    }

    // Getter et setter de nom

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et setter de prenom

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter et setter de dateNaissance

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Getter et setter de poids

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    // Getter et setter de annee

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // Getter et setter de genre

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Affiche les informations de l'élève de manière lisible.
     */
    @Override
    public String toString() {
        return "Eleve{" +
                "numEleve=" + numEleve +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", poids=" + poids +
                ", annee=" + annee +
                ", genre='" + genre + '\'' +
                '}';
    }
}