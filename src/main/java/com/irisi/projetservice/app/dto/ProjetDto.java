package com.irisi.projetservice.app.dto;

import java.util.List;

public class ProjetDto {
    private Long id;
    private String reference;
    private ClientDto clientDto;
    private List<ProjetMemberDto> projetMembersDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public List<ProjetMemberDto> getProjetMembersDtos() {
        return projetMembersDtos;
    }

    public void setProjetMembersDtos(List<ProjetMemberDto> projetMembersDtos) {
        this.projetMembersDtos = projetMembersDtos;
    }
}
