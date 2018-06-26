package com.example.gwadaboyz.lokacar.bo;

import java.util.UUID;

public class Agence {

    private UUID id;
    private String nom;
    private String adresse;
    private String siret;


    public Agence(UUID id, String nom, String adresse, String siret) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.siret = siret;
    }

    public Agence() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
