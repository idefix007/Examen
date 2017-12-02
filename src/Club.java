import java.util.*;
public class Club {

    private String nom;
    private String type;
    private int id;

    // Constructeurs

    public Club(int id, String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.id=id;
    }

    // Getters


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    // Setters

    public void setId (int id){
        this.id=id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }
    String tableauClub[] = {"Volley-ball", "Rugby", "Hand-ball" , "Basket-ball"};

}

