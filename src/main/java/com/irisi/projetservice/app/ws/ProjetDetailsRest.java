package com.irisi.projetservice.app.ws;

import com.irisi.projetservice.app.converter.CategorieMapper;
import com.irisi.projetservice.app.dto.CategorieDto;
import com.irisi.projetservice.domain.category.create.CategoryCreateInput;
import com.irisi.projetservice.domain.category.create.CategoryCreateProcess;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteInput;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteProcess;
import com.irisi.projetservice.domain.core.Result;
import com.irisi.projetservice.domain.pojo.CategoriePojo;
import com.irisi.projetservice.infra.entity.ProjetDetailEntity;
import com.irisi.projetservice.infra.facade.CategorieInfra;
import com.irisi.projetservice.infra.facade.ProjetDetailInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-projet/projets-details")
public class ProjetDetailsRest {
    @Autowired
    ProjetDetailInfra projetDetailInfra;

    @GetMapping("/")
    public List<ProjetDetailEntity> showAll(){
        return projetDetailInfra.findAll();
    }

}
