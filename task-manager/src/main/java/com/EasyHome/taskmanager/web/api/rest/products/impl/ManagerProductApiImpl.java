package com.EasyHome.taskmanager.web.api.rest.products.impl;

import com.EasyHome.taskmanager.commons.constants.IEndpointTaskApi;
import com.EasyHome.taskmanager.commons.constants.ResponseMassage;
import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;
import com.EasyHome.taskmanager.services.products.IProductServices;
import com.EasyHome.taskmanager.web.api.rest.products.ImanagerProductApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IEndpointTaskApi.BASE_URL)
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Log4j2
public class ManagerProductApiImpl implements ImanagerProductApi {

    private final IProductServices IProductServices;

    public ManagerProductApiImpl(IProductServices IProductServices) {
        this.IProductServices = IProductServices;
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PostMapping(IEndpointTaskApi.CREATE_PRODUCT)
    @ApiOperation(value = "guardar una tarea de usuario con sus datos", notes = "metodo para guardar una tarea")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = ResponseMassage.CREATE_SUCCESS, response = GenericResponseDTO.class),
        @ApiResponse(code = 400, message = ResponseMassage.CREATE_FAIL, response = String.class),
        @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> createProduct(@RequestBody ProductDTO productDTO){
        return IProductServices.createProduct(productDTO);
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @GetMapping(IEndpointTaskApi.GET_PRODUCTS)
    @ApiOperation(value = "Obtiene todas las tareas asociadas a un usuario", notes = "obtiene una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.GET_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.GET_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> getProducts(){
        return IProductServices.getProducts();
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @PostMapping(IEndpointTaskApi.UPDATE_PRODUCT_CODE_PRODUCT)
    @ApiOperation(value = "actualiza tarea asociada a un usuario por id", notes = "actualiza una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.UPDATE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.UPDATE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> updateProduct(@RequestBody ProductDTO productDTO){
        return IProductServices.updateProduct(productDTO);
    }


    /**
     * Author jsQuimbayo
     **/
    @Override
    @DeleteMapping(IEndpointTaskApi.DELETE_PRODUCT_CODE_PRODUCT)
    @ApiOperation(value = "elimina tarea asociada a un usuario por id", notes = "elimina una tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ResponseMassage.DELETE_SUCCESS, response = GenericResponseDTO.class),
            @ApiResponse(code = 400, message = ResponseMassage.DELETE_FAIL, response = String.class),
            @ApiResponse(code = 500, message = ResponseMassage.INTERNAL_SERVER)})
    public ResponseEntity<GenericResponseDTO> deleteProduct(@PathVariable String codProduct){
        return IProductServices.deleteProduct(codProduct);
    }
}
