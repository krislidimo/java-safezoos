package com.lambdaschool.zoos;

import com.lambdaschool.zoos.authentication.models.Role;
import com.lambdaschool.zoos.authentication.models.User;
import com.lambdaschool.zoos.authentication.models.UserRoles;
import com.lambdaschool.zoos.authentication.repository.RoleRepository;
import com.lambdaschool.zoos.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("zoodata");
        Role r4 = new Role("animaldata");
        Role r5 = new Role("mgr");


        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));


        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        users.add(new UserRoles(new User(), r3));
        users.add(new UserRoles(new User(), r4));
        users.add(new UserRoles(new User(), r5));


        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);
        rolerepos.save(r5);



        User u1 = new User("admin", "pass!", users);
        User u2 = new User("zoodata", "pass", admins);
        User u3 = new User("animaldata", "pass", admins);
        User u4 = new User("mgr", "pass", admins);
        User u5 = new User("user", "pass", admins);


        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
        userrepos.save(u5);

    }
}
