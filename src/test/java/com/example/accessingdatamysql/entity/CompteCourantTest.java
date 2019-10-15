package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.entity.CompteCourant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Compte courant test.
 */
public class CompteCourantTest {

    /**
     * The Compte.
     */
    CompteCourant compte;

    /**
     * Sets up.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        compte = new CompteCourant("Compte classique",4000,1000);
    }

    /**
     * Debiter montant possible.
     */
    @org.junit.jupiter.api.Test
    void debiter_Montant_Possible() {
        compte.debiter(200,"");
        assertEquals(compte.getSolde(),3800);
    }

    /**
     * Debiter montant identique solde.
     */
    @org.junit.jupiter.api.Test
    void debiter_Montant_Identique_Solde() {
        compte.debiter(4000,"");
        assertEquals(compte.getSolde(),0);
    }

    /**
     * Debiter montant superieur solde.
     */
    @org.junit.jupiter.api.Test
    void debiter_Montant_Superieur_Solde() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> compte.debiter(10000,""));

    }

    /**
     * Crediter augmente.
     */
    @org.junit.jupiter.api.Test
    void crediter_Augmente() {
        compte.crediter(200,"");
        assertEquals(compte.getSolde(),4200);
    }

    /**
     * Crediter montant negatif.
     */
    @org.junit.jupiter.api.Test
    void crediter_Montant_Negatif()  {
        Assertions.assertThrows(IllegalArgumentException.class, () -> compte.crediter(-100,""));
    }



}