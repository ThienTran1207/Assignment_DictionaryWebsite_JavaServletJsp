<%-- 
    Document   : SearchHistory
    Created on : Mar 16, 2023, 2:48:15 PM
    Author     : Peanut
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search History</title>
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
            <h1>Search Hítory</h1>
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
        <table border="1">
            <tr>
                <td>Username</td>
                <td>SearchedWord</td>
                <td>Date and Time</td>
            </tr>
            <c:forEach  items="${data}" var="item">
                <tr>
                    <td>${item.getUsername()}</td>
                    <td><a href="detail?acc=${u.getAccount()}&mod=3&searchedWord=${item.getSearchedWord()}">${item.getSearchedWord()}</a></td>
                    <td>${item.getDateAndTime()}</td>
                </tr>
            </c:forEach>
        </table>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
