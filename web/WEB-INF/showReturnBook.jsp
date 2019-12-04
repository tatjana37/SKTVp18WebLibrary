<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Список выданных книг</h1>
        <p>${info}</p>
        <a href="index.jsp">Главна страница</a><br>
        <form action="returnOnBook" method="POST">
            <select name="historyId" size="3">
                <c:forEach var="history" items="${listHistories}" varStatus="status">
                    <option value="${history.id}">
                        ${status.index+1}. ${history.reader.name} ${history.reader.lastname} читает книгу ${history.book.title}
                    </option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Вернуть книгу">
         </form>
            
            
            
        
    </body>
</html>
