<%-- 
    Document   : login
    Created on : Jan 25, 2008, 3:27:12 PM
    Author     : kyuuzou
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requisições - Autenticação</title>
        <style  TYPE="text/css">
            <!--
            body  {
                font: 100% Verdana, Arial, Helvetica, sans-serif;
                background: #666666;
                margin: 0; /* it's good practice to zero the margin and padding of the body element to account for differing browser defaults */
                padding: 0;
                text-align: center; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
                color: #000000;
            }
            
            h1 {
                margin: 0; 
                padding: 10px 0;  
            }
            
            #container { 
                width: 780px;  /* using 20px less than a full 800px width allows for browser chrome and avoids a horizontal scroll bar */
                background: #FFFFFF;
                margin: 0 auto; /* the auto margins (in conjunction with a width) center the page */
                border: 1px solid #000000;
                text-align: center; /* this overrides the text-align: center on the body element. */
            } 
            
            .header{
                background: #DDDDDD; 
                padding: 0 10px 0 20px;
            } 
            
            a {
                color: #CC3300;
                /*text-decoration:underline;*/
            }
            
            a:hover {
                color: #FF3300;
                text-decoration:none;
            }
            -->
        </style>
    </head>
    <body>
        <br />
            <div id="container">
                <div class="header">
                    <br />
                    <h2>Requisições</h2>
                    <br />
                </div>
                <br />
                <form action="j_security_check" method="POST">
                    Utilizador:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="j_username">
                    <br />
                    <br />
                    Palavra-passe:&nbsp;<input type="password" name="j_password">
                    <br />
                    <br />
                    <input type="submit" value="Entrar">
                </form>
                <br />
            </div>
    </body>
</html>
