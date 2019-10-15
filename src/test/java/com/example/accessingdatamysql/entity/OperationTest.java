package com.example.accessingdatamysql.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    Operation op;
    @BeforeEach
    void setUp() {
        op = new Operation("aaaa",50);
    }

    @Test
    void getCompteCourant_Non_Instancie() {
        assertEquals(null,op.getCompteCourant());
    }

    @Test
    void getCompteEpargne_Non_Instancie() {
        assertEquals(null,op.getCompteEpargne());
    }
}