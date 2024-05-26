package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddProject", value = "/AddProject")
public class AddProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp project = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        Integer idD = Integer.valueOf(request.getParameter("idD"));
        try {
            project.removeProject(idD);
            request.setAttribute("alert" , "..");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            request.setAttribute("P1" , project.viewProject());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Integer idP = project.viewProject().get(0).getId();
            request.setAttribute("T" , taskId.viewTaskE(idP));
            request.setAttribute("Tu" , taskId.viewTaskT(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            request.setAttribute("P1", project.viewProject());

            if (!project.viewProject().isEmpty()) {
                request.setAttribute("Project", project.viewProject().get(0));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp project = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        String nameProject = request.getParameter("NameProject");
        String dateDebut = request.getParameter("DateDebutProject");
        String dateFin = request.getParameter("DateFinProject");
        double budget = Double.parseDouble(request.getParameter("BudgetProject"));
        String description = request.getParameter("DescriptionProject");
        try {
               project.addProject(new Project(nameProject , description, dateDebut , dateFin , budget));
               request.setAttribute("alert" , ".");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            request.setAttribute("P1" , project.viewProject());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Integer idP = project.viewProject().get(0).getId();
            request.setAttribute("T" , taskId.viewTaskE(idP));
            request.setAttribute("Tu" , taskId.viewTaskT(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            request.setAttribute("P1", project.viewProject());

            if (!project.viewProject().isEmpty()) {
                request.setAttribute("Project", project.viewProject().get(0));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request , response);
    }
}