package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.entity.CompteEpargne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteEpargneTest {
    CompteEpargne compteEpargne;
    @BeforeEach
    void setUp(){
        compteEpargne = new CompteEpargne("Compte Epargne de riche",5000,50);

    }

    @Test
    void debiter_Montant_Superieur() {
        Assertions.assertThrows(IllegalArgumentException.class,() ->compteEpargne.debiter(5100,""));
    }

    @Test
    void debiter_Montant_Normal() {
        compteEpargne.debiter(200,"");
        assertEquals(compteEpargne.getSolde(),4800);
    }

    @Test
    void debiter_Montant_Negatif() {
        Assertions.assertThrows(IllegalArgumentException.class,() ->compteEpargne.debiter(-200,""));
    }

    @org.junit.jupiter.api.Test
    void calcul_Interet_Classique(){
        assertEquals(compteEpargne.calculInteret(),2500);
    }

    @org.junit.jupiter.api.Test
    void calcul_Interet_Negatif(){
        CompteEpargne compteEpargne1 = new CompteEpargne("",1000,-10);
        assertEquals(compteEpargne1.calculInteret(),100);
    }

    @org.junit.jupiter.api.Test
    void calcul_Interet_Zero(){
        CompteEpargne compteEpargne1 = new CompteEpargne("",1000,0);
        assertEquals(compteEpargne1.calculInteret(),0);
    }


}