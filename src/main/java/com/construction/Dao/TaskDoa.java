package com.construction.Dao;

import com.construction.classes.Project;
import com.construction.classes.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDoa {
     void addTask(Task task) throws SQLException;
     List<Task> viewTaskE(int projectId) throws SQLException;
    List<Task> viewTaskT(int projectId) throws SQLException;

     void updateTask(Integer id, Task task) throws SQLException;
     void removeTask(Integer id) throws SQLException;
     Project findProjetById(Integer id)throws SQLException;
     int getTaskCount(int projectId, String status) throws SQLException;
}
