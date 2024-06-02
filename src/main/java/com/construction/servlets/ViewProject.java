package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.Dao.ResourceDaoImp;
import com.construction.Dao.TaskDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewProject", value = "/ViewProject")
public class ViewProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp projectDao = new ProjectDaoImp();
        ResourceDaoImp resourceDao = new ResourceDaoImp();
        TaskDaoImp taskDao = new TaskDaoImp();

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing project ID");
            return;
        }

        int idP;
        try {
            idP = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid project ID");
            return;
        }
        try {
            request.setAttribute("Completed", taskDao.getCompletedTaskCount(idP));
            request.setAttribute("ToDo", taskDao.getToDoTaskCount(idP));
            request.setAttribute("Progress", taskDao.getInProgressTaskCount(idP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (!taskDao.viewTaskE(idP).isEmpty()) {
                int idT = taskDao.viewTaskE(idP).get(0).getId();
                if (idT != 0) {
                    request.setAttribute("resource", resourceDao.getResourceIdTask(idT));
                }
            }

            request.setAttribute("P1", projectDao.viewProject());
            request.setAttribute("Project", projectDao.ViewProjectById(idP));
            request.setAttribute("T", taskDao.viewTaskE(idP));
            request.setAttribute("Tu", taskDao.viewTaskT(idP));

            this.getServletContext().getRequestDispatcher("/WEB-INF/viewProject.jsp").forward(request, response);

        } catch (SQLException e) {
            log("Database access error: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database access error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
