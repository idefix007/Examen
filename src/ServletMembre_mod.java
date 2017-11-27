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
            BaseDeDonnees.modMembre(id, nom, prenom, dateNaissance, club);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/membre");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("clubs", listeClub.recupereClubs());
        //getServletContext().getRequestDispatcher("/vues/listeMembres.jsp").forward(request, response);

        try {
            request.setAttribute("membres", BaseDeDonnees.chercheMembre(request.getParameter("membres")));
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //request.setAttribute("membres", listeMembre.recupereMembres());

        //response.sendRedirect("/vues/membreMod.jsp");
        request.setAttribute("clubs", listeClub.recupereClubs());
        request.getRequestDispatcher("vues/membreMod.jsp").forward(request,response);
    }

}
