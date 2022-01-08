package com.irisi.projetservice.domain.projet.create;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

public class ProjectCreateInput extends AbstractProcessInput {
    private String referenceClient;
    private ProjetPojo projetPojo;

    public String getReferenceClient() {
        return referenceClient;
    }

    public void setReferenceClient(String referenceClient) {
        this.referenceClient = referenceClient;
    }

    public ProjetPojo getProjetPojo() {
        return projetPojo;
    }

    public void setProjetPojo(ProjetPojo projetPojo) {
        this.projetPojo = projetPojo;
    }
}
