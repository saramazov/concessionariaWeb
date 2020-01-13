<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="concessionaria.model.Dipendente" %>
<%@ page import="concessionaria.model.Menu" %>
<%@ page import="concessionaria.model.MenuItem" %>
<%@ page import="concessionaria.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accesso riuscito</title>
</head>
<body>

<%
LoginDTO dto = (LoginDTO) request.getAttribute(LoginDTO.NAME);

if(!dto.success()){
	%>
	<div>
	Dipendente NON trovato
	</div>
	<% 
}
else{
	
	Menu menu = dto.getMenu();

%>

<table>
<%
	for(MenuItem x : menu){
	%>
	<tr><th><a href=<%=x.getLink() %>>  <%=x.getDescrizione() %>  </a></th></tr>
	<%
	}
}

%>
</table>

</body>
</html>