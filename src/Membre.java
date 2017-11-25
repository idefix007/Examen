import java.sql.Date;

public class Membre {


    private String nom;
    private String prenom;
    private String dateNaissance;
    private String club;
    private int id;

    // Constructeurs

    public Membre(int id, String nom, String prenom, String dateNaissance, String club) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.club = club;
    }

    // Getteurs


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getClub() {
        return club;
    }

    // Setteurs


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
