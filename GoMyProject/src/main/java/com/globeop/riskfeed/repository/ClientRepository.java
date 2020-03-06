package com.globeop.riskfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.globeop.riskfeed.entity.ClientTable;

//@RepositoryRestResource(path ="clients")
public interface ClientRepository extends JpaRepository<ClientTable, Integer> {

}
