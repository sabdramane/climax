package com.agitex.climax.web.model;


public class Client {
    private String nom;
    private String prenom;
    private int age;
    private String profession;
    private int salaire;

    public Client()
    {

    }
    public Client(String nom,String prenom,int age, String profession,int salaire)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.profession = profession;
        this.salaire = salaire;
    }


    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getAge() {
        return age;
    }
    public String getProfession() {
        return profession;
    }
    public int getSalaire() {
        return salaire;
    }

   
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "{"+
        "\"nom\":\""+ nom +"\""+
        ", \"prenom\":\"" + prenom +"\""+
        ",\"age\":"+age+
        ",\"profession\":\""+profession+"\""+
        ",\"salaire\":"+salaire+
        "}";
    }

    public String getLigne2() {
        return 
        nom +","+
        prenom +","+
        age+","+
        profession+","+
        salaire;
    }
    
}
