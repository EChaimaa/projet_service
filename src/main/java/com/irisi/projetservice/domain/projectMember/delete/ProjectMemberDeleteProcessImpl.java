package com.irisi.projetservice.domain.projectMember.delete;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;

public class ProjectMemberDeleteProcessImpl extends AbstractProcessImpl<ProjetMemberDeleteInput> implements ProjetMemberDeleteProcess {
    ProjetMemberInfra projetMemberInfra;

    public ProjectMemberDeleteProcessImpl(ProjetMemberInfra projetMemberInfra) {
        this.projetMemberInfra = projetMemberInfra;
    }

    @Override
    public void validate(ProjetMemberDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        String matricule = abstractProcessInput.getMatricule();
        ProjetMemberPojo projetMemberPojo = projetMemberInfra.findByProjetAndEmploye(reference, matricule);
        if (projetMemberPojo == null || projetMemberPojo.getId() == null) {
            result.addErrorMessage(projetMemberInfra.getMessage("projetMember.delete.not_found"));
        }
    }

    @Override
    public void run(ProjetMemberDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        String matricule = abstractProcessInput.getMatricule();
        projetMemberInfra.deleteByProjectAndEmploye(reference, matricule);
        result.addInfoMessage(projetMemberInfra.getMessage("projetMember.delete.deleted_success"));
        result.setStatus(1);
    }
}
