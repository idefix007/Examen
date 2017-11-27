import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TCOKB on 25/11/2017.
 */
@WebServlet(name = "ServletListeClub", urlPatterns = {"/club"})
public class ServletListeClub extends HttpServlet {
    private ListeClub listeClub = new ListeClub();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clubs",listeClub.recupereClubs());
        request.getRequestDispatcher("/vues/listeClubs.jsp").forward(request,response);

    }
}
