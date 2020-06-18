<%-- 
    Document   : showReturnBook
    Created on : Dec 4, 2019, 5:39:25 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Возврат выданной книги в библиотеку</title>
    </head>
    <body>
        <h1>Возврат книги</h1>
        <p>${info}</p>
        <a href="index.jsp">Главная страница</a><br>
        <form action="returnOnBook" method="POST">
            Список выданных книг:<br>
            <c:if test="${listHistories == null}">
                <p>Нет выданных читателям книг!</p>
            </c:if>
            <c:if test="${listHistories != null}">
                <select name="historyId"  size="3">
                    <c:forEach var="history" items="${listHistories}" varStatus="status">
                        <option value="${history.id}">
                            ${status.index+1}. ${history.reader.name} ${history.reader.lastname} читает книгу "${history.book.title}"
                        </option>
                    </c:forEach>
                </select>
            </c:if>
            <br>
            <input type="submit" value="Вернуть книгу">
        </form>
    </body>
</html>
