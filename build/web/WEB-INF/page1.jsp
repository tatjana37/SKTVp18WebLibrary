<%-- 
    Document   : page1
    Created on : 04.11.2019, 18:03:11
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page1</title>
    </head>
    <body>
        <h1>Privet Page1</h1>
        ${info}
        <form action="login" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Go">
        </form>
    </body>
</html>
