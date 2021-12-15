package com.EasyHome.taskmanager.web.api.rest.products;

import com.EasyHome.taskmanager.commons.constants.IEndpointTaskApi;
import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ImanagerProductApi {

    @PutMapping(IEndpointTaskApi.CREATE_PRODUCT)
    ResponseEntity<GenericResponseDTO> createProduct(@RequestBody ProductDTO productDTO);

    @GetMapping(IEndpointTaskApi.GET_PRODUCTS)
    ResponseEntity<GenericResponseDTO> getProducts();

    @PutMapping(IEndpointTaskApi.UPDATE_PRODUCT_CODE_PRODUCT)
    ResponseEntity<GenericResponseDTO> updateProduct(@RequestBody ProductDTO productDTO);

    @DeleteMapping(IEndpointTaskApi.DELETE_PRODUCT_CODE_PRODUCT)
    ResponseEntity<GenericResponseDTO> deleteProduct(@PathVariable String idTask);
}
