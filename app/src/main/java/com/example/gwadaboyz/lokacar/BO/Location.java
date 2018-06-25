package com.example.gwadaboyz.lokacar.BO;

import java.util.Date;

public class Location {
    private int id;
    private Client client;
    private Vehicule vehicule;
    private Date date_début;
    private Date date_fin;
    private String montant;
    private boolean rendu;


    //constructeurs

    public Location()
    {
    }

    public Location(int id, Client client, Vehicule vehicule, Date date_début, Date date_fin, String montant, boolean rendu) {
        this.id = id;
        this.client = client;
        this.vehicule = vehicule;
        this.date_début = date_début;
        this.date_fin = date_fin;
        this.montant = montant;
        this.rendu = rendu;
    }


    //Get et Set

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public Date getDate_début() {
        return date_début;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getMontant() {
        return montant;
    }

    public boolean isRendu() {
        return rendu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public void setDate_début(Date date_début) {
        this.date_début = date_début;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public void setRendu(boolean rendu) {
        this.rendu = rendu;
    }
}
