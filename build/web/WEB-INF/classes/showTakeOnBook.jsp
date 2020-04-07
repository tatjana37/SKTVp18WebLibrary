<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выдача книги читателю</title>
    </head>
    <body>
        <p>${info}</p>
    <from action="takeOnBook" method="POST">
        <h1>Список пользователей :</h1>
        <select name="readerId">
            <c:forEach var="reader" items="${listReaders}"varStatus="status">
                <option value="${reader.id}">
                    ${status.index+1}) ${reader.name}. ${reader.lastname}
                </option>
            </c:forEach>
        </select>
        <br>
        <h2>Список книг:</h2>
        <select name="bookId">
            <c:forEach var="book" items="${listBooks}" varStatus="status">
                <option value="${book.id}">
                    ${status.index+1}) ${book.title}. ${book.author}. ${book.year}
                </option>
            </c:forEach>
        </select>
        <input type="submit"  value="Выдать книгу">
     </from>
    </body>
</html>
