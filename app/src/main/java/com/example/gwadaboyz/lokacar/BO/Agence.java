package com.example.gwadaboyz.lokacar.BO;

public class Agence {

    private int id;
    private String nom;
    private String adresse;
    private String siret;


    public Agence(int id, String nom, String adresse, String siret) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.siret = siret;
    }

    public Agence() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", siret='" + siret + '\'' +
                '}';
    }
}
