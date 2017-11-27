import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletClub_mod", urlPatterns = {"/mod-club"})
public class ServletClub_mod extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");


        /*
         * Récupération des données saisies, envoyées en tant que paramètres
         * à la validation du formulaire
         */
        String id =request.getParameter("id");
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");

        try {
            BaseDeDonnees.modClub(id, nom, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/club");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("clubs", BaseDeDonnees.chercheClub(request.getParameter("clubs")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("vues/clubMod.jsp").forward(request,response);

    }
}
