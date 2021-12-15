package com.EasyHome.taskmanager.commons.repository;


import com.EasyHome.taskmanager.commons.domains.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

    @Override
    List<ClientEntity> findAll();

    Optional<ClientEntity> findByIdClient(Integer idClient);
}
