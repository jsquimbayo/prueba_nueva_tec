package com.EasyHome.taskmanager.services.products.impl;

import com.EasyHome.taskmanager.commons.domains.entity.ProductEntity;
import com.EasyHome.taskmanager.commons.domains.entity.ClientEntity;
import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;
import com.EasyHome.taskmanager.commons.repository.ProductRepository;
import com.EasyHome.taskmanager.commons.repository.ClientRepository;
import com.EasyHome.taskmanager.services.products.IProductServices;
import com.EasyHome.taskmanager.commons.converter.IProductConverter;
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
public class ProductServicesImpl implements IProductServices {


    @Autowired
    private IProductConverter IProductConverter;

    @Autowired
    private ProductRepository productRepository;



    /**
     * Author jsQuimbayo
     * metodo que crea una nueva tarea
     * *param productDTO
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        try{
            productEntity = IProductConverter.productDtoToProductEntity(productDTO);
            productRepository.save(productEntity);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("tarea creada")
                    .objectResponse(productDTO)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);

        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error creando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }

    }


    /**
     * Author jsQuimbayo
     * metodo que actualiza una  tarea
     * *param productDTO, codeTask
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        Optional<ProductEntity> oldTask;
        try{
            oldTask = productRepository.findByCodeProduct(productDTO.getCodeProduct());
            if (oldTask.isPresent()){
                productEntity = IProductConverter.productDtoToProductEntity(productDTO);
                productEntity.setIdProduct(oldTask.get().getIdProduct());
                productRepository.save(productEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea actualizada")
                        .objectResponse(productDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("no se encontro ninguna tarea para actualizar")
                        .objectResponse(null)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la creacion de la tarea " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error actualizando tarea:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que obtiene todas las tareas asociadas a un usuario
     * *param idUser
     **/
    @Override
    public ResponseEntity<GenericResponseDTO> getProducts() {
        List<ProductEntity> tasksEntity = new ArrayList<>();
        try{
            tasksEntity = productRepository.findAll();
            if(!tasksEntity.isEmpty()){
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tareas encontradas")
                        .objectResponse(tasksEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("No se encontraron Tareas")
                        .objectResponse(tasksEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }
        }catch (Exception e){
            log.error("Algo fallo en la actualizacion de la fecha " + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error consultando la persona:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que elimina una  tarea
     * *param codeTask
     **/
    @Override
    @Modifying
    public ResponseEntity<GenericResponseDTO> deleteProduct(String codProduct) {
        Optional<ProductEntity> oldTask;
        try{
            oldTask = productRepository.findByCodeProduct(codProduct);
            if(oldTask.isPresent()){
                productRepository.delete(oldTask.get());
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("tarea eliminada")
                        .objectResponse(codProduct)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message("No se pudo eliminar la tarea")
                        .objectResponse(codProduct)
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
