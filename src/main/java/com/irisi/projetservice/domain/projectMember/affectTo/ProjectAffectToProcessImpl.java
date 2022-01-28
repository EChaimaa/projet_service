package com.irisi.projetservice.domain.projectMember.affectTo;

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
        String matricule = abstractProcessInput.getProjetMember().getEmploye().getMatricule();
        String reference = abstractProcessInput.getProjetMember().getProjet().getReference();

        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getProjetMember().getEmploye().getMatricule());
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getProjetMember().getProjet().getReference());
        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(reference, matricule);

        if (projetMember != null && projetMember.getId() != null) {
            result.addErrorMessage("projet.affectTo.projetMember_already_exists");
        }

        if (employe == null) {
            result.addErrorMessage("projet.affectTo.employe_not_found");
        }

        if (projet == null) {
            result.addErrorMessage("projet.affectTo.projet_not_found");
        }
    }

    @Override
    public void run(ProjectAffectToInput abstractProcessInput, Result result) {
        EmployePojo employe = employeInfra.findByMatricule(abstractProcessInput.getProjetMember().getEmploye().getMatricule());
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getProjetMember().getProjet().getReference());

        ProjetMemberPojo projetMember = projetMemberInfra.findByProjetAndEmploye(projet.getReference(), employe.getMatricule());

        projetMember.setEmploye(employe);
        projetMember.setProjet(projet);
        projetMember.setNbrHeures(0);

        projetMemberInfra.save(projetMember);
        result.addInfoMessage("projet.affectTo.projetMember_created");
    }
}
