package com.construction.servlets;
import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.ResourceDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Resource;
import com.construction.classes.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ViewTasks", value = "/ViewTasks")
public class ViewTasks extends HttpServlet {

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
            request.setAttribute("Project",tr.findProjetById(idT));
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

    }

}
