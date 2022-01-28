package com.irisi.projetservice.domain.projet.create;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

public class ProjectCreateInput extends AbstractProcessInput {
    private ProjetPojo projetPojo;

    public ProjetPojo getProjetPojo() {
        return projetPojo;
    }

    public void setProjetPojo(ProjetPojo projetPojo) {
        this.projetPojo = projetPojo;
    }
}
