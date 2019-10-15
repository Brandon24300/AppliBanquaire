package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.AccessingDataMysqlApplication;
import com.example.accessingdatamysql.controller.CompteController;
import com.example.accessingdatamysql.repository.CompteCourantRepository;
import com.example.accessingdatamysql.repository.CompteEpargneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccessingDataMysqlApplication.class)
@ActiveProfiles("test")
class StatMachineTest {

    @Autowired
    CompteEpargneRepository compteEpargneRepository;

    @Autowired
    CompteCourantRepository compteCourantRepository;

    List<Compte> allCompte;

    StatMachine statMachine;


    @BeforeEach
    void setUp() {
        allCompte = new ArrayList<>();
        compteEpargneRepository.save(new CompteEpargne("aa",200,10));
        compteCourantRepository.save(new CompteCourant("aa",200,100));

        compteCourantRepository.findAll().iterator().forEachRemaining(allCompte::add);
        compteEpargneRepository.findAll().iterator().forEachRemaining(allCompte::add);
        statMachine = new StatMachine(allCompte);
    }

    @Test
    void getSolde_Total() {
        assertEquals(200,statMachine.getSolde());
    }
}