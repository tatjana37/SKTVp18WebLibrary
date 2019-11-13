<%-- 
    Document   : page4
    Created on : 31.10.2019, 18:31:37
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page4</title>
    </head>
    <body>
        
        <h1>Привет от Page4</h1>
         ${info}
         <form action="hello" method="POST">
             Имя: <input type="text" name="name"><br>
             Фамилия: <input type="text" name="lastname"><br>
             <input type="submit" value="Go">
         </form> 
    </body>
</html>
