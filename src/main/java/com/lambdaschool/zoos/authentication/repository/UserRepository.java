package com.lambdaschool.zoos.authentication.repository;

import com.lambdaschool.zoos.authentication.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
