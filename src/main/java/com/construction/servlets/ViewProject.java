package com.construction.servlets;
import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.TaskDaoImp;

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
        String id = request.getParameter("id");
        Integer idP = Integer.valueOf(id);
        try {
            request.setAttribute("ProjectId" , projectId.ViewProjectById(idP));
            request.setAttribute("P1" , projectId.viewProject());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward( request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}