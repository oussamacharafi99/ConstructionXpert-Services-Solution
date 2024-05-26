package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateProject", value = "/UpdateProject")
public class UpdateProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp project = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        int idProject = Integer.parseInt(request.getParameter("idProject"));
        String nameProject = request.getParameter("NameProject");
        String dateDebut = request.getParameter("DateDebutProject");
        String dateFin = request.getParameter("DateFinProject");
        double budget = Double.parseDouble(request.getParameter("BudgetProject"));
        String description = request.getParameter("DescriptionProject");
        try {
            project.updateProject(idProject , new Project(nameProject , description, dateDebut , dateFin , budget));
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
            request.setAttribute("T" , taskId.viewTaskE(idProject));
            request.setAttribute("Tu" , taskId.viewTaskT(idProject));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            request.setAttribute("P1", project.viewProject());

            if (!project.viewProject().isEmpty()) {
                request.setAttribute("Project", project.ViewProjectById(idProject));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request , response);
    }
}