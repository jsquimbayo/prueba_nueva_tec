package com.EasyHome.taskmanager.commons.repository;


import com.EasyHome.taskmanager.commons.domains.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Override
    List<ProductEntity> findAll();

    Optional<ProductEntity> findByCodeProduct(String codeProduct);



}
