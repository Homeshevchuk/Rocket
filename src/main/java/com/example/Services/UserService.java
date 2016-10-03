package com.example.Services;

import com.example.Dao.UserDao;
import com.example.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PC on 28.09.2016.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public void register(User user) {
        if (user.getName() == null || user.getPassword() == null) {
            throw new IllegalArgumentException();
        }
        userDao.save(user);

    }
    public User getUser(String name){
        return userDao.findByName(name);
    }
}
