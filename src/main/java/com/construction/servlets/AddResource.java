package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.ResourceDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddResource", value = "/AddResource")
public class AddResource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceDaoImp resourceDaoImp = new  ResourceDaoImp();
        Integer idT = Integer.parseInt(request.getParameter("idT"));
        int idP = Integer.parseInt(request.getParameter("idP"));
        Integer idR = Integer.parseInt(request.getParameter("idR"));
        try {
            resourceDaoImp.removeResource(idR);
            request.setAttribute("S", "S");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ProjectDaoImp project = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();

        try {
            request.setAttribute("P1" , project.viewProject());
            request.setAttribute("Project" , project.ViewProjectById(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            request.setAttribute("T" , taskId.viewTaskE(idP));
            request.setAttribute("Tu" , taskId.viewTaskT(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (!resourceDaoImp.getResourceIdTask(idT).isEmpty()){
                request.setAttribute("ressource",resourceDaoImp.getResourceIdTask(idT));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceDaoImp resourceDaoImp = new  ResourceDaoImp();
        int idProject = Integer.parseInt(request.getParameter("IdProject"));
        int idTache = Integer.parseInt(request.getParameter("idTask"));
        String nameRessource = request.getParameter("resourceName");
        String type = request.getParameter("type");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String supplier = request.getParameter("supplier");
        try {
            resourceDaoImp.addResource(new Resource(idTache , nameRessource , type , quantity , supplier));
            request.setAttribute("S", "S");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ProjectDaoImp project = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();

        try {
            request.setAttribute("P1" , project.viewProject());
            request.setAttribute("Project" , project.ViewProjectById(idProject));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            request.setAttribute("T" , taskId.viewTaskE(idProject));
            request.setAttribute("Tu" , taskId.viewTaskT(idProject));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (!resourceDaoImp.getResourceIdTask(idTache).isEmpty()){
                request.setAttribute("ressource",resourceDaoImp.getResourceIdTask(idTache));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }
}