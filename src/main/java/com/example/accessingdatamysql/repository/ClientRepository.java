package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {


}
