<%-- 
    Document   : showTakeOnBook
    Created on : Nov 25, 2019, 7:05:49 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выдать книгу читателю</title>
    </head>
    <body>
        <h1>Выдать книгу</h1>
        <p>${info}</p>
         <a href="index.jsp">Главная страница</a><br>
        <form action="takeOnBook" method="POST">
            <h2>Список книг:</h2>
            <select name="bookId">
                <c:forEach var="book" items="${listBooks}" varStatus="status">
                    <option value="${book.id}">
                        ${status.index+1}) ${book.title}. ${book.author}. ${book.year}
                    </option>
                </c:forEach>
            </select>

            <h2>Список читателей:</h2> 
            <select name="readerId">
                <c:forEach var="reader" items="${listReaders}" varStatus="status">
                    <option value="${reader.id}">
                     ${status.index+1}) ${reader.name}. ${reader.lastname}. ${reader.email}
                    </option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Выдать книгу">
        </form>  
    </body>
</html>
