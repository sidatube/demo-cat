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

public class DeleteProduct extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UltraModel<Product> model = new UltraModel<>(Product.class);
        int id =0;
        try {
            id = Integer.parseInt(req.getParameter("id"));

        }catch (Exception e){
            resp.getWriter().println("Invalid Id");
        }
        Product  obj = model.findById(id);
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            Cart cart = CartSlaveFactory.getCart(req);
            cart.removeItem(obj);
            CartSlaveFactory.setCart(req,cart);
            resp.setStatus(200);
        }    }
}
