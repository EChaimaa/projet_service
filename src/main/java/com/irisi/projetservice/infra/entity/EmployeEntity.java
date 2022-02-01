package com.irisi.projetservice.infra.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class EmployeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    @ManyToOne
    private CategorieEntity categorie;
    @OneToMany(mappedBy = "employe")
    private List<ProjetMemberEntity> projetMembers;

    public List<ProjetMemberEntity> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberEntity> projetMembers) {
        this.projetMembers = projetMembers;
    }

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

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }
}
