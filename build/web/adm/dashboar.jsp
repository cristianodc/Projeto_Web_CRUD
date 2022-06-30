<%-- 
    Document   : dashboar
    Created on : 30 de jun de 2022, 19:06:45
    Author     : Cristiano
--%>
<%@page import="br.com.projetoloja.model.Usuario"%>
<%
    if(session.getAttribute("usuario") == null)
        {
            //response.sendRedirect("index.jsp");
            RequestDispatcher despachador = request.getRequestDispatcher("index.jsp");
            despachador.forward(request, response);
        }
   Usuario usu =(Usuario)  session.getAttribute("usuario");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= usu.getNome()%>!</h1>
    </body>
</html>
