/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.DictionaryController.wordNotExist;
import Model.Dictionary;
import Model.SearchHistory;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Peanut
 */
public class DictionaryControllerForAdmin extends HttpServlet {

    public static final String wordNotExist = "Word does not exist!!";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        if (sess.getAttribute("account") == null) {
            resp.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("You have not logged in yet. Please go to Home.jsp to Log in");
                return;
            }
        }

        if (req.getParameter("searchSubmit") != null) {
            String englishWord = req.getParameter("search");

            Dictionary d = new Dictionary(englishWord, "");
            boolean check = d.checkEnglishWord();
            if (check) {
                String vietnameseWord = d.getResult();
                req.setAttribute("englishWord", englishWord);
                req.setAttribute("vietnameseWord", vietnameseWord);
                String username2 = req.getParameter("acc");

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                SearchHistory s = new SearchHistory(username2, englishWord, dtf.format(now));
                s.addHistory();
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
                req.setAttribute("wordNotExist", wordNotExist);
                req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
            }
        }

        if (req.getParameter("searchSubmit2") != null) {
            String vietnameseWord = req.getParameter("search");

            Dictionary d = new Dictionary("", vietnameseWord);
            boolean check = d.checkVietnameseWord();
            if (check) {
                String englishWord = d.getResult2();
                req.setAttribute("englishWord", englishWord);
                req.setAttribute("vietnameseWord", vietnameseWord);

                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
            } else {
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("wordNotExist", wordNotExist);
                req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        if (sess.getAttribute("account") == null) {
            resp.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("You have not logged in yet. Please go to Home.jsp to Log in");
                return;
            }
        }

        if (req.getParameter("mod").equals("1")) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);
            req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
        }

        if (req.getParameter("mod").equals("2")) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);
            req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
        }
    }

}
