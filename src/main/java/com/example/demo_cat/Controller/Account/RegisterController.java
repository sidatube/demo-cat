package com.example.demo_cat.Controller.Account;

import com.example.demo_cat.entity.Account;
import com.example.demo_cat.model.UltraModel;
import com.example.demo_cat.ulti.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class RegisterController extends HttpServlet {
    private UltraModel<Account> model = new UltraModel<>(Account.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("password-repeat");
//        Validate
        Account acc = new Account();
        acc.setUsername(username);
        acc.setSalt(PasswordHandler.generateSalt());
        String passHash = PasswordHandler.getMd5(password,acc.getSalt());
        acc.setPasswordHash(passHash);
        acc.setCreatedAt(Calendar.getInstance().getTime().toString());
        if (model.save(acc)){
            resp.getWriter().println("Create Success");
        }
        else {
            resp.getWriter().println("Error, please try again late!");
        }
    }
}
