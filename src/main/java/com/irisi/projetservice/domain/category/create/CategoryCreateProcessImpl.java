package com.irisi.projetservice.domain.category.create;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.facade.CategorieInfra;

public class CategoryCreateProcessImpl extends AbstractProcessImpl<CategoryCreateInput> implements CategoryCreateProcess {
    CategorieInfra categorieInfra;

    public CategoryCreateProcessImpl(CategorieInfra categorieInfra) {
        this.categorieInfra = categorieInfra;
    }

    @Override
    public void validate(CategoryCreateInput abstractProcessInput, Result result) {
        CategoriePojo category = categorieInfra.findByLibelle(abstractProcessInput.getCategoriePojo().getLibelle());

        if (category != null && category.getId() != null) {
            result.addErrorMessage("category.create.category_already_exists");
        }
    }

    @Override
    public void run(CategoryCreateInput abstractProcessInput, Result result) {
        CategoriePojo category = categorieInfra.findByLibelle(abstractProcessInput.getCategoriePojo().getLibelle());
        categorieInfra.save(category);
        result.addInfoMessage("category.create.category_created");
    }
}
