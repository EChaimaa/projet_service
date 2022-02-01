package com.irisi.projetservice.domain.employe.create;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.EmployePojo;

public class EmployeCreateInput extends AbstractProcessInput {
    private EmployePojo employe;

    public EmployePojo getEmploye() {
        return employe;
    }

    public void setEmploye(EmployePojo employe) {
        this.employe = employe;
    }
}
