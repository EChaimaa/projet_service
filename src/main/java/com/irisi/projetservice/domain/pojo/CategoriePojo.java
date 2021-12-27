package com.irisi.projetservice.domain.pojo;

public class CategoriePojo {
    private Long id;
    private String libelle;
    private int salaireParJour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getSalaireParJour() {
        return salaireParJour;
    }

    public void setSalaireParJour(int salaireParJour) {
        this.salaireParJour = salaireParJour;
    }
}
