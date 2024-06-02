package com.construction.Dao;

import com.construction.classes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{
    @Override
    public void addUsers(User user) throws SQLException {
        Connection connection = com.DAO.DataBaseManager.getConnection();
        String sql = "INSERT INTO user ()";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    }

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> ListUser = new ArrayList<>();
        Connection connection = com.DAO.DataBaseManager.getConnection();
        String sql = "SELECT * FROM user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("");
            String name = resultSet.getString("");
            String email = resultSet.getString("");
            String password = resultSet.getString("");
            ListUser.add(new User(id , name , email , password));
        }
        return ListUser;
    }

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }

    @Override
    public void removeUsres(Integer id) {

    }
}
