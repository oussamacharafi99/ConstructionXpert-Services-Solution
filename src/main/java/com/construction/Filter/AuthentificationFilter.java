//package com.construction.Filter;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class AuthentificationFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization code, if needed
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String uri = request.getRequestURI();
//        HttpSession session = request.getSession(false);
//
//        boolean loggedIn = session != null && session.getAttribute("username") != null;
//        boolean loginRequest = uri.endsWith("login");
//
//        if (loggedIn || loginRequest) {
//            filterChain.doFilter(request, response);
//        } else {
//            response.sendRedirect("login.jsp"); // Rediriger vers la page de connexion si l'utilisateur n'est pas authentifié
//        }
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup code, if needed
//    }
//}
