package tp.ecole.dao;

import tp.ecole.model.Resultat;
import tp.ecole.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultatDAOImpl implements ResultatDAO {

    // 1. Trouver tous les résultats (notes) pour un élève précis
    @Override
    public List<Resultat> findByEleve(int numEleve) throws SQLException {
        List<Resultat> listeResultats = new ArrayList<>();
        String sql = "SELECT * FROM resultats WHERE num_eleve = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numEleve); // On remplace le '?' par l'ID de l'élève

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Resultat res = new Resultat();
                    res.setNumEleve(rs.getInt("num_eleve"));
                    res.setNumCours(rs.getInt("num_cours"));
                    res.setPoints(rs.getDouble("points")); // Ou rs.getInt("points") si tu as mis un int dans ton modèle

                    listeResultats.add(res);
                }
            }
        }
        return listeResultats;
    }

    // 2. Inscrire un élève à un cours (sans lui donner de note)
    @Override
    public void enregistrerInscription(int numEleve, int numCours) throws SQLException {
        // Remarque : On n'insère pas la colonne "points", donc MySQL mettra "NULL" par défaut (pas de note)
        String sql = "INSERT INTO resultats (num_eleve, num_cours) VALUES (?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numEleve);
            pstmt.setInt(2, numCours);

            pstmt.executeUpdate();
        }
    }

    // 3. Ajouter ou modifier la note d'un élève pour un cours spécifique
    @Override
    public void modifierNote(int numEleve, int numCours, double note) throws SQLException {
        // On met à jour la colonne "points" en ciblant précisément l'élève ET son cours
        String sql = "UPDATE resultats SET points = ? WHERE num_eleve = ? AND num_cours = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // On remplit les 3 points d'interrogation dans l'ordre de la requête SQL
            pstmt.setDouble(1, note);
            pstmt.setInt(2, numEleve);
            pstmt.setInt(3, numCours);

            pstmt.executeUpdate();
        }
    }
}