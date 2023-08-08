<%-- 
    Document   : ListComment
    Created on : Mar 16, 2023, 1:02:52 PM
    Author     : Peanut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Comments</title>
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
            <h1>User Comment</h1>
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
                <td>User Full Name</td>
                <td>Comments</td>
                <td>Word User Want To Add</td>
            </tr>
            <c:forEach  items="${data}" var="item">
                <tr>
                    <td>${item.getUserName()}</td>
                    <td>${item.getComment()}</td>
                    <td>${item.getWordWantToAdd()}</td>
                    <td><a href="detail?acc=${u.getAccount()}&mod=1&userFullName=${item.getUserName()}&word="${item.getWordWantToAdd()}">Approve</a></td>
                    <td><a href="detail?acc=${u.getAccount()}&mod=2&userFullName=${item.getUserName()}&word="${item.getWordWantToAdd()}">Delete</a></td>
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
