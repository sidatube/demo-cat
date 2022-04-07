package com.example.demo_cat.Controller.Account;

import com.example.demo_cat.entity.Account;
import com.example.demo_cat.model.AccountModel;
import com.example.demo_cat.ulti.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginController extends HttpServlet {
    private AccountModel model = new AccountModel();
    private static final  int MAX_COUNT = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account  account =model.findAccountByUsername(username);
        if (account==null){
            resp.getWriter().println("Invalid information!");
        }
        if (account.getStatus()==2){
            if (LocalDateTime.now().compareTo(account.getLockTime())>0){
                account.setStatus(1);
                account.setFailureCount(0);
                model.updateLock(account.getUsername(),account);
            }else {
                resp.getWriter().println("Account has been locked, please try again after "+account.getLockTime());
                return;
            }
        }
        if(PasswordHandler.checkPassword(password,account.getPasswordHash(),account.getSalt())){
            resp.getWriter().println("Login success");
        }else
        {
            account.setFailureCount(account.getFailureCount()+1);
            if (account.getFailureCount()==MAX_COUNT){
                account.setStatus(2);
                account.setLockTime(LocalDateTime.now().plusMinutes(5));
                model.updateLock(account.getUsername(),account);
            }
            resp.getWriter().println("Login Fail!!!!!!!!!!!");
        }
    }
}
