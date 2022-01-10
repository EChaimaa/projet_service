package com.irisi.projetservice.app.dto;

import java.util.List;

public class ProjetMemberDto {
    private Long id;
    private EmployeDto employeDto;
    private ProjetDto projetDto;
    private long nbrHeures;
    private List<ProjetDetailDto> workDetailsDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeDto getEmployeDto() {
        return employeDto;
    }

    public void setEmployeDto(EmployeDto employeDto) {
        this.employeDto = employeDto;
    }

    public ProjetDto getProjetDto() {
        return projetDto;
    }

    public void setProjetDto(ProjetDto projetDto) {
        this.projetDto = projetDto;
    }

    public long getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(long nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public List<ProjetDetailDto> getWorkDetailsDtos() {
        return workDetailsDtos;
    }

    public void setWorkDetailsDtos(List<ProjetDetailDto> workDetailsDtos) {
        this.workDetailsDtos = workDetailsDtos;
    }
}
