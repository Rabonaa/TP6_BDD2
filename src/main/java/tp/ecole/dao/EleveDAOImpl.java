package tp.ecole.dao;

import tp.ecole.model.Eleve;
import tp.ecole.util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation JDBC de l'interface EleveDAO.
 *
 * =====================================================================
 * TODO (Question 4) :
 *   Implémentez chaque méthode en respectant les règles suivantes :
 *
 *   1. Utilisez ConnectionManager.getConnection() pour obtenir la connexion.
 *   2. Utilisez OBLIGATOIREMENT des PreparedStatement.
 *   3. Utilisez try-with-resources pour fermer les ressources JDBC.
 *   4. Mappez chaque ligne du ResultSet vers un objet Eleve.
 *   5. Gérez les SQLException : choisissez de les propager (throws)
 *      ou de les encapsuler dans une DaoException, et justifiez
 *      votre choix dans le compte-rendu.
 *
 
 * =====================================================================
 */
public class EleveDAOImpl implements EleveDAO {

    private Eleve mapResultSetToEleve(ResultSet rs) throws SQLException {
        Eleve ligne = new Eleve();
        ligne.setNumEleve(rs.getInt("num_eleve"));
        ligne.setNom(rs.getString("nom"));
        ligne.setPrenom(rs.getString("prenom"));
        ligne.setDateNaissance(rs.getObject("date_naissance", LocalDate.class));
        ligne.setPoids(rs.getDouble("poids"));
        ligne.setAnnee(rs.getInt("annee"));
        ligne.setGenre(rs.getString("genre"));
        return ligne;
    }

    @Override
    public List<Eleve> findAll() throws SQLException {
        // TODO : interroger la table ELEVES et retourner tous les élèves
        String sql = "SELECT * FROM ELEVES";
        List<Eleve> eleves = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                eleves.add(mapResultSetToEleve(rs));
            }
        }
        if(eleves.isEmpty()){
            System.out.println("Aucun eleve trouve.");
        }
        return eleves;
    }

    @Override
    public Eleve findById(int numEleve) throws SQLException {
        // TODO : SELECT * FROM ELEVES WHERE NUM_ELEVE = ?
        String sql = "SELECT * FROM ELEVES WHERE NUM_ELEVE = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, numEleve);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEleve(rs);
                }
            }
        }
        System.out.println("Aucun eleve trouve.");
        return null;
    }

    @Override
    public List<Eleve> findByNom(String nom) throws SQLException {
        // TODO : SELECT * FROM ELEVES WHERE NOM LIKE ?
        //        (penser à ajouter '%' pour une recherche partielle)
        String sql = "SELECT * FROM ELEVES WHERE NOM LIKE ?";
        List<Eleve> eleves = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nom + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    eleves.add(mapResultSetToEleve(rs));
                }
            }
        }
        if(eleves.isEmpty()){
            System.out.println("Aucun eleve trouve.");
        }
        return eleves;
    }

    @Override
    public void save(Eleve eleve) throws SQLException {
        // TODO : INSERT INTO ELEVES (NUM_ELEVE, NOM, PRENOM, ...) VALUES (?, ?, ?, ...)
        String sql = "INSERT INTO ELEVES (NUM_ELEVE, NOM, PRENOM, DATE_NAISSANCE, POIDS, ANNEE, GENRE)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, eleve.getNumEleve());
            pstmt.setString(2, eleve.getNom());
            pstmt.setString(3, eleve.getPrenom());
            pstmt.setObject(4, eleve.getDateNaissance());
            pstmt.setDouble(5, eleve.getPoids());
            pstmt.setInt(6, eleve.getAnnee());
            pstmt.setString(7, eleve.getGenre());

            int lignesInsere = pstmt.executeUpdate();

            if(lignesInsere == 0){
                System.out.println("Erreur d'insertion");
            }
        }
    }

    @Override
    public void update(Eleve eleve) throws SQLException {
        // TODO : UPDATE ELEVES SET NOM=?, PRENOM=?, ... WHERE NUM_ELEVE=?
//        throw new UnsupportedOperationException("Erreur");
        String sql = "UPDATE ELEVES SET NOM=?, PRENOM=?, DATE_NAISSANCE=?, POIDS=?, ANNEE=?, GENRE=? " +
                "WHERE NUM_ELEVE=?";
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, eleve.getNom());
            pstmt.setString(2, eleve.getPrenom());
            pstmt.setObject(3, eleve.getDateNaissance());
            pstmt.setDouble(4, eleve.getPoids());
            pstmt.setInt(5, eleve.getAnnee());
            pstmt.setString(6, eleve.getGenre());
            pstmt.setInt(7, eleve.getNumEleve());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(int numEleve) throws SQLException {
        // TODO : DELETE FROM ELEVES WHERE NUM_ELEVE=?
        //        Attention : vérifiez qu'il n'y a pas de contraintes de clé étrangère
        //        (l'élève peut avoir des RESULTATS ou ACTIVITES_PRATIQUEES)
//        throw new UnsupportedOperationException("À implémenter — Question 4");
        String sqlResultats = "DELETE FROM RESULTATS WHERE NUM_ELEVE = ?";
        String sqlActivites = "DELETE FROM ACTIVITES_PRATIQUEES WHERE NUM_ELEVE = ?";
        String sqlEleve = "DELETE FROM ELEVES WHERE NUM_ELEVE = ?";

        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try {
                try (PreparedStatement pstmt1 = connection.prepareStatement(sqlResultats)) {
                    pstmt1.setInt(1, numEleve);
                    pstmt1.executeUpdate();
                }

                try (PreparedStatement pstmt2 = connection.prepareStatement(sqlActivites)) {
                    pstmt2.setInt(1, numEleve);
                    pstmt2.executeUpdate();
                }

                // Suppression de l'élève
                try (PreparedStatement pstmt3 = connection.prepareStatement(sqlEleve)) {
                    pstmt3.setInt(1, numEleve);
                    pstmt3.executeUpdate();
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        }
    }
}
