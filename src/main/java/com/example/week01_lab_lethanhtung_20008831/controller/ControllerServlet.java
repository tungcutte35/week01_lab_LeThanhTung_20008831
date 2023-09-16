package com.example.week01_lab_lethanhtung_20008831.controller;

import com.example.week01_lab_lethanhtung_20008831.constant.env;
import com.example.week01_lab_lethanhtung_20008831.models.*;
import com.example.week01_lab_lethanhtung_20008831.respositories.AccountRespository;
import com.example.week01_lab_lethanhtung_20008831.services.AccountService;
import com.example.week01_lab_lethanhtung_20008831.services.GrandAccessService;
import com.example.week01_lab_lethanhtung_20008831.services.RoleService;
import com.example.week01_lab_lethanhtung_20008831.services.impl.AccountServiceImpl;
import com.example.week01_lab_lethanhtung_20008831.services.impl.GrandAccessServiceImpl;
import com.example.week01_lab_lethanhtung_20008831.services.impl.RoleServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
                sendHelloResponse(resp);

            }} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    private void sendHelloResponse(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello</h1>");
        out.println("</body></html>");
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            AccountService accountService = new AccountServiceImpl();
            GrandAccessService grandAccessService = new GrandAccessServiceImpl();

            if (action != null) {
                switch (action) {
                    case "login":
                        handleLogin(req, resp);
                        break;
                    case "create-account":
                        handleCreateAccount(req, resp, accountService);
                        break;
                    default:
                        sendHelloResponse(resp);
                        break;
                }
            } else {
                sendHelloResponse(resp);
            }}catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setAttribute("timeLogin", System.currentTimeMillis());
        AccountService accountService = new AccountServiceImpl();

        try {
            int status = accountService.login(username, password);

            switch (status) {
                case 1:
                    handleAdminLogin(req, resp);
                    break;

                case -1:
                    resp.sendRedirect(env.appName + "/web?action=login");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleAdminLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        AccountService accountService = new AccountServiceImpl();
        List<Account> accounts = accountService.getAllAccount();
        req.setAttribute("accounts", accounts);
        forwardToPage("/web/dashboard.jsp", req, resp);
        sendSuccessMessage(resp, "Welcome admin login !");
    }





    private void sendSuccessMessage(HttpServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    private void handleCreateAccount(HttpServletRequest req, HttpServletResponse resp, AccountService accountService) throws Exception {
        Map<String, String> inputData = extractInputData(req);
        Account account = createAccountFromInputData(inputData);

        if (account != null) {
            if (accountService.createAccount(account)) {
                resp.sendRedirect(env.appName + "/web?action=list-account");
                sendSuccessMessage(resp, "Create account successfully!");
            } else {
                resp.sendRedirect(env.appName + "/web?action=list-account");

            }
        } else {
            resp.sendRedirect(env.appName + "/web?action=list-account");

        }
    }

    private Map<String, String> extractInputData(HttpServletRequest req) {
        Map<String, String> inputData = new HashMap<>();
        inputData.put("accountId", req.getParameter("accountId"));
        inputData.put("fullName", req.getParameter("fullname"));
        inputData.put("password", req.getParameter("password"));
        inputData.put("email", req.getParameter("email"));
        inputData.put("phone", req.getParameter("phone"));
        inputData.put("status", req.getParameter("status"));
        return inputData;
    }

    private Account createAccountFromInputData(Map<String, String> inputData) {
        String accountId = inputData.get("accountId");
        String fullName = inputData.get("fullName");
        String password = inputData.get("password");
        String email = inputData.get("email");
        String phone = inputData.get("phone");
        String statusStr = inputData.get("status");

        try {
            int statusInt = Integer.parseInt(statusStr);
            STATUS status = convertToStatus(statusInt);
            return new Account(accountId, fullName, password, email, phone, status);
        } catch (NumberFormatException e) {
            return null; // Trả về null nếu có lỗi trong việc chuyển đổi status
        }
    }

    private STATUS convertToStatus(int statusInt) {
        switch (statusInt) {
            case 1:
                return STATUS.ACTIVE;
            case 0:
                return STATUS.DEACTIVE;
            default:
                return STATUS.DELETED;
        }
    }




}