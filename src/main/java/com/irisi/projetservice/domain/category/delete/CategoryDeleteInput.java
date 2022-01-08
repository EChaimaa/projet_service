package com.irisi.projetservice.domain.category.delete;

import com.irisi.projetservice.domain.core.AbstractProcessInput;

public class CategoryDeleteInput extends AbstractProcessInput {
    String libelle;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
