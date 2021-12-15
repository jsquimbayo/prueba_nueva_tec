package com.EasyHome.taskmanager.commons.domains.generic;

import lombok.*;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientDTO {

    private String idClient;
    private String nameCLient;
    private String lastNameClient;
    private String identClient;
    private String mailCLient;
    private String numCompras;
}
