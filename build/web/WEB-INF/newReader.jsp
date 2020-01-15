<%-- 
    Document   : newReader
    Created on : 18.11.2019, 22:34:20
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новый читатель</title>
    </head>
    <body>
        <h1>Создать читателя</h1>
        <a href="index.jsp">Главна страница</a><br>
        <br>
        <form action="addReader" method="POST">
            Имя:<br>
            <input type="text" size="40" name="name"><br>
            Фамилия:<br>
            <input type="text" size="40"  name="lastname"><br>
            электронная почта:<br>
            <input type="text" size="40" name="email"><br>
            <br>
            Логин: <input type="text" size="40" name="login"><br>
            <br>
            Пароль: <input type="password" size="40" name="password"><br>
            <br>
            <input type="submit" value="Создать пользователя"><br>
            
        </form>
    </body>
</html>
