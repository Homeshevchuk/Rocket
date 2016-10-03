package com.example.Dao;

import com.example.Entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by PC on 24.09.2016.
 */
public interface UserDao extends CrudRepository<User,Long> {
    User findByName(String name);

}
