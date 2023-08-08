/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Peanut
 */
public class LoginController extends HttpServlet {
    public static final String loginError = "Account does not exist!! Please Login again!";
    public static final String registerError = "Username already exist!! Please sign up another username!";
    public static final String passwordError = "The password you confirmed is not equal to the password! Reenter password to sign up!";
    public static final String registerSuccess = "Account register successfully!";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("login") != null) {
            String account = req.getParameter("username");
            String password = req.getParameter("password");

            User u = new User(account, password);
            boolean check = u.checkUser();

            if (check) {
                HttpSession session = req.getSession();
                session.setAttribute("account", u);

                if (account.equals("admin")) {
                    String name = u.getNameByAccount();
                    req.setAttribute("name", name);
                    User u2 = u.getUser();
                    req.setAttribute("u", u2);
                    req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
                } else {
                    String name = u.getNameByAccount();
                    req.setAttribute("name", name);
                    User u2 = u.getUser();
                    req.setAttribute("u", u2);
                    req.getRequestDispatcher("EngVie.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("loginError", loginError);
                req.getRequestDispatcher("Home.jsp").forward(req, resp);
            }
        }

        if (req.getParameter("register") != null) {
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }

        if (req.getParameter("submitRegister") != null) {
            String account = req.getParameter("account");
            String password = req.getParameter("pass");
            String repassword = req.getParameter("repass");
            String email = req.getParameter("email");
            String fullname = req.getParameter("fullname");
            if (!password.equals(repassword)) {
                req.setAttribute("passwordError", passwordError);
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
            } else {
                User u = new User(account, password, email, fullname);
                boolean checkRegister = u.checkUserExist();
                if (checkRegister) {
                    req.setAttribute("registerError", registerError);
                    req.getRequestDispatcher("Register.jsp").forward(req, resp);
                } else {
                    u.add();
                    req.setAttribute("registerSuccess", registerSuccess);
                    req.getRequestDispatcher("Home.jsp").forward(req, resp);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Home.jsp");
    }

}
