package com.construction.servlets;
import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.ResourceDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewProject", value = "/ViewProject")
public class ViewProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp project = new ProjectDaoImp();
        ResourceDaoImp resourceDaoImp = new ResourceDaoImp();
        TaskDaoImp taskDaoImp = new TaskDaoImp();
        Integer idP = Integer.valueOf(request.getParameter("id"));

        try {
            int idT = taskDaoImp.viewTaskE(idP).get(0).getId();
            request.setAttribute("ressource",resourceDaoImp.getResourceIdTask(idT));
            request.setAttribute("P1" , project.viewProject());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            request.setAttribute("Project" , project.ViewProjectById(idP));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        TaskDaoImp taskId = new TaskDaoImp();


        try {

            request.setAttribute("T" , taskId.viewTaskE(idP));
            request.setAttribute("Tu" , taskId.viewTaskT(idP));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}