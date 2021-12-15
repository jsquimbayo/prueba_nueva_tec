package com.EasyHome.taskmanager.commons.converter;

import com.EasyHome.taskmanager.commons.domains.entity.ProductEntity;
import com.EasyHome.taskmanager.commons.domains.generic.ProductDTO;

public interface IProductConverter {
    ProductEntity productDtoToProductEntity(ProductDTO productDTO);

    ProductDTO productEntityToProductDto(ProductEntity productEntity);
}
