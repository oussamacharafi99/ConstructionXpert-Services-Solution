package com.construction.Dao;

import com.construction.classes.Project;

import java.sql.*;
import java.util.ArrayList;
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
    public List<Project> viewProject() throws SQLException {
        List<Project> allProjects = new ArrayList<>();
        Connection connection = com.DAO.DataBaseManager.getConnection();
        String sql = "SELECT * FROM projects";
        Statement statement = connection.createStatement();
        ResultSet r = statement.executeQuery(sql);
        while (r.next()){
            Integer project_id = r.getInt("id");
            String project_name = r.getString("name");
            String project_description = r.getString("description");
            String startDate = r.getString("description");
            String endDate = r.getString("description");
            Double budjet = r.getDouble("budget");
            allProjects.add(new Project(project_id, project_name, project_description, startDate , endDate, budjet));
        }
        return allProjects;
    };


    @Override
    public void updateProject(Integer id, Project project) throws SQLException {
        String sql = "UPDATE projects SET name = ?, description = ?, startDate = ?, endDate = ?, budget = ? WHERE id = ?";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getStartDate());
            preparedStatement.setString(4, project.getEndDate());
            preparedStatement.setDouble(5, project.getBudget());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeProject(Integer id) throws SQLException {
        Connection connection = com.DAO.DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM projects WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
