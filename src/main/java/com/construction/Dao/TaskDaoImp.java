package com.construction.Dao;

import com.construction.classes.Project;
import com.construction.classes.Task;
import com.mysql.cj.jdbc.ConnectionWrapper;

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
    public List<Task> viewTaskE(int projectId) throws SQLException {
        List<Task> allTaskE = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE projectId = ? AND (status=? OR status=?)";
        Connection connection = com.DAO.DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
        preparedStatement.setString(2,"In Progress");
        preparedStatement.setString(3,"To Do");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setProjectId(resultSet.getInt("projectId"));
                task.setDescription(resultSet.getString("description"));
                task.setStartDate(resultSet.getString("startDate"));
                task.setEndDate(resultSet.getString("endDate"));
                task.setStatus(resultSet.getString("status"));
                allTaskE.add(task);
            }
        return allTaskE;
    }

    @Override
    public List<Task> viewTaskT(int projectId) throws SQLException {
        List<Task> allTaskT = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE projectId = ? AND status=?";
        Connection connection = com.DAO.DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, projectId);
        preparedStatement.setString(2,"Completed");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getInt("id"));
            task.setProjectId(resultSet.getInt("projectId"));
            task.setDescription(resultSet.getString("description"));
            task.setStartDate(resultSet.getString("startDate"));
            task.setEndDate(resultSet.getString("endDate"));
            task.setStatus(resultSet.getString("status"));
            allTaskT.add(task);
        }
        return allTaskT;
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


    @Override
    public Project findProjetById(Integer id) throws SQLException {
        Project project = null;
        String sqlTask = "SELECT projectId FROM tasks WHERE id = ?";
        String sqlProject = "SELECT * FROM projects WHERE id = ?";
        PreparedStatement preparedStatementTask = null;
        PreparedStatement preparedStatementProject = null;
        ResultSet resultSetTask = null;
        ResultSet resultSetProject = null;
//        ---------------------
            Connection connection = com.DAO.DataBaseManager.getConnection();
            preparedStatementTask = connection.prepareStatement(sqlTask);
            preparedStatementTask.setInt(1, id);
            resultSetTask = preparedStatementTask.executeQuery();

            Integer projectId = null;
            if (resultSetTask.next()) {
                projectId = resultSetTask.getInt("projectId");
            }
            if (projectId == null) {
                return null;
            }
//        ---------------------
            preparedStatementProject = connection.prepareStatement(sqlProject);
            preparedStatementProject.setInt(1, projectId);
            resultSetProject = preparedStatementProject.executeQuery();

            if (resultSetProject.next()) {
                String projectName = resultSetProject.getString("name");
                String projectDescription = resultSetProject.getString("description");
                String startDate = resultSetProject.getString("startDate");
                String endDate = resultSetProject.getString("endDate");
                Double budget = resultSetProject.getDouble("budget");

                project = new Project(projectId, projectName, projectDescription, startDate, endDate, budget);
            }
        return project;
    }
    public int getTaskCount(int projectId, String status) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tasks WHERE projectId = ? AND status = ?";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projectId);
            preparedStatement.setString(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }
}

