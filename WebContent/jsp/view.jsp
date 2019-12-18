<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Privilegi</title>
</head>
<body>
<%if(request.getAttribute("dipendente")!=null){ %>
Sei un <%=request.getAttribute("ruolo")%>
<%} else {%>Dipendente non esistente!<%}%>
</body>
</html>