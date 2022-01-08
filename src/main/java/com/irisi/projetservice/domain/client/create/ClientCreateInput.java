package com.irisi.projetservice.domain.client.create;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.domain.pojo.ProjetPojo;

public class ClientCreateInput extends AbstractProcessInput {
    private ClientPojo clientPojo;

    public ClientPojo getClientPojo() {
        return clientPojo;
    }

    public void setClientPojo(ClientPojo clientPojo) {
        this.clientPojo = clientPojo;
    }
}
