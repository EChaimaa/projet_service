package com.irisi.projetservice.domain.employe.delete;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class EmployeDeleteInput extends AbstractProcessInput {
    String matricule;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
