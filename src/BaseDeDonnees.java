import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {

    static Connection connection = null;
    static ResultSet rs = null;
    static ListeMembre membres= new ListeMembre();


    private static Connection connectionOuverture() {
        Connection connection = null;

        try {
            //chargement du driver
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

    // Chercher un membre
    public static Membre chercheMembre(String id_m) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();
        System.out.println(id_m);

        // Requête dans la db
        requete = connection.prepareStatement("SELECT * FROM membres INNER JOIN clubs on FK_Club=PK_CLub  where PK_Membre=?");
        requete.setInt(1,Integer.parseInt(id_m));
        rs = requete.executeQuery();
        Membre membre = null;
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String dateNaissance = rs.getString(4);
            int idClub = rs.getInt(5);
            String clubNom = rs.getString(7);
            System.out.println("Nom : " + nom + " / Prénom : " + prenom + " / Date de naissance " + dateNaissance + " /Nom du club " + clubNom+" / Numéro du club : "+idClub);
            membre = new Membre(id, nom, prenom, dateNaissance, clubNom, idClub);
        }
        System.out.println("Recherche du membre effectuée");
        connectionFermeture(rs);
        connectionFermeture(requete);
        connectionFermeture(connection);
        return membre;
    }

    // Ajouter un membre
    public static void ajoutMembre(String nom, String prenom, String dateNaissance, String club) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Insertion du membre dans la db
        requete = connection.prepareStatement("insert into membres(Membre_Nom, Membre_Prenom, Membre_DateNaissance, FK_Club) values (?,?,?,?)");
        requete.setString(1, nom);
        requete.setString(2, prenom);
        requete.setString(3, dateNaissance);
        System.out.println(club);
        requete.setInt(4, Integer.parseInt(club));
        System.out.println(club);
        System.out.println("Le membre a été ajouté");

        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Modifier un membre
    public static void modMembre(String id, String nom, String prenom, String dateNaissance, String club) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Update du membre dans la db
        requete = connection.prepareStatement("update membres set Membre_Nom=?, Membre_Prenom=?,Membre_DateNaissance=?, DISTINCT FK_Club=? where PK_Membre=?");
        requete.setString(1,nom);
        requete.setString(2,prenom);
        requete.setString(3,dateNaissance);
        requete.setString(4,club);
        requete.setInt(5,Integer.parseInt(id));
        System.out.println("Enregistrement modifie");


        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Supprimer un membre
    public static void supprimeMembre(String id) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Delete dans la db
        requete = connection.prepareStatement("delete from membres where PK_Membre=?");
        requete.setInt(1,Integer.parseInt(id));
        System.out.println("Membre efface");

        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Liste des membres
    public static ListeMembre recupereMembre(String id_mc){

        Connection connection = connectionOuverture();
        PreparedStatement requete = null;
        ResultSet rs = null;


        {
            try {
                // Liste de tous les membres de tous les clubs
                if (id_mc=="*"){
                    requete = connection.prepareStatement("SELECT * FROM membres INNER JOIN clubs on FK_Club=PK_CLub ORDER by Membre_Nom, Membre_Prenom");
                }
                // Liste des membres par club
                else {
                    requete = connection.prepareStatement("SELECT * FROM membres INNER JOIN clubs on FK_Club=PK_CLub where FK_Club=? ORDER by Membre_Nom, Membre_Prenom");
                    requete.setInt(1, Integer.parseInt(id_mc));
                }

                rs = requete.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nom = rs.getString(2);
                    String prenom = rs.getString(3);
                    Date datesql = rs.getDate(4);
                    SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
                    String dateNaissance = sdfr.format(datesql);
                    int idClub = rs.getInt(5);
                    String clubNom = rs.getString(7);
                    System.out.println("Nom : "+nom+" / Prénom : "+prenom+ " / Date de naissance "+dateNaissance+" /Nom du club "+clubNom);
                    membres.add(new Membre(id,nom, prenom, dateNaissance, clubNom, idClub));


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

    // Ajouter un club
    public static void ajoutClub(String nom, String type) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Insertion dans la db
        requete = connection.prepareStatement("insert into clubs(Club_Nom, Club_Type) values (?,?)");
        requete.setString(1, nom);
        requete.setString(2, type);


        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Modifier un club
    public static void modClub(String id, String nom, String type) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Update dans la db
        requete = connection.prepareStatement("update clubs set Club_Nom=?, DISTINCT Club_Type=? where PK_Club=?");
        requete.setString(1,nom);
        requete.setString(2,type);
        requete.setInt(3,Integer.parseInt(id));
        System.out.println("Enregistrement modifie");

        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Supprimer un club
    public static void supprimeClub(String id) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();

        // Delete dans la db
        requete = connection.prepareStatement("delete from clubs where PK_Club=?");
        requete.setInt(1,Integer.parseInt(id));
        System.out.println("Enregistrement efface");


        requete.executeUpdate();
        connectionFermeture(requete);
        connectionFermeture(connection);
    }

    // Chercher un club
    public static Club chercheClub(String id_c) throws SQLException {
        PreparedStatement requete = null;
        Connection connection;
        connection = connectionOuverture();
        System.out.println(id_c);

        // Requête dans la db
        requete = connection.prepareStatement("SELECT * FROM clubs where PK_Club=?");
        requete.setInt(1,Integer.parseInt(id_c));
        rs = requete.executeQuery();
        Club club = null;
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            String type = rs.getString(3);
            club = new Club(id, nom, type);
        }
        System.out.println("Recherche du membre effectuée");
        connectionFermeture(rs);
        connectionFermeture(requete);
        connectionFermeture(connection);
        return club;
    }

    // Liste des clubs
    public static ListeClub recupereClub(){

        ListeClub clubs= new ListeClub();

        Connection connection = connectionOuverture();
        PreparedStatement requete = null;
        ResultSet rs = null;

        {
            try {
                requete = connection.prepareStatement("SELECT * FROM clubs ORDER by Club_Nom, Club_Type");
                rs = requete.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nom = rs.getString(2);
                    String type = rs.getString(3);
                    System.out.println("ID : "+id+" Nom : "+nom+" / Type : "+type);
                    clubs.add(new Club(id,nom, type));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionFermeture(rs);
            connectionFermeture(requete);
            connectionFermeture(connection);

        }
        return clubs;
    }

}






