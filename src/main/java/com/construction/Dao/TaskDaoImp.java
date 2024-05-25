package com.construction.Dao;

import com.construction.classes.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImp implements TaskDoa{
    @Override
    public void addTask(Task task) throws SQLException {
        Connection connection = com.DAO.DataBaseManager.getConnection();
        String sql = "INSERT INTO tasks(`projectId`, `description`, `startDate`, `endDate`, `status`) VALUES (? , ? , ? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1 , task.getProjectId());
        preparedStatement.setString(2 , task.getDescription());
        preparedStatement.setString(3 , task.getStartDate());
        preparedStatement.setString(4 , task.getEndDate());
        preparedStatement.setString(5 , task.getStatus());
        preparedStatement.execute();
    }

    @Override
    public List<Task> viewTask(int projectId) throws SQLException {
        List<Task> allTask = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE projectId = ?";
        Connection connection = com.DAO.DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setProjectId(resultSet.getInt("projectId"));
                task.setDescription(resultSet.getString("description"));
                task.setStartDate(resultSet.getString("startDate"));
                task.setEndDate(resultSet.getString("endDate"));
                task.setStatus(resultSet.getString("status"));
                allTask.add(task);
            }
        return allTask;
    }


    @Override
    public void updateTask(Integer id, Task task) throws SQLException {
        String sql = "UPDATE tasks SET projectId = ?, description = ?, startDate = ?, endDate = ?, status = ? WHERE id = ?";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, task.getProjectId());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getStartDate());
            preparedStatement.setString(4, task.getEndDate());
            preparedStatement.setString(5, task.getStatus());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeTask(Integer id) throws SQLException {
        Connection connection = com.DAO.DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tasks WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
