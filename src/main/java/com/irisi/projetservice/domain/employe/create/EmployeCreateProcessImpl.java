package com.irisi.projetservice.domain.employe.create;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import com.irisi.projetservice.infra.facade.EmployeInfra;

public class EmployeCreateProcessImpl extends AbstractProcessImpl<EmployeCreateInput> implements EmployeCreateProcess {
    CategorieInfra categorieInfra;
    EmployeInfra employeInfra;

    public EmployeCreateProcessImpl(CategorieInfra categorieInfra, EmployeInfra employeInfra) {
        this.categorieInfra = categorieInfra;
        this.employeInfra = employeInfra;
    }

    @Override
    public void validate(EmployeCreateInput abstractProcessInput, Result result) {
        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getEmploye().getMatricule());
        CategoriePojo category = categorieInfra.findByLibelle(abstractProcessInput.getLibelleCategorie());

        if (employe != null && employe.getId() != null) {
            result.addErrorMessage("employe.create.employe_already_exists");
        }

        if (category == null) {
            result.addErrorMessage("employe.create.category_not_found");
        }
    }

    @Override
    public void run(EmployeCreateInput abstractProcessInput, Result result) {
        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getEmploye().getMatricule());
        CategoriePojo category = categorieInfra.findByLibelle(abstractProcessInput.getLibelleCategorie());
        employe.setCategorie(category);
        employeInfra.save(employe);
        result.addInfoMessage("employe.create.employe_created");
    }
}
