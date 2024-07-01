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
import java.util.List;

@WebServlet(name = "ViewProject", value = "/ViewProject")
public class ViewProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp projectDao = new ProjectDaoImp();
        TaskDaoImp taskDao = new TaskDaoImp();
        ResourceDaoImp resourceDao = new ResourceDaoImp();

        Integer idP = Integer.valueOf(request.getParameter("id"));

        try {
            List<Task> tasks = taskDao.viewTaskE(idP);
            if (!tasks.isEmpty()) {
                int idT = tasks.get(0).getId();
                request.setAttribute("ressource", resourceDao.getResourceIdTask(idT));
            } else {
                request.setAttribute("ressource", null);
            }

            request.setAttribute("P1", projectDao.viewProject());

            try {
                request.setAttribute("Project", projectDao.ViewProjectById(idP));
            } catch (SQLException e) {
                throw new ServletException("Error retrieving project by ID", e);
            }

            request.setAttribute("T", tasks);
            request.setAttribute("Tu", taskDao.viewTaskT(idP));

        } catch (SQLException e) {
            throw new ServletException("Error retrieving tasks or resources", e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}