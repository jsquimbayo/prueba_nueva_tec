package com.EasyHome.taskmanager.services.clients;

import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface IClientServices {

    ResponseEntity<GenericResponseDTO> createClient(ClientDTO clientDTO);

    ResponseEntity<GenericResponseDTO> getClients();

    ResponseEntity<GenericResponseDTO> getClient(String idClient);

    ResponseEntity<GenericResponseDTO> updateClient(ClientDTO clientDTO);

    ResponseEntity<GenericResponseDTO> deleteClient(ClientDTO clientDTO);
}
