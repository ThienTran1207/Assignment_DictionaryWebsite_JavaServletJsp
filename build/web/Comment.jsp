<%-- 
    Document   : Comment
    Created on : Mar 16, 2023, 10:36:59 AM
    Author     : Peanut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment and Report to Admin</title>
        <style>
            header {
                background-color: #333;
                color: #fff;
                padding: 10px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            /* Style the website title */
            h1 {
                margin: 0;
            }

            /* Style the navigation menu */
            nav ul {
                list-style: none;
                margin: 0;
                padding: 0;
                display: flex;
            }

            nav li {
                margin-right: 10px;
            }

            nav a {
                color: #fff;
                text-decoration: none;
                padding: 5px 10px;
                border: 1px solid #fff;
                border-radius: 3px;
            }

            footer{
                clear: both;
                background-color: #333;
                text-align: center;
                margin-top: 650px;
            }

            footer p{
                padding: 1px 1px;
                color:#fff
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Vietnamese-English</h1>
            <nav>
                <ul>
                    <li><a href="Home.jsp">Log out</a></li>
                    <li><a href="dictionary?mod=1&acc=${u.getAccount()}">English-Vietnamese</a></li>
                    <li><a href="dictionary?mod=2&acc=${u.getAccount()}">Vietnamese-English</a></li>
                    <li><a href="update?mod=1&username=${u.getAccount()}">Update Profile</a></li>
                    <li><a href="update?mod=2&username=${u.getAccount()}">Delete Account</a></li>
                </ul>
            </nav>
        </header>
        <form action="detail?acc=${u.getAccount()}" method="post">
            <input type="text" name="userName" value="${u.getName()}" readonly> <input type="text" name="commentArea" placeholder="Comments here"> 
            <input type="text" name="wordWantToAdd" placeholder="Enter word you want to add here.."><br>
            ${commentSuccess}<br><br>
            <input type="submit" name="commentSubmit" value="Post">
        </form>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
