package com.construction.servlets;
import com.construction.Dao.TaskDaoImp;
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
        Integer id = 1; // Assuming you want to view tasks for a specific project ID
        TaskDaoImp task = new TaskDaoImp();
        try {
            List<Task> tasks = task.viewTask(id);
            request.setAttribute("TaskP", tasks);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewProject.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        TaskDaoImp task = new TaskDaoImp();
        try {
            task.removeTask(taskId);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new ServletException(e);
        }
    }
}
