package com.construction.Dao;

import com.construction.classes.Project;

import java.util.List;

public interface ProjectDao {
    public void addProject();
    public List<Project> viewProject();
    public void updateProject(Integer id);
    public void removeProject(Integer id);
}
