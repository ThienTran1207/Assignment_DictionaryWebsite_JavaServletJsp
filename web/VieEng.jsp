<%-- 
    Document   : VieEng
    Created on : Mar 3, 2023, 4:29:57 PM
    Author     : Peanut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dictionary Online</title>
        <style>
            /* Set the default font family and size */
            body {
                background-image: url("448355.jpg");
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
                margin: 20px auto;
                padding: 50px;
                border: 2px solid #333;
                border-radius: 10px;
                background-color: #E0FFFF;
                max-width: 600px;
                display: flex;
                align-items: center;
            }

            #wordNotExist{
                color: red;
                font-size: 30px;
            }

            #detailError{
                color: red;
                font-size: 30px;
                padding-top: 10px;
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

            /* Style the results section */
            h2 {
                font-size: 36px;
                margin-top: 75px;
                margin-bottom: 10px;
            }

            #searchButton{
                font-size: 24px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                margin-left: 10px;
                cursor: pointer;
            }

            #detail{
                margin-top: 15px;
                font-size: 24px;
                padding: 10px 20px;
                background-color: #f44336;
                color: #fff;
                border: none;
                border-radius: 5px;
                margin-left: 10px;
                cursor: pointer;
            }
            
            .userFunction{
                margin-top: 25px;
                font-size: 24px;
                padding: 10px 20px;
                background-color: #f44336;
                color: #fff;
                border: none;
                border-radius: 5px;
                margin-left: 10px;
                cursor: pointer;
            }

            p {
                font-size: 24px;
                line-height: 1.5;
                margin: 20px 0;
            }

            table{
                margin-left: 170px;
            }

            footer{
                clear: both;
                background-color: #333;
                text-align: center;
                margin-top: 35px;
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
        <div id="sayHello">
            <h3>Welcome back <b>${u.getName()}</b>!!!</h3>
        </div>
        <main>
            <h2>Search for a Word</h2>
            <form id="form1" action="dictionary?acc=${u.getAccount()}" method="post">
                <input type="text" id="search" name="search" placeholder="Enter Vietnamese words...">
                <input type="submit" id="searchButton" name="searchSubmit2" value="Search">
            </form>
            <div id="wordNotExist">
                ${wordNotExist}
            </div>
            <h2>Result</h2>
            <form action="detail?acc=${u.getAccount()}" method="post">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="" value="Word" size="4px" readonly="readonly" />
                            </td>
                            <td>
                                <input value="${vietnameseWord}" readonly type="text" name="vie"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="" value="Meaning" size="4px" readonly="readonly" />
                            </td>
                            <td>
                                <input value="${englishWord}" readonly type="text" name="eng"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div>
                    <input class="userFunction" id="detail" type="submit" name="detail" value="Detail">
                    <input class="userFunction" type="submit" name="comment" value="Comment" id="comment">
                    <input class="userFunction" type="submit" name="history" value="Search History" id="history">
                </div>
            </form>
            <div id="detailError">
                ${detailError}
            </div>
        </main>
        <footer>
            <p>Trần Sỹ Cao Thiên</p>
            <p>HE170402 - SE1702</p>
            <p>Email: thientsche170402@fpt.edu.vn</p>
        </footer>
    </body>
</html>
