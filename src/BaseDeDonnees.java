import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class BaseDeDonnees {
//////////grrrrrrr
    public void connectionOuverture() {
        Connection connection = null;

        try {
            //chargement du driver^pm
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Pilote MySQL JDBC chargé");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargmement du pilote");
        }
        try {
            //obtention de la connexion
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/5ipoo", "root", "");
            System.out.println("Connexion opérationnelle");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }

    }
    public static void connectionFermeture(ResultSet rs) {       //fermer le resultset
        if(rs!=null) {
            try {
                rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }
    public static void connectionFermeture(Statement smt) {       //fermer le statment
        if(smt!=null) {
            try {
                smt.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }


    public static void connectionFermeture(Connection connection) {       //fermer la connexion
        if(connection!=null) {
            try {
                connection.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}