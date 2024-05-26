package com.construction.Dao;

import com.construction.classes.Project;
import com.construction.classes.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDoa {
    public void addTask(Task task) throws SQLException;
    public List<Task> viewTaskE(int projectId) throws SQLException;
    public List<Task> viewTaskT(int projectId) throws SQLException;

    public void updateTask(Integer id, Task task) throws SQLException;
    public void removeTask(Integer id) throws SQLException;
    public Project findProjetById(Integer id)throws SQLException;
}
