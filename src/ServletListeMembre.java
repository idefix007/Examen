import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletListeMembre", urlPatterns = {"/membre"})
public class ServletListeMembre extends HttpServlet {
    private ListeMembre listeMembre = new ListeMembre();



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("membres", listeMembre.recupereMembres());
        request.getRequestDispatcher("/vues/listeMembres.jsp").forward(request,response);

    }
}
