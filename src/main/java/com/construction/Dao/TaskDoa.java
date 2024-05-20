package com.construction.Dao;

import com.construction.classes.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDoa {
    public void addTask(Task task) throws SQLException;
    public List<Task> viewTask(int projectId) throws SQLException;
    public void updateTask(Integer id);
    public void removeTask(Integer id) throws SQLException;
}
