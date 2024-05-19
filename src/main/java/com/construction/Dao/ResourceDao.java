package com.construction.Dao;

import com.construction.classes.Project;

import java.util.List;

public interface ResourceDao {
    public void addResource();
    public List<Project> viewResource();
    public void updateResource(Integer id);
    public void removeResource(Integer id);
}
