package tp.ecole.ui;

import tp.ecole.dao.ResultatDAO;
import tp.ecole.dao.ResultatDAOImpl;
import tp.ecole.model.Cours;
import tp.ecole.model.Eleve;
import tp.ecole.model.Resultat;
import tp.ecole.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestModel {
    public static void main(String[] args) {
        Eleve eleve1 = new Eleve(1, "Bone", "Mike",
                LocalDate.of(2000, 3, 15), 70.0, 3, "M");
        System.out.println(eleve1);

        Cours cours1 = new Cours(1,
                "Maths", 325, 3);
        System.out.println(cours1);

        Resultat resultat1 = new Resultat(1, 1, 15.0);
        System.out.println(resultat1);

        ResultatDAOImpl result = new result();

    }
}
