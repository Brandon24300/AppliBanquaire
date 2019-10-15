package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Find by email user.
     *
     * @param name the name
     * @return the user
     */
    User findByEmail(String name);
}