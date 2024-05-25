package com.construction.servlets;
import com.construction.Dao.ProjectDaoImp;
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
        ProjectDaoImp projectId = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        Integer idP = Integer.valueOf(request.getParameter("id"));

        try {
            request.setAttribute("T" , taskId.viewTask(idP));
            request.setAttribute("ProjectId" , projectId.ViewProjectById(idP));
            request.setAttribute("P1" , projectId.viewProject());

            for (Task t : taskId.viewTask(idP) ){
                System.out.println("hfhfhfh 99999 " + t.getDescription());
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