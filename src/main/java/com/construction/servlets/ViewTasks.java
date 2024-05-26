package com.construction.servlets;
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
        ResourceDaoImp res=new ResourceDaoImp();
        TaskDaoImp tr=new TaskDaoImp();
        try {
            request.setAttribute("ProjectId",tr.findProjetById(idT));
            request.setAttribute("ressource",res.getResourceIdTask(idT));
            for (Resource r:res.getResourceIdTask(idT)){
                System.out.println(r.getName());
            } yalah partage nkmlo dakchi dialk 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
