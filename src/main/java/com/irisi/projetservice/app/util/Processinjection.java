package com.irisi.projetservice.app.util;

import com.irisi.projetservice.domain.category.create.CategoryCreateProcess;
import com.irisi.projetservice.domain.category.create.CategoryCreateProcessImpl;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteProcess;
import com.irisi.projetservice.domain.category.delete.CategoryDeleteProcessImpl;
import com.irisi.projetservice.domain.client.create.ClientCreateProcess;
import com.irisi.projetservice.domain.client.create.ClientCreateProcessImpl;
import com.irisi.projetservice.domain.client.delete.ClientDeleteProcess;
import com.irisi.projetservice.domain.client.delete.ClientDeleteProcessImpl;
import com.irisi.projetservice.domain.employe.create.EmployeCreateProcess;
import com.irisi.projetservice.domain.employe.create.EmployeCreateProcessImpl;
import com.irisi.projetservice.domain.employe.delete.EmployeDeleteProcess;
import com.irisi.projetservice.domain.employe.delete.EmployeDeleteProcessImpl;
import com.irisi.projetservice.domain.projectMember.update.ProjectMemberUpdateProcess;
import com.irisi.projetservice.domain.projectMember.update.ProjectMemberUpdateProcessImpl;
import com.irisi.projetservice.domain.projet.affect.ProjectAffectToProcess;
import com.irisi.projetservice.domain.projet.affect.ProjectAffectToProcessImpl;
import com.irisi.projetservice.domain.projet.create.ProjectCreateProcess;
import com.irisi.projetservice.domain.projet.create.ProjectCreateProcessImpl;
import com.irisi.projetservice.domain.projet.delete.ProjectDeleteProcess;
import com.irisi.projetservice.domain.projet.delete.ProjectDeleteProcessImpl;
import com.irisi.projetservice.infra.facade.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {
    //Project
    @Bean
    public ProjectCreateProcess projectCreateProcess(ClientInfra clientInfra, ProjetInfra projetInfra) {
        return new ProjectCreateProcessImpl(clientInfra,projetInfra);
    }

    @Bean
    public ProjectDeleteProcess projectDeleteProcess(ProjetInfra projetInfra){
        return new ProjectDeleteProcessImpl(projetInfra);
    }

    @Bean
    public ProjectAffectToProcess projectAffectToProcess(EmployeInfra employeInfra, ProjetInfra projetInfra, ProjetMemberInfra projetMemberInfra){
        return new ProjectAffectToProcessImpl(employeInfra, projetInfra, projetMemberInfra);
    }

    //Employe
    @Bean
    public EmployeCreateProcess employeCreateProcess(CategorieInfra categorieInfra, EmployeInfra employeInfra) {
        return new EmployeCreateProcessImpl(categorieInfra, employeInfra);
    }

    @Bean
    public EmployeDeleteProcess employeDeleteProcess(EmployeInfra employeInfra){
        return new EmployeDeleteProcessImpl(employeInfra);
    }

    //Categorie
    @Bean
    public CategoryCreateProcess categoryCreateProcess(CategorieInfra categorieInfra) {
        return new CategoryCreateProcessImpl(categorieInfra);
    }

    @Bean
    public CategoryDeleteProcess categoryDeleteProcess(CategorieInfra categorieInfra){
        return new CategoryDeleteProcessImpl(categorieInfra);
    }

    //Client
    @Bean
    public ClientCreateProcess clientCreateProcess(ClientInfra clientInfra) {
        return new ClientCreateProcessImpl(clientInfra);
    }

    @Bean
    public ClientDeleteProcess clientDeleteProcess(ClientInfra clientInfra){
        return new ClientDeleteProcessImpl(clientInfra);
    }

    //ProjetMember
    @Bean
    public ProjectMemberUpdateProcess projectMemberUpdateProcess(ProjetDetailInfra projetDetailInfra, ProjetMemberInfra projetMemberInfra) {
        return new ProjectMemberUpdateProcessImpl(projetDetailInfra, projetMemberInfra);
    }

}

