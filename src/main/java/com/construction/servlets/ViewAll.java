package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.ResourceDaoImp;
import com.construction.Dao.TaskDaoImp;
import com.construction.classes.Project;
import com.construction.classes.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ViewAll")
public class ViewAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp P1 = new ProjectDaoImp();
        TaskDaoImp taskId = new TaskDaoImp();
        ResourceDaoImp resourceDaoImp = new ResourceDaoImp();

        try {
            List<Project> projects = P1.viewProject();
            if (!projects.isEmpty()) {
                int idP = projects.get(0).getId();

                List<Task> tasks = taskId.viewTaskE(idP);
                if (!tasks.isEmpty()) {
                    Integer idT = tasks.get(0).getId();
                    request.setAttribute("ressource", resourceDaoImp.getResourceIdTask(idT));
                } else {
                    // Handle case where tasks list is empty
                    request.setAttribute("ressource", null); // or set an appropriate default value
                }

                request.setAttribute("T", tasks);
                request.setAttribute("Tu", taskId.viewTaskT(idP));
            } else {
                // Handle case where projects list is empty
                request.setAttribute("T", null); // or set an appropriate default value
                request.setAttribute("Tu", null); // or set an appropriate default value
                request.setAttribute("ressource", null); // or set an appropriate default value
            }
            request.setAttribute("P1", projects);

            if (!projects.isEmpty()) {
                request.setAttribute("Project", projects.get(0));
            } else {
                request.setAttribute("Project", null); // or set an appropriate default value
            }

        } catch (SQLException e) {
            throw new ServletException("Error in doGet method of ViewAll servlet", e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement doPost if needed
    }
}
