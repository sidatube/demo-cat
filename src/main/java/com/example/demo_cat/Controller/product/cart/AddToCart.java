package com.example.demo_cat.Controller.product.cart;

import com.example.demo_cat.entity.Cart;
import com.example.demo_cat.entity.CartItem;
import com.example.demo_cat.entity.Product;
import com.example.demo_cat.model.UltraModel;
import com.example.demo_cat.ulti.CartSlaveFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class AddToCart extends HttpServlet {
    private UltraModel<Product> model;

    public AddToCart() {
        model = new UltraModel<>(Product.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId")) | 0;
        int qty = Integer.parseInt(req.getParameter("qty")) | 0;
        if (productId <= 0 || qty <= 0) {
            resp.setStatus(404);
            resp.getWriter().println("Invalid qty or product id.");
            return;
        }
        Product obj = model.findById(productId);
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Product not found!");
            return;
        }

        Cart cart = CartSlaveFactory.getCart(req);
        cart.addItem(obj, qty);
        CartSlaveFactory.setCart(req, cart);
        req.getSession().setAttribute("AddSuccess", "Add Success");
        resp.sendRedirect("/products/detail?id="+productId);

    }
}
