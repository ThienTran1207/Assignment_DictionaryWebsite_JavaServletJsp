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
import java.io.IOException;

/**
 *
 * @author Peanut
 */
public class UpdateProfile extends HttpServlet {
    public static final String updateError = "The information cannot be empty!!";
    public static final String updateSuccess = "Account updated successfully!! Re-login to continue!";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("update") != null) {
            String username = req.getParameter("account3");
            String password = req.getParameter("pass3");
            String repassword = req.getParameter("repass3");
            String email = req.getParameter("email3");
            String fullname = req.getParameter("fullname3");

            if (password.isEmpty() || email.isEmpty() || fullname.isEmpty() || !password.equals(repassword)) {
                String account = req.getParameter("acc");
                User u = new User(account);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("updateError", updateError);
                req.getRequestDispatcher("UpdateProfile.jsp").forward(req, resp);
            } else {
                User u = new User(username, password, email, fullname);
                u.update();
                req.setAttribute("updateSuccess", updateSuccess);
                req.getRequestDispatcher("Home.jsp").forward(req, resp);
            }
        }

        if (req.getParameter("cancel") != null) {
            if (req.getParameter("acc").equals("admin")) {
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
            } else {
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.getRequestDispatcher("EngVie.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mod").equals("1")) {
            String username = req.getParameter("username");
            User u = new User(username);
            u.getUpdateProfile();
            req.setAttribute("u", u);
            req.getRequestDispatcher("UpdateProfile.jsp").forward(req, resp);
        }

        if (req.getParameter("mod").equals("2")) {
            String username = req.getParameter("username");
            User u = new User(username);
            u.deleteAccount();
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        }
    }

}
