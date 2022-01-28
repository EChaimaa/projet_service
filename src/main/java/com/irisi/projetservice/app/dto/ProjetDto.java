package com.irisi.projetservice.app.dto;

import java.util.Date;
import java.util.List;

public class ProjetDto {
    private Long id;
    private String reference;
    private String name;
    private Date beginTime;
    private Date endTime;
    private ClientDto client;
    private List<ProjetMemberDto> projetMembers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<ProjetMemberDto> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberDto> projetMembers) {
        this.projetMembers = projetMembers;
    }

    @Override
    public String toString() {
        return "ProjetDto{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", clientDto=" + client +
                ", projetMembersDtos=" + projetMembers +
                '}';
    }
}
