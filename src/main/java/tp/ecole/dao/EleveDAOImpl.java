package tp.ecole.dao;

import tp.ecole.model.Eleve;
import tp.ecole.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveDAOImpl implements EleveDAO {

    // --- Méthode utilitaire pour éviter de copier-coller le remplissage de l'élève ---
    private Eleve mapResultSetToEleve(ResultSet rs) throws SQLException {
        Eleve eleve = new Eleve();
        eleve.setNumEleve(rs.getInt("num_eleve"));
        eleve.setNom(rs.getString("nom"));
        eleve.setPrenom(rs.getString("prenom"));

        if (rs.getDate("date_naissance") != null) {
            eleve.setDateNaissance(rs.getDate("date_naissance").toLocalDate());
        }

        eleve.setPoids(rs.getInt("poids"));
        eleve.setAnnee(rs.getInt("annee"));
        eleve.setGenre(rs.getString("genre"));
        return eleve;
    }

    // 1. Trouver TOUS les élèves
    @Override
    public List<Eleve> findAll() throws SQLException {
        List<Eleve> liste = new ArrayList<>();
        String sql = "SELECT * FROM eleves";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                liste.add(mapResultSetToEleve(rs));
            }
        }
        return liste;
    }

    // 2. Trouver un élève via son ID
    @Override
    public Eleve findById(int numEleve) throws SQLException {
        String sql = "SELECT * FROM eleves WHERE num_eleve = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numEleve);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEleve(rs);
                }
            }
        }
        return null; // Retourne null si aucun élève n'a été trouvé
    }

    // 3. Trouver des élèves via leur nom
    @Override
    public List<Eleve> findByNom(String nom) throws SQLException {
        List<Eleve> liste = new ArrayList<>();
        String sql = "SELECT * FROM eleves WHERE nom LIKE ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom + "%"); // Le % permet de chercher tous les noms qui commencent par ça

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    liste.add(mapResultSetToEleve(rs));
                }
            }
        }
        return liste;
    }

    // 4. Insérer un nouvel élève
    @Override
    public void save(Eleve eleve) throws SQLException {
        // On vérifie bien qu'il y a 7 colonnes et 7 points d'interrogation
        String sql = "INSERT INTO eleves (num_eleve, nom, prenom, date_naissance, poids, annee, genre) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, eleve.getNumEleve());
            pstmt.setString(2, eleve.getNom()); // C'est cette ligne qui envoyait "null" avant !
            pstmt.setString(3, eleve.getPrenom());

            if (eleve.getDateNaissance() != null) {
                pstmt.setDate(4, Date.valueOf(eleve.getDateNaissance()));
            } else {
                pstmt.setNull(4, Types.DATE);
            }

            pstmt.setInt(5, eleve.getPoids());
            pstmt.setInt(6, eleve.getAnnee());
            pstmt.setString(7, eleve.getGenre());

            pstmt.executeUpdate();
        }
    }

    // 5. Mettre à jour un élève existant
    @Override
    public void update(Eleve eleve) throws SQLException {
        String sql = "UPDATE eleves SET nom=?, prenom=?, date_naissance=?, poids=?, annee=?, genre=? WHERE num_eleve=?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eleve.getNom());
            pstmt.setString(2, eleve.getPrenom());
            pstmt.setDate(3, eleve.getDateNaissance() != null ? Date.valueOf(eleve.getDateNaissance()) : null);
            pstmt.setInt(4, eleve.getPoids());
            pstmt.setInt(5, eleve.getAnnee());
            pstmt.setString(6, eleve.getGenre());
            pstmt.setInt(7, eleve.getNumEleve()); // L'ID sert pour le WHERE

            pstmt.executeUpdate();
        }
    }

    // 6. Supprimer un élève
    @Override
    public void delete(int numEleve) throws SQLException {
        String sql = "DELETE FROM eleves WHERE num_eleve=?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numEleve);
            pstmt.executeUpdate();
        }
    }
}