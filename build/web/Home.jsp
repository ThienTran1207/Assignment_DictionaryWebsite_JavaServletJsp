<%-- 
    Document   : Home
    Created on : Mar 3, 2023, 4:57:55 PM
    Author     : Peanut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dictionary Online</title>
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
                background-image: url("wallpaperflare.com_wallpaper (8).jpg");
            }

            form {
                margin: 150px auto 0;
                width: 400px;
                background-color: #E0FFFF;
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
            }

            #loginError{
                color: red;
                font-size: 30px;
                text-align: center;
            }

            input[type="text"], input[type="password"] {
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
                margin-top: 265px;
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

            .btn-container input.login {
                background-color: #4CAF50;
                color: white;
            }

            .btn-container input.register {
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
        </header>

        <form action="login" method="post">
            <h2>Welcome!!!</h2>
            <b><label for="username">Username</label></b>
            <input type="text" id="username" name="username" placeholder="Write here...">
            <b><label for="password">Password</label></b>
            <input type="password" id="password" name="password" placeholder="Write here...">
            <div class="btn-container">
                <input class="login" type="submit" name="login" value="Log in">
                <input class="register" type="submit" name="register" value="Sign up">
            </div>
        </form>
        <div id="loginError">
            ${loginError}
            ${registerSuccess}
            ${updateSuccess}
        </div>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
