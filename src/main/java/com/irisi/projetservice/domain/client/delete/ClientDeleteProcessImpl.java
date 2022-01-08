package com.irisi.projetservice.domain.client.delete;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.facade.ClientInfra;

public class ClientDeleteProcessImpl extends AbstractProcessImpl<ClientDeleteInput> implements ClientDeleteProcess {
    ClientInfra clientInfra;

    public ClientDeleteProcessImpl(ClientInfra clientInfra) {
        this.clientInfra = clientInfra;
    }

    @Override
    public void validate(ClientDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        ClientPojo clientPojo = clientInfra.findByReference(reference);
        if (clientPojo == null || clientPojo.getId() == null) {
            result.addErrorMessage(clientInfra.getMessage("client.delete.not_found"));
        }
    }

    @Override
    public void run(ClientDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getReference();
        clientInfra.deleteByReference(reference);
        result.addInfoMessage(clientInfra.getMessage("client.delete.deleted_success"));
        result.setStatus(1);
    }
}
