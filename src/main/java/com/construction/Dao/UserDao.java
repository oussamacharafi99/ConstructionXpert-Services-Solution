package com.construction.Dao;

import com.construction.classes.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public void addUsers(User user) throws SQLException;
    public List<User> getUsers() throws SQLException;
    public User updateUser(Integer id , User user);
    public void removeUsres(Integer id);
}
