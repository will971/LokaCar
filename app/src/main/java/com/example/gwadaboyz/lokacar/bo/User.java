package com.example.gwadaboyz.lokacar.bo;

public class User {

    private int id ;
    private String Nom;
    private String prenom;
    private String mdp;
    private Agence agence;
    private String mail;


    public User() {
        super();
    }

    public User(int id, String nom, String prenom, String mdp, Agence agence, String mail) {
        this.id = id;
        Nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.agence = agence;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mdp='" + mdp + '\'' +
                ", agence=" + agence +
                ", mail='" + mail + '\'' +
                '}';
    }
}
