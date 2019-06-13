package com.lambdaschool.zoos.authentication.services;

import com.lambdaschool.zoos.authentication.models.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);
}