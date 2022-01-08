package com.irisi.projetservice.domain.client.delete;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class ClientDeleteInput extends AbstractProcessInput {
    String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
