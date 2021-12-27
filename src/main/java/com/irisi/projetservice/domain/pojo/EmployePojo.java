package com.irisi.projetservice.domain.pojo;

public class EmployePojo {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private CategoriePojo categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public CategoriePojo getCategorie() {
        return categorie;
    }

    public void setCategorie(CategoriePojo categorie) {
        this.categorie = categorie;
    }
}