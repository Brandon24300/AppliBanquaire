package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entity.Compte;
import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.entity.Operation;
import com.example.accessingdatamysql.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Compte courant repository.
 */
@Repository
public interface CompteCourantRepository extends CrudRepository<CompteCourant, Integer> {

    CompteCourant findByNumero(Integer numero);
}
