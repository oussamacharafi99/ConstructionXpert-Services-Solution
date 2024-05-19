package com.construction.Dao;

import com.construction.classes.Task;

import java.util.List;

public interface TaskDoa {
    public void addTask();
    public List<Task> viewTask();
    public void updateTask(Integer id);
    public void removeTask(Integer id);
}
