package controller;

import com.example.accessingdatamysql.AccessingDataMysqlApplication;
import com.example.accessingdatamysql.controller.CompteController;
import com.example.accessingdatamysql.entity.CompteCourant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Compte courant controller test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccessingDataMysqlApplication.class)
@ActiveProfiles("test")

class CompteCourantControllerTest {
    /**
     * The Compte courant controller.
     */
    @Autowired
    CompteController compteCourantController;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
//        CompteCourant compteCourant = new CompteCourant("MSI001","Compte",1000,10);
//        CompteCourant c2 = new CompteCourant("MSI001","Compte",1000,10);
//        compteCourantController.addNewCompteCourant(compteCourant.getNumero(),compteCourant.getIntitule(),compteCourant.getSolde(),compteCourant.getMontantDecouvertAutorise());
//        compteCourantController.addNewCompteCourant(c2.getNumero(),c2.getIntitule(),c2.getSolde(),c2.getMontantDecouvertAutorise());
    }

    /**
     * Gets all compte courant.
     */
    @Test
    void getAllCompteCourant() {
        Iterator<CompteCourant> iterator = compteCourantController.getAllCompteCourant().iterator();
        int i = 0;
        while(iterator.hasNext()) {
            i++;
            iterator.next();
        }

        assertNotSame(0,i);

    }

    /**
     * Add new compte courant.
     */
    @Test
    void addNewCompteCourant() {
//        CompteCourant compteCourant = new CompteCourant("dddd","Compte",1000,10);
//        String response = compteCourantController.addNewCompteCourant(compteCourant.getNumero(),compteCourant.getIntitule(),compteCourant.getSolde(),compteCourant.getMontantDecouvertAutorise());
//        assertEquals("Saved",response);
    }
}