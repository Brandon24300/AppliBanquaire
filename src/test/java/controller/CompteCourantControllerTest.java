package controller;

import com.example.accessingdatamysql.AccessingDataMysqlApplication;
import com.example.accessingdatamysql.controller.CompteController;
import com.example.accessingdatamysql.entity.Client;
import com.example.accessingdatamysql.entity.CompteCourant;
import com.example.accessingdatamysql.repository.ClientRepository;
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

    @Autowired
    ClientRepository clientRepository;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Client clien = new Client("aaa","bb");
        clien = clientRepository.save(clien);
        CompteCourant compteCourant = new CompteCourant("Compte",1000,10);
        CompteCourant c2 = new CompteCourant("Compte",1000,10);
        compteCourantController.addNewCompteCourant(compteCourant.getIntitule(),compteCourant.getSolde(),compteCourant.getMontantDecouvertAutorise(),clien.getId());
        compteCourantController.addNewCompteCourant(c2.getIntitule(),c2.getSolde(),c2.getMontantDecouvertAutorise(),clien.getId());
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