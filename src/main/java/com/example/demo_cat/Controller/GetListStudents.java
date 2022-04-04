package com.example.demo_cat.Controller;

import com.example.demo_cat.entity.Student;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Student> model = new UltraModel<>(Student.class);

        List<Student> list = model.getList();
        req.setAttribute("listStudents",list);
        req.getRequestDispatcher("/admin/student/list.jsp").forward(req,resp);
    }
}
