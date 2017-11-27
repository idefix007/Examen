import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "ServletClub_supp", urlPatterns = {"/supp-club"})
public class ServletClub_supp extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Force l'UTF8
        request.setCharacterEncoding("UTF-8");

        response.sendRedirect("/club");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            BaseDeDonnees.supprimeClub(request.getParameter("clubs"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/club");
    }

}

