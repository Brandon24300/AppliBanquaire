package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.entity.CompteEpargne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteEpargneRepository extends CrudRepository<CompteEpargne, Integer> {

}
