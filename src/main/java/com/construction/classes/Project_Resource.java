package com.construction.classes;

public class Project_Resource{
    public Project_Resource(Integer project_id, Integer resource_id) {
        this.project_id = project_id;
        this.resource_id = resource_id;
    }
    public Project_Resource() {
    }

    private Integer project_id;
    private Integer resource_id;

    public Integer getProject_id() {
        return project_id;
    }
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getResource_id() {
        return resource_id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }
}
