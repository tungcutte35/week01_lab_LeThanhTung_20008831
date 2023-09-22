package com.example.lb1_none.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try{
            if (action != null) {
                switch (action) {
                    case "login":
                        forwardToPage("/web/login.jsp", req, resp);
                        break;
                    case "create-account":
                        forwardToPage("/web/dashboard.jsp", req, resp);
                        break;
                }
            } else {
    }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).include(req, resp);
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try{
            if (action != null) {
                switch (action) {
                    case "login":
                        handleLogin(req, resp);
                        break;
                    case "create-account":
                        handleCreateAccount(req, resp);
                        break;
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/web/login.jsp");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null){
            resp.sendRedirect(req.getContextPath() + "/web/login.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/web/dashboard.jsp");
        }
    }

    private void handleCreateAccount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        if (username == null || password == null || email == null || phone == null){
            resp.sendRedirect(req.getContextPath() + "/web/dashboard.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/web/login.jsp");
        }
    }


}
