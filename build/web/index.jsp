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
        <title>Библеотека SKTVp18WebLibrary</title>
    </head>
    <body>
        <h1>Добро пожаловать в библиотеку SKTVp18WebLibrary </h1>
        <p>${info}<br>
        <a href="showLogin">Вход</a><br>
        <a href="logout">Выход</a><br>
        <br>
        доступно пользователю<br>
        <a href="listBooks">Список книг</a><br>
        <a href="newReader">Создать читателя</a><br>
        <br>
        доступно админу<br>
        <a href="showTakeOnBook">Выдать книгу читателю</a><br>
        <a href="showReturnBook">Вернуть книгу читателю</a><br>
        <a href="newBook">Создать книгу</a><br>
        <a href="listReaders">Список читателей</a><br>
        
        
    </body>
</html>
