package com.irisi.projetservice.domain.projet.affect;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class ProjectAffectToInput extends AbstractProcessInput {
    private String matriculeEmploye;
    private String referenceProjet;

    public String getMatriculeEmploye() {
        return matriculeEmploye;
    }

    public void setMatriculeEmploye(String matriculeEmploye) {
        this.matriculeEmploye = matriculeEmploye;
    }

    public String getReferenceProjet() {
        return referenceProjet;
    }

    public void setReferenceProjet(String referenceProjet) {
        this.referenceProjet = referenceProjet;
    }
}
