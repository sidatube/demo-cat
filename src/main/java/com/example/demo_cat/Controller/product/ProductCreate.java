package com.example.demo_cat.Controller.product;

import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/product/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        model.save(new Product(req.getParameter("name"),req.getParameter("thumbnail"),Double.parseDouble(req.getParameter("price"))));
        resp.sendRedirect("/products");
    }
}
