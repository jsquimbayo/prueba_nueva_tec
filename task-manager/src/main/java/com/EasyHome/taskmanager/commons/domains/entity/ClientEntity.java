package com.EasyHome.taskmanager.commons.domains.entity;

import lombok.*;

import javax.persistence.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "col_clients")
public class ClientEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(name = "name_clent")
    private String nameCLient;

    @Column(name = "last_name_client")
    private String lastNameClient;

    @Column(name = "identification_client")
    private String identClient;

    @Column(name = "mail_client")
    private String mailCLient;

    @Column(name = "no_compras")
    private String numCompras;




}
