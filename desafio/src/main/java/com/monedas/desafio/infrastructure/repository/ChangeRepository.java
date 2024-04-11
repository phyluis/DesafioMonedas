package com.monedas.desafio.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.monedas.desafio.domain.entity.EntityChange;

public interface ChangeRepository extends CrudRepository<EntityChange, Long>  {

}
