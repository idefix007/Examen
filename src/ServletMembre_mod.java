import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "ServletMembre_mod", urlPatterns = {"/mod-membre"})
public class ServletMembre_mod extends HttpServlet {

    public ListeMembre listeMembre = new ListeMembre();
    private ListeClub listeClub = new ListeClub();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");


        /*
         * Récupération des données saisies, envoyées en tant que paramètres
         * à la validation du formulaire
         */
        String id =request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateN");
        String club = request.getParameter("club");
        try {
            BaseDeDonnees.modMembre(id, nom, prenom,dateNaissance, club);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //int clubId=(int)club;

        //Ajoute à la liste des membres
        //listeMembre.ajouteMembre (new Membre (nom, prenom, dateNaissance, club));

       /* Connection connection = null;
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
            requete = connection.prepareStatement("insert into membres(Membre_Nom, Membre_Prenom, Membre_DateNaissance, FK_Club) values (?,?,?,?)");
            requete.setString(1, nom);
            requete.setString(2, prenom);
            requete.setString(3, dateNaissance);
            requete.setInt(4, Integer.parseInt(club));

            //requete.setString(2, mdpp);
            //exécuter la requete
            requete.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        //fermer la connexion
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (requete != null) {
                try {
                    requete.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

*/
        response.sendRedirect("/membre");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("clubs", listeClub.recupereClubs());
        //getServletContext().getRequestDispatcher("/vues/listeMembres.jsp").forward(request, response);
        int id = Integer.parseInt(request.getParameter("membresid"));
        String nom = request.getParameter("membresnom");
        String prenom = request.getParameter("membresprenom");
        String dateN = request.getParameter("membresdatenaissance");
        String club = request.getParameter("membresclub");
        Membre membremod=new Membre(id,nom,prenom,dateN,club);
        request.setAttribute("membres", listeMembre.recupereMembres());
        response.sendRedirect("/vues/membreMod.jsp");
    }

}
