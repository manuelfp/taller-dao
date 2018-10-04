package com.devcodes.train.repositorydao.repositories;

import com.devcodes.train.repositorydao.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

        @Query("select r from Role r where r.role= ?1")
        Iterable<Role> findRole(Role role);
}
