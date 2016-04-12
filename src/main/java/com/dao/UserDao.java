package com.dao;

import com.entity.User;

import java.util.List;


/**
 * Created by pc9 on 31.03.16.
 */
public interface UserDao {
    public User getUser (Integer id);

    public List<User> getAllUsers();

    public User getUserWithJoins(Integer id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);




}
