import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListeClub {

    private static List<Club> clubs = new ArrayList<>();
    {

    }

    public void add(Club club) {
        clubs.add(club);
    }

    public void del(Club club){
        clubs.remove(club);
    }

    public List<Club> recupereClubs() {
        clubs.clear();
        BaseDeDonnees.recupereClub();
        return clubs;
    }
}

