package com.example.demo_cat.ulti;

import com.example.demo_cat.entity.Cart;

import javax.servlet.http.HttpServletRequest;

public class CartSlaveFactory {
    private static final String CART_STRING= "cartShopping";
    public static Cart getCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute(CART_STRING);
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }
    public static void setCart(HttpServletRequest request,Cart cart){
        request.getSession().setAttribute(CART_STRING,cart);
    }
}
