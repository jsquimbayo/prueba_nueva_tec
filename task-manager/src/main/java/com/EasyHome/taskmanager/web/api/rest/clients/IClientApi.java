package com.EasyHome.taskmanager.web.api.rest.clients;

import com.EasyHome.taskmanager.commons.constants.IEndpointUserApi;
import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IClientApi {

    @PostMapping(IEndpointUserApi.CREATE_CLIENT)
    ResponseEntity<GenericResponseDTO> createUser(@RequestBody ClientDTO clientDTO);

    @GetMapping(IEndpointUserApi.GET_CLIENTS)
    ResponseEntity<GenericResponseDTO> getUsers();

    @GetMapping(IEndpointUserApi.GET_CLIENT_INFO)
    ResponseEntity<GenericResponseDTO> getUser(@PathVariable String idClient);

    @PostMapping(IEndpointUserApi.UPDATE_CLIENT)
    ResponseEntity<GenericResponseDTO> updateUser(@RequestBody ClientDTO clientDTO);

    @PostMapping(IEndpointUserApi.DELETE_CLIENT )
    ResponseEntity<GenericResponseDTO> deleteUser(@RequestBody ClientDTO clientDTO);
}
