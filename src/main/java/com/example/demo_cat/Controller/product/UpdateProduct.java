package com.example.demo_cat.Controller.product;

import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        Product obj = model.findById(Integer.parseInt(req.getParameter("id")));
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            req.setAttribute("obj", obj);
            req.getRequestDispatcher("/admin/product/edit.jsp").forward(req, resp);
            ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        Product pr = new Product(req.getParameter("name"), req.getParameter("thumbnail"), Double.parseDouble(req.getParameter("price")), Integer.parseInt(req.getParameter("status")));
        Product obj = model.findById(Integer.parseInt(req.getParameter("id")));
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            model.update(Integer.parseInt(req.getParameter("id")), pr);
            resp.sendRedirect("/products");
            ;
        }

    }
}
