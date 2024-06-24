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
        Role r2 = new Role("zoodata");
        Role r3 = new Role("animaldata");
        Role r4 = new Role("mgr");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));

        ArrayList<UserRoles> zooData = new ArrayList<>();
        zooData.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> animalData = new ArrayList<>();
        animalData.add(new UserRoles(new User(), r3));

        ArrayList<UserRoles> mgr = new ArrayList<>();
        mgr.add(new UserRoles(new User(), r4));

        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);

        User u1 = new User("admin", "pass", admins);
        User u2 = new User("zoodata", "pass", zooData);
        User u3 = new User("animaldata", "pass", animalData);
        User u4 = new User("mgr", "pass", mgr);

        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
    }
}
