/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Comment;
import Model.Dictionary;
import Model.SearchHistory;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Peanut
 */
public class DetailController extends HttpServlet {

    public static final String detailError = "No word to show detail!!";
    public static final String deleteError = "No word to delete!!";
    public static final String deleteSuccess = "Word deleted successfully!!";
    public static final String wordExist = "Word already exist!!";
    public static final String insertSuccess = "Word inserted successfully!!";
    public static final String commentSuccess = "Comment posted successfully!";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("detail") != null) {
            if (req.getParameter("eng").isEmpty()) {
                if (req.getParameter("acc").equals("admin")) {
                    String username = req.getParameter("acc");
                    User u = new User(username);
                    User u2 = u.getUserStayLogin();
                    req.setAttribute("u", u2);
                    req.setAttribute("detailError", detailError);
                    req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
                }
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("detailError", detailError);
                req.getRequestDispatcher("EngVie.jsp").forward(req, resp);
            }
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String word = req.getParameter("eng");
            Dictionary d = new Dictionary(word, "");
            d.getDetail();
            req.setAttribute("d", d);
            req.getRequestDispatcher("DetailWord.jsp").forward(req, resp);
        }

        if (req.getParameter("detail2") != null) {
            if (req.getParameter("eng").isEmpty()) {
                if (req.getParameter("acc").equals("admin")) {
                    String username = req.getParameter("acc");
                    User u = new User(username);
                    User u2 = u.getUserStayLogin();
                    req.setAttribute("u", u2);
                    req.setAttribute("detailError", detailError);
                    req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
                }
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("detailError", detailError);
                req.getRequestDispatcher("VieEng.jsp").forward(req, resp);
            }
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String word = req.getParameter("eng");
            Dictionary d = new Dictionary(word, "");
            d.getDetail();
            req.setAttribute("d", d);
            req.getRequestDispatcher("DetailWord.jsp").forward(req, resp);
        }

        if (req.getParameter("delete1") != null) {
            if (req.getParameter("eng").isEmpty()) {
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("deleteError", deleteError);
                req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
            }
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String word = req.getParameter("eng");
            Dictionary d = new Dictionary(word, "");
            d.deleteWord();
            req.setAttribute("deleteSuccess", deleteSuccess);
            req.getRequestDispatcher("EngVieForAdmin.jsp").forward(req, resp);
        }

        if (req.getParameter("delete2") != null) {
            if (req.getParameter("eng").isEmpty()) {
                String username = req.getParameter("acc");
                User u = new User(username);
                User u2 = u.getUserStayLogin();
                req.setAttribute("u", u2);
                req.setAttribute("deleteError", deleteError);
                req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
            }
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String word = req.getParameter("eng");
            Dictionary d = new Dictionary(word, "");
            d.deleteWord();
            req.setAttribute("deleteSuccess", deleteSuccess);
            req.getRequestDispatcher("VieEngForAdmin.jsp").forward(req, resp);
        }

        if (req.getParameter("insert") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);
            req.getRequestDispatcher("InsertWord.jsp").forward(req, resp);
        }

        if (req.getParameter("insertSubmit") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String englishWord = req.getParameter("english");
            String vietnameseWord = req.getParameter("vietnamese");
            String example = req.getParameter("example");

            Dictionary d = new Dictionary(englishWord, vietnameseWord, example);
            boolean checkWordExist = d.checkWordExist();
            if (checkWordExist) {
                req.setAttribute("wordExist", wordExist);
                req.getRequestDispatcher("InsertWord.jsp").forward(req, resp);
            } else {
                d.insertWord();
                req.setAttribute("insertSuccess", insertSuccess);
                req.getRequestDispatcher("InsertWord.jsp").forward(req, resp);
            }
        }

        if (req.getParameter("comment") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);
            req.getRequestDispatcher("Comment.jsp").forward(req, resp);
        }

        if (req.getParameter("commentSubmit") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String name = req.getParameter("userName");
            String comment = req.getParameter("commentArea");
            String wordWantToAdd = req.getParameter("wordWantToAdd");
            Comment c = new Comment(name, comment, wordWantToAdd);
            c.addComment();
            req.setAttribute("commentSuccess", commentSuccess);
            req.getRequestDispatcher("Comment.jsp").forward(req, resp);
        }

        if (req.getParameter("showComment") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            Comment c = new Comment();
            ArrayList<Comment> data = c.getListComment();
            req.setAttribute("data", data);
            req.getRequestDispatcher("ListComment.jsp").forward(req, resp);
        }

        if (req.getParameter("history") != null) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            SearchHistory s = new SearchHistory(username);
            ArrayList<SearchHistory> data = s.getListHistory();
            req.setAttribute("data", data);
            req.getRequestDispatcher("SearchHistory.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mod").equals("1")) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String userFullName = req.getParameter("userFullName");
            String word3 = req.getParameter("word");
            Comment c = new Comment(userFullName);
            String word = c.getUserWord();
            req.setAttribute("word2", word);
            req.getRequestDispatcher("InsertWord.jsp").forward(req, resp);
        }

        if (req.getParameter("mod").equals("2")) {
            String username = req.getParameter("acc");
            User u = new User(username);
            User u2 = u.getUserStayLogin();
            req.setAttribute("u", u2);

            String userFullName = req.getParameter("userFullName");
            String word3 = req.getParameter("word");
            System.out.println(word3);
            Comment c = new Comment(userFullName, word3);
            c.deleteComment();
            ArrayList<Comment> data2 = c.getListComment();
            req.setAttribute("data", data2);
            req.getRequestDispatcher("ListComment.jsp").forward(req, resp);
        }

        if (req.getParameter("mod").equals("3")) {
            String englishWord = req.getParameter("searchedWord");

            Dictionary d = new Dictionary(englishWord, "");
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
            req.getRequestDispatcher("EngVie.jsp").forward(req, resp);
        }
    }

}
