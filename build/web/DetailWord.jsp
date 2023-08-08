<%-- 
    Document   : DetailWord
    Created on : Mar 4, 2023, 5:12:16 PM
    Author     : Peanut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Words in Detail</title>
        <style>
            /* Set the default font family and size */
            body {
                background-image: url("sunset.jpg");
                font-family: Arial, sans-serif;
                font-size: 16px;
            }

            /* Style the header */
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

            #sayHello{
                margin-top: 20px;
                margin-left: 30px;
                width: 20%;
            }

            #sayHello h3{
                margin: 0;
                color: white;
            }

            /* Style the search form */
            /* Center the main content */
            main {
                margin: 0 auto;
                max-width: 800px;
                text-align: center;
            }

            /* Square the search form */
            #form1 {
                margin: 240px auto;
                padding: 50px;
                border: 2px solid #333;
                border-radius: 10px;
                background-color: #E0FFFF;
                max-width: 450px;
                max-height: 600px;
                display: flex;
                align-items: center;
            }

            label {
                font-size: 24px;
                margin-bottom: 20px;
            }

            input[type="text"] {
                font-size: 24px;
                padding: 10px;
                width: 100%;
                box-sizing: border-box;
            }

            input[type="submit"] {
                font-size: 24px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                margin-left: 10px;
                cursor: pointer;
            }

            /* Style the results section */
            h2 {
                font-size: 36px;
                margin-top: 75px;
                margin-bottom: 10px;
                color: white;
            }

            p {
                font-size: 24px;
                line-height: 1.5;
                margin: 20px 0;
            }
            
            #detail{
                margin-top: 25px;
            }

            footer{
                clear: both;
                background-color: #333;
                text-align: center;
                margin-top: 293px;
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
                    <li><a href="Home.jsp">Log out</a></li>
                    <li><a href="dictionary?mod=1&acc=${u.getAccount()}">English-Vietnamese</a></li>
                    <li><a href="dictionary?mod=2&acc=${u.getAccount()}">Vietnamese-English</a></li>
                    <li><a href="update?mod=1&username=${u.getAccount()}">Update Profile</a></li>
                    <li><a href="update?mod=2&username=${u.getAccount()}">Delete Account</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <form id="form1" action="dictionary" method="post">
                <table border="1">
                    <tr>
                        <td>English Word</td>
                        <td>Vietnamese Word</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>${d.getEnglishWord()}</td>
                        <td>${d.getVietnameseWord()}</td>
                        <td>${d.getExample()}</td>
                    </tr>
                </table>
            </form>
        </main>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
