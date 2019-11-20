<%-- 
    Document   : index
    Created on : 04.11.2019, 18:03:32
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Привет, группа SKTVp18</h1>
        ${info}<br>
        <p>создана книга: ${book.title}</p>
        <p>Изучаем как работает приложение</p>
        <a href="page1">Page1</a><br>
        <a href="page2?name=Ivan&lastname=Ivanov">Page2</a><br>
        <a href="page3">Page3</a><br>
        <a href="page4">Page4</a><br>
        <a href="newBook">Создать книгу</a><br>
        <a href="newReader">Создать читателя</a>
       
    </body>
</html>
