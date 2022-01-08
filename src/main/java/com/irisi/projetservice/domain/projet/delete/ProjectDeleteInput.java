package com.irisi.projetservice.domain.projet.delete;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class ProjectDeleteInput extends AbstractProcessInput {
    String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
