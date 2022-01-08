package com.irisi.projetservice.domain.projectMember.update;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.ClientInfra;
import com.irisi.projetservice.infra.facade.ProjetInfra;
import com.irisi.projetservice.infra.facade.ProjetMemberInfra;
import com.irisi.projetservice.infra.facade.projetDetailInfra;

public class ProjectMemberUpdateProcessImpl extends AbstractProcessImpl<ProjectMemberUpdateInput> implements ProjectMemberUpdateProcess {
    projetDetailInfra projetDetailInfra;
    ProjetMemberInfra projetMemberInfra;

    @Override
    public void validate(ProjectMemberUpdateInput abstractProcessInput, Result result) {

        if (projet != null && projet.getId() != null) {
            result.addErrorMessage("projet.create.projet_already_exists");
        }

        if (client == null) {
            result.addErrorMessage("projet.create.client_not_found");
        }
    }z

    @Override
    public void run(ProjectMemberUpdateInput abstractProcessInput, Result result) {
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getProjetPojo().getReference());
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getReferenceClient());
        projet.setClient(client);
        projetInfra.save(projet);
        result.addInfoMessage("projet.create.projet_created");
    }
}
