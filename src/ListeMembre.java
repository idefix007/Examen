import java.util.ArrayList;
import java.util.List;

public class ListeMembre {

    private static List<Membre> membres = new ArrayList<>();


    public void ajouteMembre(Membre m) {
        membres.add(m);
    }


}