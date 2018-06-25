package com.example.gwadaboyz.lokacar.BO;

public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String rue;
    private String ville;
    private String codePostal;
    private String telephone;
    private String mail;

    //construteurs


    public Client()
    {
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.rue = "";
        this.ville = "";
        this.codePostal = "";
        this.telephone = "";
        this.mail = "";
    }

    public Client(int id, String nom, String prenom, String rue, String ville, String codePostal, String telephone, String mail)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.mail = mail;
    }

    //Get et Set
    public int getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getRue()
    {
        return rue;
    }

    public String getVille()
    {
        return ville;
    }

    public String getCodePostal()
    {
        return codePostal;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public String getMail()
    {
        return mail;
    }
}
