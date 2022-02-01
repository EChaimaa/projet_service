package com.irisi.projetservice.domain.projectMember.delete;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class ProjetMemberDeleteInput extends AbstractProcessInput {
    String reference;
    String matricule;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
