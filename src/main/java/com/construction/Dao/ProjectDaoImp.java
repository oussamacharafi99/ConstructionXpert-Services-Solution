package com.construction.Dao;

import com.construction.classes.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImp implements ProjectDao{
    @Override
    public void addProject(Project project) throws SQLException {
        Connection connection = com.DAO.DataBaseManager.getConnection();
        String sql = "INSERT INTO projects (name, description, startDate, endDate, budget) VALUES (? , ? , ? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1 , project.getName());
        preparedStatement.setString(2 , project.getDescription());
        preparedStatement.setString(3 , project.getStartDate());
        preparedStatement.setString(4 , project.getEndDate());
        preparedStatement.setDouble(5 , project.getBudget());
        preparedStatement.execute();
    }


    @Override
    public List<Project> viewProject() {
        return null;
    }

    @Override
    public void updateProject(Integer id) {

    }

    @Override
    public void removeProject(Integer id) {

    }
}
