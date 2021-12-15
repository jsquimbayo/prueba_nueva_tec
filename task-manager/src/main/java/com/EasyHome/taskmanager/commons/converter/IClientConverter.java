package com.EasyHome.taskmanager.commons.converter;

import com.EasyHome.taskmanager.commons.domains.entity.ClientEntity;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;

public interface IClientConverter {

    ClientEntity clientDtoToClientEntity(ClientDTO clientDTO);

    ClientDTO clientEntityToClientDto(ClientEntity clientEntity);
}
