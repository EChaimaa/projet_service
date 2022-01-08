package com.irisi.projetservice.domain.projet.affect;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.domain.pojo.ProjetMemberPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.EmployeInfra;
import com.irisi.projetservice.infra.facade.ProjetInfra;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;

public class ProjectAffectToProcessImpl extends AbstractProcessImpl<ProjectAffectToInput> implements ProjectAffectToProcess {
    EmployeInfra employeInfra;
    ProjetInfra projetInfra;
    ProjetMemberInfra projetMemberInfra;

    public ProjectAffectToProcessImpl(EmployeInfra employeInfra, ProjetInfra projetInfra, ProjetMemberInfra projetMemberInfra) {
        this.employeInfra = employeInfra;
        this.projetInfra = projetInfra;
        this.projetMemberInfra = projetMemberInfra;
    }

    @Override
    public void validate(ProjectAffectToInput abstractProcessInput, Result result) {
        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getMatriculeEmploye());
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getReferenceProjet());

        if(projetMemberInfra.findByProjetAndEmploye(projet.getReference(), employe.getMatricule()) != null){
            result.addErrorMessage("projet.affectTo.projetMember_already_exists");
        }
    }

    @Override
    public void run(ProjectAffectToInput abstractProcessInput, Result result) {
        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getMatriculeEmploye());
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getReferenceProjet());
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(projet.getReference(), employe.getMatricule());
        projetMember.setNbrHeures(0);
        projetMemberInfra.save(projetMember);
        result.addInfoMessage("projet.affectTo.projetMember_created");
    }
}
