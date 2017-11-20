import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMembre_add", urlPatterns ={"/add-membre"})
public class ServletMembre_add extends HttpServlet {

    public ListeMembre listeMembre = new ListeMembre();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");

        /*
         * Récupération des données saisies, envoyées en tant que paramètres
         * à la validation du formulaire
         */
        String nom = request.getParameter( "Membre_Nom" );
        String prenom = request.getParameter( "Membre_Prenom" );
        String dateNaissance = request.getParameter( "Membre_DateNaissance" );
        String club = request.getParameter( "FK_Club" );

        //Ajoute à la liste des membres
        listeMembre.ajouteMembre (new Membre (nom, prenom, dateNaissance, club));

        response.sendRedirect("/membre");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/vues/membreAdd.jsp").forward(request,response);
    }

}
