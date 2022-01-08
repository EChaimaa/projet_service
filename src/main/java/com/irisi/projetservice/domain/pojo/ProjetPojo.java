package com.irisi.projetservice.domain.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjetPojo {
    private Long id;
    private String reference;
    private ClientPojo client;
    private List<ProjetMemberPojo> projetMembers;

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

    public ClientPojo getClient() {
        return client;
    }

    public void setClient(ClientPojo client) {
        this.client = client;
    }

    public List<ProjetMemberPojo> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberPojo> projetMembers) {
        this.projetMembers = projetMembers;
    }
}
