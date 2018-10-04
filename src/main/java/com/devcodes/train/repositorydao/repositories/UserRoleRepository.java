package com.devcodes.train.repositorydao.repositories;

import com.devcodes.train.repositorydao.entities.UserRole;
import com.devcodes.train.repositorydao.entities.UserRolePk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRolePk> {

}
