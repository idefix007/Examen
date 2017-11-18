public class Club {

    private String nom;
    private String type;

    // Constructeurs

    public Club(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    // Getters


    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    // Setters


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }
}

