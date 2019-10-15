package controller;

import com.example.accessingdatamysql.AccessingDataMysqlApplication;
import com.example.accessingdatamysql.controller.MainController;
import com.example.accessingdatamysql.entity.User;

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
 * The type Main controller test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccessingDataMysqlApplication.class)
@ActiveProfiles("test")

class MainControllerTest {
    /**
     * The Main controller.
     */
    @Autowired
    MainController mainController;


    /**
     * The User.
     */
    User user;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        user = new User("James","james@gmail.com");
        mainController.addNewUser(user.getName(),user.getEmail());
        mainController.addNewUser("Speedy","speedy@gmail.fr");


    }

    /**
     * Add new user.
     */
    @Test
    void addNewUser() {
        User user = new User("Dominique","dominique@gmail.com");
        assertEquals(mainController.addNewUser(user.getName(),user.getEmail()),"Saved");
    }

    /**
     * Gets all users.
     */
    @Test
    void getAllUsers() {
        Iterator<User> iterator = mainController.getAllUsers().iterator();
        int i = 0;
        while(iterator.hasNext()) {
            i++;
            iterator.next();
        }
        assertNotSame(0,i);
    }


}