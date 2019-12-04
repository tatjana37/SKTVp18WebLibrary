<%-- 
    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг в библиотеке</title>
    </head>
    <body>
        <h1>В нашей библиотеке имеются следующие книги:</h1>
        <ol>
           <c:forEach var="book" items="${listBooks}">
            <li>${book.title}. ${book.author}. ${book.year}</li>
        </c:forEach>
        </ol>
       
    </body>
</html>
