package com.construction.servlets;
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
        TaskDaoImp task = new TaskDaoImp();
        Integer id = 1;
        try {
            request.setAttribute("TaskP" , task.viewTask(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}