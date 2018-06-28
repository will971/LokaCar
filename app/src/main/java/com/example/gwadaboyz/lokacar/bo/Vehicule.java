package com.example.gwadaboyz.lokacar.bo;

public class Vehicule {

    private int id;
    private String marque;
    private String imatriculation;
    private boolean statut;
    private int prix;
    private Agence agence;
    private String modele;


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

    public String getImatriculation() {
        return imatriculation;
    }

    public void setImatriculation(String imatriculation) {
        this.imatriculation = imatriculation;
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

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Vehicule(int id, String marque, String imatriculation, boolean statut,
                    int prix, Agence agence, String modele) {
        this.id = id;
        this.marque = marque;
        this.imatriculation = imatriculation;
        this.statut = statut;
        this.prix = prix;
        this.agence = agence;
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", imatriculation='" + imatriculation + '\'' +
                ", statut=" + statut +
                ", prix=" + prix +
                ", agence=" + agence +
                ", modele='" + modele + '\'' +
                '}';
    }
}
