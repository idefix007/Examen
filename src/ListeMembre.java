import javax.print.DocFlavor;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListeMembre{


    private static List<Membre> membres = new ArrayList<>();
    {

    }

    public void add(Membre membre) {
        membres.add(membre);
    }
    public List<Membre> recupereMembres() {
        BaseDeDonnees.recupereMembre();
        return membres;
    }
}




