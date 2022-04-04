package com.example.demo_cat.Controller.product;

import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        List<Product> list = model.getList();
        req.setAttribute("listProducts", list);
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
    }
}
