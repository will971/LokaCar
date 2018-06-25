package com.example.gwadaboyz.lokacar.BO;

public class User {

    private int id ;
    private String Nom;
    private String prenom;
    private String mdp;
    private Agence agence;


    public User() {
        super();
    }

    public User(int id, String nom, String prenom, String mdp, Agence agence) {
        this.id = id;
        Nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.agence = agence;
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
}
