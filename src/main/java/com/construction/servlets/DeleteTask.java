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

@WebServlet(name = "DeleteTask", value = "/DeleteTask")
public class DeleteTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idT=Integer.valueOf(request.getParameter("idT"));
        int idP= Integer.parseInt(request.getParameter("idP"));
        ResourceDaoImp res=new ResourceDaoImp();
        TaskDaoImp tr=new TaskDaoImp();
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
            tr.removeTask(idT);
            if (!res.getResourceIdTask(idT).isEmpty()){
                request.setAttribute("ressource",res.getResourceIdTask(idT));
            }
            else {
                request.setAttribute("T" , taskId.viewTaskE(idP));
                request.setAttribute("Tu" , taskId.viewTaskT(idP));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDaoImp task = new TaskDaoImp();
        int idTask = Integer.parseInt(request.getParameter("idTask"));
        int idProject = Integer.parseInt(request.getParameter("idProject"));
        String dateDubetTask = request.getParameter("DateDebutTask");
        String dateFinTask = request.getParameter("DateFinTask");
        String status = request.getParameter("statusTask");
        String descriptionTask = request.getParameter("DescriptionTask");
        try {
            task.updateTask(idTask ,new Task(idProject , descriptionTask , dateDubetTask , dateFinTask , status));
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
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);

    }
}