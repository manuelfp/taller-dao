package com.devcodes.train.repositorydao.repositories;

import com.devcodes.train.repositorydao.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT m FROM User m WHERE m.username = ?1")
    User findByUsername(String username);
}
