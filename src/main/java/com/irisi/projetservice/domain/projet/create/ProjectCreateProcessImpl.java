package com.irisi.projetservice.domain.projet.create;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.EmployePojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import com.irisi.projetservice.infra.facade.ClientInfra;
import com.irisi.projetservice.infra.facade.EmployeInfra;
import com.irisi.projetservice.infra.facade.ProjetInfra;

public class ProjectCreateProcessImpl extends AbstractProcessImpl<ProjectCreateInput> implements ProjectCreateProcess {
    ClientInfra clientInfra;
    ProjetInfra projetInfra;

    public ProjectCreateProcessImpl(ClientInfra clientInfra, ProjetInfra projetInfra) {
        this.clientInfra = clientInfra;
        this.projetInfra = projetInfra;
    }

    @Override
    public void validate(ProjectCreateInput abstractProcessInput, Result result) {
        ProjetPojo projet =projetInfra.findByReference(abstractProcessInput.getProjetPojo().getReference());
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getReferenceClient());

        if (projet != null && projet.getId() != null) {
            result.addErrorMessage("projet.create.projet_already_exists");
        }

        if (client == null) {
            result.addErrorMessage("projet.create.client_not_found");
        }
    }

    @Override
    public void run(ProjectCreateInput abstractProcessInput, Result result) {
        ProjetPojo projet = projetInfra.findByReference(abstractProcessInput.getProjetPojo().getReference());
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getReferenceClient());
        projet.setClient(client);
        projetInfra.save(projet);
        result.addInfoMessage("projet.create.projet_created");
    }
}
