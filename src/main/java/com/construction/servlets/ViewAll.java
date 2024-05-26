package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.TaskDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewAll", value = "/ViewAll")
public class ViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp P1 = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        try {
            Integer idP = P1.viewProject().get(0).getId();
            request.setAttribute("T" , taskId.viewTaskE(idP));
            request.setAttribute("Tu" , taskId.viewTaskT(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            request.setAttribute("P1", P1.viewProject());

            if (!P1.viewProject().isEmpty()) {
                request.setAttribute("Project", P1.viewProject().get(0));
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