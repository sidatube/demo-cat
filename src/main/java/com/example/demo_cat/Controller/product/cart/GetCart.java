package com.example.demo_cat.Controller.product.cart;



import com.example.demo_cat.entity.Cart;
import com.example.demo_cat.ulti.CartSlaveFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = CartSlaveFactory.getCart(req);
        req.setAttribute("cart",cart);
        req.getRequestDispatcher("/admin/product/cart.jsp").forward(req, resp);
    }


}
