package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.CategorieMapper;
import com.irisi.projetservice.app.dto.CategorieDto;
import com.irisi.projetservice.domain.category.create.CategoryCreateInput;
import com.irisi.projetservice.domain.category.create.CategoryCreateProcess;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteInput;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteProcess;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.entity.CategorieEntity;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/categories")
public class CategoryRest {
    @Autowired
    CategorieInfra categorieInfra;
    @Autowired
    CategoryCreateProcess categoryCreateProcess;
    @Autowired
    CategoryDeleteProcess categoryDeleteProcess;

    @PostMapping("/")
    public Result createCategory(@RequestBody CategorieDto categorieDto){
        CategorieMapper categorieMapper = new CategorieMapper();
        CategoriePojo categorie = categorieMapper.toPojo(categorieDto);
        CategoryCreateInput categoryCreateInput = new CategoryCreateInput();
        categoryCreateInput.setCategoriePojo(categorie);
        return categoryCreateProcess.execute(categoryCreateInput);
    }

    @GetMapping("/")
    public List<CategorieEntity> findAll(){
        return categorieInfra.findAll();
    }

    @Transactional
    @DeleteMapping("/{libelle}")
    public Result deleteCategory(@PathVariable String libelle){
        CategoryDeleteInput categoryDeleteInput = new CategoryDeleteInput();
        categoryDeleteInput.setLibelle(libelle);
        return categoryDeleteProcess.execute(categoryDeleteInput);
    }
}
