package com.EasyHome.taskmanager.commons.converter.impl;

import com.EasyHome.taskmanager.commons.converter.IProductConverter;
import com.EasyHome.taskmanager.commons.domains.entity.ProductEntity;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;
import com.EasyHome.taskmanager.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class ProductConverter implements IProductConverter {

    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a taskEntity
     * *param productDTO
     **/
    @Override
    public ProductEntity productDtoToProductEntity(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        try {
            productEntity = HelperMapper.modelMapper().map(productDTO, ProductEntity.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return productEntity;
        }
    }


    /**
     * Author jsQuimbayo
     * metodo que convierte de taskdto a productEntity
     * *param taskDTO
     **/
    @Override
    public ProductDTO productEntityToProductDto(ProductEntity productEntity){
        ProductDTO productDTO = new ProductDTO();
        try {
            productDTO = HelperMapper.modelMapper().map(productEntity, ProductDTO.class);
        }catch (Exception e){
            log.info("No se agrego document para generar indice electronico" + e);
        }finally {
            return productDTO;
        }
    }


}
