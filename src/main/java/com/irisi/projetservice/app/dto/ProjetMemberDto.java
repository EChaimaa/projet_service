package com.irisi.projetservice.app.dto;

import java.util.List;

public class ProjetMemberDto {
    private Long id;
    private EmployeDto employe;
    private ProjetDto projet;
    private long nbrHeures;
    private List<ProjetDetailDto> workDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeDto getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDto employe) {
        this.employe = employe;
    }

    public ProjetDto getProjet() {
        return projet;
    }

    public void setProjet(ProjetDto projet) {
        this.projet = projet;
    }

    public long getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(long nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public List<ProjetDetailDto> getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(List<ProjetDetailDto> workDetails) {
        this.workDetails = workDetails;
    }
}
