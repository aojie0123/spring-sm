package com.joker.sm.controller;

import com.joker.sm.entity.Department;
import com.joker.sm.entity.Staff;
import com.joker.sm.service.DepartmentService;
import com.joker.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    private static final String salt = "&%5123***&&%%$$#@";
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }

    public void to_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("departments", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String sex = request. getParameter("sex");
        String account = request.getParameter("account");
        String password = DigestUtils.md5DigestAsHex((request.getParameter("password") + "/" + salt).getBytes());
        String idNumber = request.getParameter("idNumber");
        String date = request.getParameter("bornDate");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int did = Integer.parseInt(request.getParameter("did"));

        Staff staff = new Staff();
        staff.setName(name);
        staff.setSex(sex);
        staff.setAccount(account);
        staff.setPassword(password);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setDid(did);

        staffService.add(staff);
        response.sendRedirect(request.getContextPath() + "/staff/list.do");
    }

    public void to_edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        List<Department> list = departmentService.getAll();
        request.setAttribute("staff", staff);
        request.setAttribute("departments", list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String idNumber = request.getParameter("idNumber");
        Date bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        int did = Integer.parseInt(request.getParameter("did"));

        Staff staff = staffService.get(id);
        staff.setName(name);
        staff.setSex(sex);
        staff.setAccount(account);
        if (!password.equals("")) {
            staff.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setDid(did);
        staffService.update(staff);

        response.sendRedirect(request.getContextPath() + "/staff/list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.delete(id);
        response.sendRedirect(request.getContextPath() + "/staff/list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
    }
}
