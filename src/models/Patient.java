package models;

public class Patient {
    private String nom;
    private String prenom;
    private String telephone;
    private int age;
    private double poids;
    private double taille;
    private String allergies;

    public Patient(String nom, String prenom, String telephone, int age, double poids, double taille, String allergies) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.allergies = allergies;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", age=" + age +
                ", poids=" + poids +
                ", taille=" + taille +
                ", allergies='" + allergies + '\'' +
                '}';
    }
}
