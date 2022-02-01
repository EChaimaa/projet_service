package com.irisi.projetservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class ProjetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @ManyToOne
    private ClientEntity client;
    @OneToMany(mappedBy = "projet")
    private List<ProjetMemberEntity> projetMembers;

}
