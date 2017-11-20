import javax.print.DocFlavor;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListeMembre {

    private static List<Membre> membres = new ArrayList<>();

    static {

        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet rs = null;



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

            //rechercher les données de la table suivant le nom utilisateur du formulaire
            requete = connection.prepareStatement("SELECT * FROM membres INNER JOIN clubs on FK_Club=PK_CLub ORDER by Membre_Nom, Membre_Prenom");
             //requete.setString(1, recherche);
            //requete.setString(2, mdpp);
            //exécuter la requete
            rs = requete.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                Date datesql = rs.getDate(4);
                SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
                String dateNaissance = sdfr.format(datesql);

                String clubnom=rs.getString(7);
                System.out.println("Nom : "+nom+" / Prénom : "+prenom+ " / Date de naissance "+dateNaissance+" /Nom du club"+clubnom);
                membres.add(new Membre(nom, prenom, dateNaissance, clubnom));
            }





        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        //fermer la connexion
        finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(requete!=null){
                try{
                    requete.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
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

    public List<Membre> recupereMembres() {
        return membres;
    }

    public void ajouteMembre(Membre m) {


        membres.add(m);
    }


}