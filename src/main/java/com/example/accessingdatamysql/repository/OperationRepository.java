package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.entity.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer> {

    @Query(
            value = "SELECT operation.* from compte_courant " +
                    "JOIN operation " +
                    "ON compte_courant.numero = operation.compte_courant_numero " +
                    "where compte_courant_numero = ?1",
            nativeQuery = true)
    List<Operation> findAllCompteCourantOperation(Integer id);

    @Query(
            value = "SELECT operation.* from compte_epargne " +
                    "JOIN operation " +
                    "ON compte_epargne.numero = operation.compte_epargne_numero " +
                    "where compte_epargne_numero = ?1",
            nativeQuery = true)
    List<Operation> findAllCompteEpargneOperation(Integer id);
}
