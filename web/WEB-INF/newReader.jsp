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
        <form action="addReader" method="POST">
            Имя:<br>
            <input type="text" size="40" name="name"><br>
            Фамилия:<br>
            <input type="text" size="40"  name="lastname"><br>
            электронная почта:<br>
            <input type="text" size="40" name="email"><br>
            <br>
            <input type="submit" value="Добавить читателя"><br>
            
        </form>
    </body>
</html>
