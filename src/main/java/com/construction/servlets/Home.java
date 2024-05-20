package com.construction.servlets;

import com.construction.Dao.ProjectDaoImp;
import com.construction.classes.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImp PR = new ProjectDaoImp();
        try {
            PR.addProject(new Project("BuildEnaa" , "this project for build enaa School" , "2000-01-09" , "2022-02-23",100203));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}