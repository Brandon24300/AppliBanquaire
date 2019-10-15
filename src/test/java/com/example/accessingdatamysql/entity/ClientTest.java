package com.example.accessingdatamysql.entity;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;
    CompteCourant compteCourant;


    @BeforeEach
    void setUp() {
        client = new Client("Albert","aaaa");
        compteCourant = new CompteCourant("Compte",400.0,50);
        CompteCourant c2 = new CompteCourant("a",200,20);

        client.addCompteCourant(compteCourant);
        client.addCompteCourant(c2);

    }

    @org.junit.jupiter.api.Test
     void calcul_Avoir_Plusieurs_Compte(){
        client.calculAvoir();
        assertEquals(client.calculAvoir(),600);
    }

    @org.junit.jupiter.api.Test
    void calcul_Avoir_Sans_Compte(){
        Client cli = new Client("aaa","bbb");
        assertEquals(cli.calculAvoir(),0);
    }

    @org.junit.jupiter.api.Test
    void calcul_Avoir_Un_Compte_Epargne(){
        Client cli = new Client("aaa","bbb");
        CompteEpargne c2 = new CompteEpargne("a",200,20);
        cli.addCompteEpargne(c2);

        assertEquals(cli.calculAvoir(),200);
    }


}