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
public class ProjetMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private EmployeEntity employe;
    @ManyToOne
    private ProjetEntity projet;
    private int nbrHeures;
    @OneToMany
    private List<projetDetailEntity> workDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeEntity getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeEntity employe) {
        this.employe = employe;
    }

    public ProjetEntity getProjet() {
        return projet;
    }

    public void setProjet(ProjetEntity projet) {
        this.projet = projet;
    }

    public int getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(int nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public List<projetDetailEntity> getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(List<projetDetailEntity> workDetails) {
        this.workDetails = workDetails;
    }
}
