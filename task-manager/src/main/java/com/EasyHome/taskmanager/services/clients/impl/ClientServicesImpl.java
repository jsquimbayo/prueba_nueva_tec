package com.EasyHome.taskmanager.services.clients.impl;

import com.EasyHome.taskmanager.commons.converter.IClientConverter;
import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.repository.ClientRepository;
import com.EasyHome.taskmanager.commons.domains.entity.ClientEntity;
import com.EasyHome.taskmanager.commons.domains.generic.ClientDTO;
import com.EasyHome.taskmanager.services.clients.IClientServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Log4j2
public class ClientServicesImpl implements IClientServices {

    @Autowired
    private IClientConverter iClientConverter;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> createClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = new ClientEntity();
        try{
            clientEntity = iClientConverter.clientDtoToClientEntity(clientDTO);
            clientRepository.save(clientEntity);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("cliente creado")
                    .objectResponse(clientEntity)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);

        }catch (Exception e){
            log.error("Algo fallo en la creacion del usuario " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando el cliente:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> getClients() {
        List<ClientEntity> clientEntityList = new ArrayList<>();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        try{
            clientEntityList = clientRepository.findAll();
            clientEntityList.forEach(client -> clientDTOS.add(iClientConverter.clientEntityToClientDto(client)));
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("clientes encontrados")
                    .objectResponse(clientDTOS)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Algo fallo en la obtencion de los usuarios " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando el cliente:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> getClient(String idClient) {
        Optional<ClientEntity> clientEntity;
        ClientDTO clientDTO = new ClientDTO();
        try{
            clientEntity = clientRepository.findByIdClient(Integer.parseInt(idClient));
            if(clientEntity.isPresent()){
                clientDTO = iClientConverter.clientEntityToClientDto(clientEntity.get());
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("clientes encontrados")
                        .objectResponse(clientDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("no se encontro ningun cliente con esa caracteristica")
                        .objectResponse(null)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }

        }catch (Exception e){
            log.error("Algo fallo en la obtencion de los usuarios " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando el cliente:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> updateClient(ClientDTO clientDTO) {
         ClientEntity clientEntity = new ClientEntity();
        Optional<ClientEntity> oldCLient;
        try{
            oldCLient = clientRepository.findByIdClient(Integer.parseInt(clientDTO.getIdClient()));
            if (oldCLient.isPresent()){
                clientEntity = iClientConverter.clientDtoToClientEntity(clientDTO);
                clientEntity.setIdClient(oldCLient.get().getIdClient());
                clientRepository.save(clientEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("Cliente actualizada")
                        .objectResponse(clientDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("no se encontro ningun cliente para actualizar")
                        .objectResponse(null)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error actualizando cliente:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> deleteClient(ClientDTO clientDTO) {
        Optional<ClientEntity> oldClient;
        try{
            oldClient = clientRepository.findByIdClient(Integer.parseInt(clientDTO.getIdClient()));
            if(oldClient.isPresent()){
                clientRepository.delete(oldClient.get());
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea eliminada")
                        .objectResponse(oldClient)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("No se pudo eliminar la tarea")
                        .objectResponse(oldClient)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error eliminando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }
}
