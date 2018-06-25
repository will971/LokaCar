package com.example.gwadaboyz.lokacar.BO;

public class Vehicule {

    private int id;
    private String marque;
    private String imamatriculation;
    private boolean statut;
    private int prix;
    private Agence agence;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImamatriculation() {
        return imamatriculation;
    }

    public void setImamatriculation(String imamatriculation) {
        this.imamatriculation = imamatriculation;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Vehicule() {
    }

    public Vehicule(int id, String marque, String imamatriculation, boolean statut, int prix, Agence agence) {
        this.id = id;
        this.marque = marque;
        this.imamatriculation = imamatriculation;
        this.statut = statut;
        this.prix = prix;
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", imamatriculation='" + imamatriculation + '\'' +
                ", statut=" + statut +
                ", prix=" + prix +
                ", agence=" + agence +
                '}';
    }
}
