import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {

    static Connection connection = null;

    //////////grrrrrrr
    private static Connection connectionOuverture() {
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
        return connection;

    }

    public static void connectionFermeture(ResultSet rs) {       //fermer le resultset
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void connectionFermeture(Statement smt) {       //fermer le statment
        if (smt != null) {
            try {
                smt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void connectionFermeture(Connection connection) {       //fermer la connexion
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void ajoutMembre(String nom, String prenom, String dateNaissance, String club) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        requete = connection.prepareStatement("insert into membres(Membre_Nom, Membre_Prenom, Membre_DateNaissance, FK_Club) values (?,?,?,?)");
        requete.setString(1, nom);
        requete.setString(2, prenom);
        requete.setString(3, dateNaissance);
        requete.setInt(4, Integer.parseInt(club));

        //requete.setString(2, mdpp);
        //exécuter la requete
        requete.executeUpdate();


        connectionFermeture(requete);
        connectionFermeture(connection);
    }


    public static void ajoutClub(String nom, String type) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        requete = connection.prepareStatement("insert into clubs(Club_Nom, Club_Type) values (?,?)");
        requete.setString(1, nom);
        requete.setString(2, type);

        //requete.setString(2, mdpp);
        //exécuter la requete
        requete.executeUpdate();


        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    public static ListeMembre recupereMembre(){

        ListeMembre membres= new ListeMembre();

        Connection connection = connectionOuverture();
        PreparedStatement requete = null;
        ResultSet rs = null;

        //PreparedStatement requete;

        {
            try {
                requete = connection.prepareStatement("SELECT * FROM membres INNER JOIN clubs on FK_Club=PK_CLub ORDER by Membre_Nom, Membre_Prenom");
                rs = requete.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nom = rs.getString(2);
                    String prenom = rs.getString(3);
                    Date datesql = rs.getDate(4);
                    SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
                    String dateNaissance = sdfr.format(datesql);
                    String clubNom = rs.getString(7);
                    System.out.println("Nom : "+nom+" / Prénom : "+prenom+ " / Date de naissance "+dateNaissance+" /Nom du club "+clubNom);
                    membres.add(new Membre(nom, prenom, dateNaissance, clubNom));


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionFermeture(rs);
            connectionFermeture(requete);
            connectionFermeture(connection);
            //return membres;

        }
        return membres;
    }


    public static ListeClub recupereClub(){

        ListeClub clubs= new ListeClub();

        Connection connection = connectionOuverture();
        PreparedStatement requete = null;
        ResultSet rs = null;

        //PreparedStatement requete;

        {
            try {
                requete = connection.prepareStatement("SELECT * FROM clubs ORDER by Club_Nom, Club_Type");
                rs = requete.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nom = rs.getString(2);
                    String type = rs.getString(3);
                    System.out.println("Nom : "+nom+" / Type : "+type);
                    clubs.add(new Club(nom, type));


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionFermeture(rs);
            connectionFermeture(requete);
            connectionFermeture(connection);
            //return membres;

        }
        return clubs;
    }


}



