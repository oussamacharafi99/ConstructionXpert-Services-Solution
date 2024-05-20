package com.construction.Dao;

import com.construction.classes.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    public void addProject(Project project) throws SQLException;
    public List<Project> viewProject() throws SQLException;
    public void updateProject(Integer id);
    public void removeProject(Integer id) throws SQLException;
}
