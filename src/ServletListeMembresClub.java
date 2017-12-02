import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletListeMembresClub", urlPatterns = {"/membre-club"})
public class ServletListeMembresClub extends HttpServlet {

    private ListeMembre listeMembre = new ListeMembre();
    //private ListeMembreClub listeMembreClub = new ListeMembreClub();
    //private ListeClub listeClub = new ListeClub();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //récupération des membres du club
        request.setAttribute("membres", listeMembre.recupereMembres(request.getParameter("clubs")));
        try {
            request.setAttribute("club", BaseDeDonnees.chercheClub(request.getParameter("clubs")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //request.setAttribute("clubs",listeClub.recupereClubs());
        request.getRequestDispatcher("/vues/listeMembresClub.jsp").forward(request,response);
    }
}
