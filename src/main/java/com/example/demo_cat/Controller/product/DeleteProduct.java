package com.example.demo_cat.Controller.product;

import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UltraModel<Product> model = new UltraModel<>(Product.class);
        Product obj = model.findById(Integer.parseInt(req.getParameter("id")));
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            model.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("/products");
        }

    }
}
