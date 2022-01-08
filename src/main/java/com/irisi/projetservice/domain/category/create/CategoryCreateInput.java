package com.irisi.projetservice.domain.category.create;

import com.irisi.projetservice.domain.core.AbstractProcessInput;
import com.irisi.projetservice.domain.pojo.CategoriePojo;

public class CategoryCreateInput extends AbstractProcessInput {
    private CategoriePojo categoriePojo;

    public CategoriePojo getCategoriePojo() {
        return categoriePojo;
    }

    public void setCategoriePojo(CategoriePojo categoriePojo) {
        this.categoriePojo = categoriePojo;
    }
}
