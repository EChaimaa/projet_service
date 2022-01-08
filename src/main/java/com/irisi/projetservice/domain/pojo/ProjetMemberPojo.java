package com.irisi.projetservice.domain.pojo;

import java.util.List;

public class ProjetMemberPojo {
    private Long id;
    private EmployePojo employe;
    private ProjetPojo projet;
    private int nbrHeures;
    private List<projetDetailPojo> projetDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployePojo getEmploye() {
        return employe;
    }

    public void setEmploye(EmployePojo employe) {
        this.employe = employe;
    }

    public ProjetPojo getProjet() {
        return projet;
    }

    public void setProjet(ProjetPojo projet) {
        this.projet = projet;
    }

    public int getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(int nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public List<projetDetailPojo> getprojetDetails() {
        return projetDetails;
    }

    public void setprojetDetails(List<projetDetailPojo> projetDetails) {
        this.projetDetails = projetDetails;
    }
}
