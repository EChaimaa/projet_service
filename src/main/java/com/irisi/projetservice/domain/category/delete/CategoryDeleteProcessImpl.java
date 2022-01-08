package com.irisi.projetservice.domain.category.delete;

import com.irisi.projetservice.domain.core.AbstractProcessImpl;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.domain.pojo.ClientPojo;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import com.irisi.projetservice.infra.facade.ClientInfra;

public class CategoryDeleteProcessImpl extends AbstractProcessImpl<CategoryDeleteInput> implements CategoryDeleteProcess {
    CategorieInfra categorieInfra;

    public CategoryDeleteProcessImpl(CategorieInfra categorieInfra) {
        this.categorieInfra = categorieInfra;
    }

    @Override
    public void validate(CategoryDeleteInput abstractProcessInput, Result result) {
        String libelle = abstractProcessInput.getLibelle();
        CategoriePojo categoriePojo = categorieInfra.findByLibelle(libelle);
        if (categoriePojo == null || categoriePojo.getId() == null) {
            result.addErrorMessage(categorieInfra.getMessage("category.delete.not_found"));
        }
    }

    @Override
    public void run(CategoryDeleteInput abstractProcessInput, Result result) {
        String reference = abstractProcessInput.getLibelle();
        categorieInfra.deleteByLibelle(reference);
        result.addInfoMessage(categorieInfra.getMessage("category.delete.deleted_success"));
        result.setStatus(1);
    }
}
