package com.EasyHome.taskmanager.services.products;

import com.EasyHome.taskmanager.commons.domains.generic.GenericResponseDTO;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IProductServices {


    ResponseEntity<GenericResponseDTO> createProduct(ProductDTO productDTO);

    ResponseEntity<GenericResponseDTO> updateProduct(ProductDTO productDTO);

    ResponseEntity<GenericResponseDTO> getProducts();

    ResponseEntity<GenericResponseDTO> deleteProduct(String codProduct);



}
