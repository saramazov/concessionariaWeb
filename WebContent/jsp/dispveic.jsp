<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="concessionaria.service.*" %>
<%@ page import="concessionaria.model.Veicolo" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Display Veicoli</title>
</head>

<body>
    <%
VeicoloDTO dto = (VeicoloDTO) request.getAttribute(VeicoloDTO.NAME);
if(!dto.success()){
	%>
    <div>
        VEICOLO NON TROVATO
    </div>
    <% 
}
else{
%>

    <table>
        <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Targa</th>
            <th>Produttore</th>
            <th>Prezzo</th>
            <th>Modello</th>
            <th>Alimentazione</th>
            <th>Colore</th>
        </tr>
        <%
    Integer cont = 1;
        
	for(Veicolo v : dto){
		
	%>
        <tr>
            <form action="https://www.youtube.com/watch?v=VjN5lEQkhPg"
            	  method="post">
                <td id=<%="id"+cont%>><%=v.getId() %></td>
                <td id=<%="tipo"+cont%>><%=v.getTipo()%></td>
                <td id=<%="targa"+cont%>><%=v.getTarga()%></td>
                <td id=<%="produttore"+cont%>><%=v.getProduttore()%></td>
                <td id=<%="prezzo"+cont%>><%=v.getPrezzo()%></td>
                <td id=<%="modello"+cont%>><%=v.getModello()%></td>
                <td id=<%="alimentazione"+cont%>><%=v.getAlimentazione()%></td>
                <td id=<%="colore"+cont%>><%=v.getColore()%></td>
                <td><input type="submit" value="Compra" 
                		id=<%="form"+cont%>
            	  		name=<%="form"+cont%>></td>
                <td><input type="submit" value="Modifica"
                		id=<%="form"+cont%>
            	  		name=<%="form"+cont%>></td>
            </form>

        </tr>
        <%
        cont++;
	}
}

%>
    </table>
</body>

</html>
