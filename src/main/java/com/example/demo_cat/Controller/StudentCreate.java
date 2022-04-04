package com.example.demo_cat.Controller;

import com.example.demo_cat.entity.Student;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/student/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Student> model = new UltraModel<>(Student.class);
        Student st = new Student(req.getParameter("rollName"), req.getParameter("email"), req.getParameter("name"));
        if (!st.isValid()) {
            req.setAttribute("errors", st.getErrors());
            req.getRequestDispatcher("/admin/student/form.jsp").forward(req, resp);
            return;
        }
        model.save(st);
        resp.sendRedirect("/students");
    }
}
