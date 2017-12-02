import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;

@WebServlet(name = "Servlet", urlPatterns = {"/add-club"})
public class ServletClub_add extends HttpServlet {

    private ListeClub listeClub = new ListeClub();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");

        /*
         * Récupération des données saisies, envoyées en tant que paramètres
         * à la validation du formulaire
         */
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");

        try {
            //Ajoute à la liste des clubs via la classe base de données
            BaseDeDonnees.ajoutClub(nom, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/club");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("clubs", listeClub.recupereClubs());
        request.getRequestDispatcher("/vues/clubAdd.jsp").forward(request, response);
    }

}
