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
public class ProjetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @ManyToOne
    private ClientEntity client;
    @ManyToMany
    private List<ProjetMemberEntity> projetMembers;

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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<ProjetMemberEntity> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberEntity> projetMembers) {
        this.projetMembers = projetMembers;
    }
}
