package com.EasyHome.taskmanager.web.api.rest.clients.impl;


import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;
import com.EasyHome.taskmanager.commons.constants.IEndpointUserApi;
import com.EasyHome.taskmanager.commons.constants.ResponseMassage;
import com.EasyHome.taskmanager.services.clients.IClientServices;
import com.EasyHome.taskmanager.web.api.rest.clients.IClientApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(IEndpointUserApi.BASE_URL)
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Log4j2
public class ClientApiImpl implements IClientApi {

    private final IClientServices iClientServices;

    public ClientApiImpl(IClientServices iClientServices) {
        this.iClientServices = iClientServices;
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PostMapping(IEndpointUserApi.CREATE_CLIENT)
    @ApiOperation(value = "guardar un usuario con sus datos", notes = "metodo para guardar un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.CREATE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.CREATE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> createUser(ClientDTO clientDTO) {
        return iClientServices.createClient(clientDTO);
    }


    @Override
    @GetMapping(IEndpointUserApi.GET_CLIENTS)
    @ApiOperation(value = "no resive parametros", notes = "metodo para obtener todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> getUsers() {
        return iClientServices.getClients();
    }


    @Override
    @GetMapping(IEndpointUserApi.GET_CLIENT_INFO)
    @ApiOperation(value = "resive el id del cliente", notes = "metodo para obtener info de los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> getUser(String idClient) {
        return iClientServices.getClient(idClient);
    }


    @Override
    @PostMapping(IEndpointUserApi.UPDATE_CLIENT)
    @ApiOperation(value = "resive el id del cliente", notes = "metodo para actualizar info de los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> updateUser(ClientDTO clientDTO) {
        return iClientServices.updateClient(clientDTO);
    }


    @Override
    @PostMapping(IEndpointUserApi.DELETE_CLIENT)
    @ApiOperation(value = "resive el id del cliente", notes = "metodo para eliminar clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> deleteUser(ClientDTO clientDTO) {
        return iClientServices.deleteClient(clientDTO);
    }


}

