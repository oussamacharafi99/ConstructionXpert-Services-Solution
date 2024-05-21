package com.construction.Dao;

import com.construction.classes.Project;
import com.construction.classes.Resource;

import java.sql.SQLException;
import java.util.List;

public interface ResourceDao {
    public void addResource(Resource resource) throws SQLException;
    public List<Resource> viewResources() throws SQLException;
    public void updateResource(Integer id, Resource resource) throws SQLException ;
    public void removeResource(Integer id) throws SQLException;
}
