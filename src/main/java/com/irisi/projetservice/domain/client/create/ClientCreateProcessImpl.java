package com.irisi.projetservice.domain.client.create;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;
import com.irisi.projetservice.infra.facade.ClientInfra;
import com.irisi.projetservice.infra.facade.ProjetInfra;

public class ClientCreateProcessImpl extends AbstractProcessImpl<ClientCreateInput> implements ClientCreateProcess {
    ClientInfra clientInfra;

    public ClientCreateProcessImpl(ClientInfra clientInfra) {
        this.clientInfra = clientInfra;
    }

    @Override
    public void validate(ClientCreateInput abstractProcessInput, Result result) {
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getClientPojo().getReference());

        if (client != null && client.getId() != null) {
            result.addErrorMessage("client.create.client_already_exists");
        }
    }

    @Override
    public void run(ClientCreateInput abstractProcessInput, Result result) {
        ClientPojo client = clientInfra.findByReference(abstractProcessInput.getClientPojo().getReference());
        clientInfra.save(client);
        result.addInfoMessage("client.create.client_created");
    }
}
