package com.irisi.projetservice.domain.employe.delete;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.infra.facade.EmployeInfra;

public class EmployeDeleteProcessImpl extends AbstractProcessImpl<EmployeDeleteInput> implements EmployeDeleteProcess {
    EmployeInfra employeInfra;

    public EmployeDeleteProcessImpl(EmployeInfra employeInfra) {
        this.employeInfra = employeInfra;
    }

    @Override
    public void validate(EmployeDeleteInput abstractProcessInput, Result result) {
        String matricule = abstractProcessInput.getMatricule();
        EmployePojo employePojo =employeInfra.findByMatricule(matricule);
        if(employePojo == null || employePojo.getId() == null){
            result.addErrorMessage(employeInfra.getMessage("employe.delete.not_found"));
        }
    }

    @Override
    public void run(EmployeDeleteInput abstractProcessInput, Result result) {
        String matricule = abstractProcessInput.getMatricule();
        employeInfra.deleteByMatricule(matricule);
        result.addInfoMessage(employeInfra.getMessage("employe.delete.deleted_success"));
        result.setStatus(1);
    }
}
