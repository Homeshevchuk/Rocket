package com.example;

import com.example.Entities.Team;
import com.example.Entities.User;
import com.example.Dao.TeamDao;
import com.example.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
    @Autowired
    TeamDao teamRepository;
    @Autowired
    UserDao userDao;
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      User user1 =  createUser("Admin", "Admin");
      User user2 =  createUser("Nekich", "123123123");
       User user3 = createUser("Cigan", "123123123");
        Team team = new Team();
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);

        teamRepository.save(team);
        team.setLead(user1);
        team.addUser(user2);
        team.addUser(user3);
        teamRepository.save(team);

       User asd =  userDao.findByName("Nekich");
        System.out.println("done");
    }

    private User createUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}

