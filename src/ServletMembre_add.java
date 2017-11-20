import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMembre_add", urlPatterns ={"/add-membre"})
public class ServletMembre_add extends HttpServlet {

    public ListeMembre listeMembre = new ListeMembre();
    private ListeClub listeClub = new ListeClub();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");

        /*
         * Récupération des données saisies, envoyées en tant que paramètres
         * à la validation du formulaire
         */
        String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String dateNaissance = request.getParameter( "dateN" );
        String club = request.getParameter( "club" );

        //Ajoute à la liste des membres
        listeMembre.ajouteMembre (new Membre (nom, prenom, dateNaissance, club));

        response.sendRedirect("/membre");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clubs",listeClub.recupereClubs());
        request.getRequestDispatcher("/vues/membreAdd.jsp").forward(request,response);
    }

}
