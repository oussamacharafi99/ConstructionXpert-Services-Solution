package com.construction.Dao;

import com.construction.classes.Resource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImp implements ResourceDao {

    @Override
    public void addResource(Resource resource) throws SQLException {
        String sql = "INSERT INTO resources (resource_id, name, type, quantity, supplier) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, resource.getResource_id());
            preparedStatement.setString(2, resource.getName());
            preparedStatement.setString(3, resource.getType());
            preparedStatement.setInt(4, resource.getQuantity());
            preparedStatement.setString(5, resource.getSupplier());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Resource> viewResources() throws SQLException {
        List<Resource> allResources = new ArrayList<>();
        String sql = "SELECT * FROM resources";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int resource_id = resultSet.getInt("resource_id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");
                String supplier = resultSet.getString("supplier");
                allResources.add(new Resource(id, resource_id, name, type, quantity, supplier));
            }
        }
        return allResources;
    }

    @Override
    public void updateResource(Integer id, Resource resource) throws SQLException {
        String sql = "UPDATE resources SET resource_id = ?, name = ?, type = ?, quantity = ?, supplier = ? WHERE id = ?";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, resource.getResource_id());
            preparedStatement.setString(2, resource.getName());
            preparedStatement.setString(3, resource.getType());
            preparedStatement.setInt(4, resource.getQuantity());
            preparedStatement.setString(5, resource.getSupplier());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeResource(Integer id) throws SQLException {
        String sql = "DELETE FROM resources WHERE id = ?";
        try (Connection connection = com.DAO.DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
