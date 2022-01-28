package com.irisi.projetservice.domain.projet.create;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.ClientInfra;
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
        System.out.println("I am here: "+abstractProcessInput.getProjetPojo().getClient().toString());
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getProjetPojo().getClient().getReference());

        if (projet != null && projet.getId() != null) {
            result.addErrorMessage("projet.create.projet_already_exists");
        }
        if(abstractProcessInput.getProjetPojo().getClient().getId() == null){
            if(client != null) result.addErrorMessage("projet.create.client_already_exists");
        }else{
            if(client == null) result.addErrorMessage("projet.create.client_not_found");
        }
    }

    @Override
    public void run(ProjectCreateInput abstractProcessInput, Result result) {
        ProjetPojo projet = abstractProcessInput.getProjetPojo();
        ClientPojo client = null;
        if(abstractProcessInput.getProjetPojo().getClient().getId() == null) {
           client = clientInfra.save(projet.getClient());
        }else{
            client = clientInfra.findByReference(abstractProcessInput.getProjetPojo().getClient().getReference());
        }
        projet.setClient(client);
        ProjetPojo savedProjet = projetInfra.save(projet);
        result.addInfoMessage("projet.create.projet_created");
        result.setOutput(savedProjet);
    }
}
