<%-- 
    Document   : newbook
    Created on : 18.11.2019, 19:21:04
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая книга</title>
    </head>
    <body>
        <h1>Создать книгу</h1>
        <form action="addBook" method="POST">
            Название книги:<br>
            <input type="text" size="40" name="title"><br>
            Автор книги:<br>
            <input type="text" size="40"  name="author"><br>
            Год издания книги:<br>
            <input type="text" size="40" name="year"><br>
            колличество:<br>
            <input type="text" size="40" name="quentity"><br>
            <br>
            <input type="submit" value="Добавить книгу"><br>
        </form>
    </body>
</html>
