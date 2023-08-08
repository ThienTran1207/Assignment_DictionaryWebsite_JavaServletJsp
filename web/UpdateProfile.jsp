<%-- 
    Document   : UpdateProfile
    Created on : Mar 3, 2023, 8:14:25 PM
    Author     : Peanut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
        <style>
            header {
                background-color: #333;
                color: #fff;
                padding: 10px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

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

            body {
                background-image: url("wallpaperflare.com_wallpaper (10).jpg");
            }

            form {
                margin: 150px auto 0;
                width: 400px;
                background-color: #E0FFFF;
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
            }

            form {
                margin: 100px auto 0;
                width: 400px;
                background-color: #E0FFFF;
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
            }

            #updateError{
                color: white;
                text-align: center;
            }

            input[type="text"], input[type="password"], input[type="email"] {
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 100%;
                box-sizing: border-box;
            }

            input[type="submit"] {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            footer{
                clear: both;
                background-color: #333;
                text-align: center;
                margin-top: 120px;
            }

            footer p{
                padding: 1px 1px;
                color:#fff
            }

            .btn-container {
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }

            .btn-container input {
                margin: 0 10px;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .btn-container input.update {
                background-color: #4CAF50;
                color: white;
            }

            .btn-container input.cancel {
                background-color: #2196F3;
                color: white;
            }

            .btn-container input:hover {
                opacity: 0.8;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Dictionary Online</h1>
            <nav>
                <ul>
                    <li><a href="Home.jsp">Log out</a></li>
                </ul>
            </nav>
        </header>

        <form action="update?acc=${u.getAccount()}" method="post">
            <h2>Update your information</h2>
            <b><label for="username">Username</label></b>
            <input type="text" id="username" name="account3" readonly value="${u.getAccount()}">
            <b><label for="password">Password</label></b>
            <input type="text" id="password" name="pass3" value="${u.getPassword()}">
            <b><label for="password">Confirm Password</label></b>
            <input type="text" id="password" name="repass3" value="${u.getPassword()}">
            <b><label for="email">Email</label></b>
            <input type="email" id="email" name="email3" value="${u.getEmail()}">
            <b><label for="fullname">Full name</label></b>
            <input type="text" id="fullname" name="fullname3" value="${u.getName()}">
            <div class="btn-container">
                <input class="update" type="submit" name="update" value="Update">
                <input class="cancel" type="submit" name="cancel" value="Cancel">
            </div>
        </form>
        <div id="updateError">
            <h3>${updateError}</h3>
        </div>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
