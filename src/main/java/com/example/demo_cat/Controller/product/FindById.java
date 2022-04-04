package com.example.demo_cat.Controller.product;

import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

public class FindById extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        Product obj = model.findById(Integer.parseInt(req.getParameter("id")));
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            HttpSession session = req.getSession();
            HashSet<Product> recentView = (HashSet<Product>) session.getAttribute("recentView");
            if (recentView == null) {
                recentView = new HashSet<>();
            }
            recentView.add(obj);
            session.setAttribute("recentView", recentView);

            if (session.getAttribute("AddSuccess")!=null) {
                req.setAttribute("AddSuccess", session.getAttribute("AddSuccess"));
                session.removeAttribute("AddSuccess");
            }

            req.setAttribute("obj", obj);
            req.getRequestDispatcher("/admin/product/detail.jsp").forward(req, resp);
        }
    }

}
