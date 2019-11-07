package com.joker.sm.controller;

import com.joker.sm.entity.Staff;
import com.joker.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Staff staff = selfService.login(account, password);
        if (staff == null) {
            response.sendRedirect(request.getContextPath() + "/toLogin.do");
        } else {
            request.getSession().setAttribute("STAFF", staff);
            response.sendRedirect(request.getContextPath() + "/main.do");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("STAFF");
        response.sendRedirect(request.getContextPath() + "/toLogin.do");
    }

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request, response);
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request, response);
    }
}