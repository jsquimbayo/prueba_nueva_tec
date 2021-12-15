package com.EasyHome.taskmanager.commons.converter.impl;

import com.EasyHome.taskmanager.commons.converter.IClientConverter;
import com.EasyHome.taskmanager.commons.domains.entity.ClientEntity;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;
import com.EasyHome.taskmanager.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ClientConverter implements IClientConverter {


    /**
     * Author jsQuimbayo
     * metodo que convierte de userdto a userEntity
     * *param taskDTO
     **/
    @Override
    public ClientEntity clientDtoToClientEntity(ClientDTO clientDTO){
        ClientEntity clientEntity = new ClientEntity();
        try {
            clientEntity = HelperMapper.modelMapper().map(clientDTO, ClientEntity.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return clientEntity;
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a taskEntity
     * *param taskDTO
     **/
    @Override
    public ClientDTO clientEntityToClientDto(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        try {
            clientDTO = HelperMapper.modelMapper().map(clientEntity, ClientDTO.class);
            clientDTO.setIdClient(clientEntity.getIdClient().toString());
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return clientDTO;
        }
    }
}
