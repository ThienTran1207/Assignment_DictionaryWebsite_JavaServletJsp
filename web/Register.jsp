<%-- 
    Document   : Register
    Created on : Mar 3, 2023, 4:23:39 PM
    Author     : Peanut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
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

            form {
                margin: 100px auto 0;
                width: 400px;
                background-color: #E0FFFF;
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
            }
            
            #registerError{
                color: red;
                font-size: 30px;
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
                width: 100%;
                background-color: red;
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
                margin-top: 140px;
            }

            footer p{
                padding: 1px 1px;
                color:#fff
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Dictionary Online</h1>
            <nav>
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                </ul>
            </nav>
        </header>

        <form action="login" method="post">
            <h2>Fill in the Registration Form</h2>
            <b><label for="username">Username</label></b>
            <input placeholder="Write here..." type="text" id="username" name="account" required>
            <b><label for="password">Password</label></b>
            <input placeholder="Write here..." type="password" id="password" name="pass" required>
            <b><label for="password">Confirm Password</label></b>
            <input placeholder="Write here..." type="password" id="password" name="repass" required>
            <b><label for="email">Email</label></b>
            <input placeholder="Write here..." type="email" id="email" name="email" required>
            <b><label for="fullname">Full name</label></b>
            <input placeholder="Write here..." type="text" id="fullname" name="fullname" required>
            <div class="button">
                <input type="submit" class="btn" value="Submit" name="submitRegister">
            </div>
        </form>
        <div id="registerError">
            ${registerError}
            ${passwordError}
        </div>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
