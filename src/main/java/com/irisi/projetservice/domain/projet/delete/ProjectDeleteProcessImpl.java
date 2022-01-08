package com.irisi.projetservice.domain.projet.delete;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.ProjetInfra;

public class ProjectDeleteProcessImpl extends AbstractProcessImpl<ProjectDeleteInput> implements ProjectDeleteProcess {
    ProjetInfra projetInfra;

    public ProjectDeleteProcessImpl(ProjetInfra projetInfra) {
        this.projetInfra = projetInfra;
    }

    @Override
    public void validate(ProjectDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        ProjetPojo projetPojo = projetInfra.findByReference(reference);
        if (projetPojo == null || projetPojo.getId() == null) {
            result.addErrorMessage(projetInfra.getMessage("projet.delete.not_found"));
        }
    }

    @Override
    public void run(ProjectDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        projetInfra.deleteByReference(reference);
        result.addInfoMessage(projetInfra.getMessage("projet.delete.deleted_success"));
        result.setStatus(1);
    }
}
