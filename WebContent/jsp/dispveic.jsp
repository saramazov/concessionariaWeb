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
String ruolo = "A";
String readonly="";
if(!ruolo.equals("A")){
	readonly="readonly=\"readonly\"";
}
VeicoloDTO dto = (VeicoloDTO) request.getAttribute(VeicoloDTO.NAME);
VeicoloVendutoDTO dtoSold = (VeicoloVendutoDTO) request.getAttribute(VeicoloVendutoDTO.NAME);
if(!dto.success()){
	%>
    <div>
        VEICOLO NON TROVATO
    </div>
    <% 
}
else{
%>

<% if(dtoSold.success()) {%><table>
 <tr> 
   <td> <%} %><table>
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
            <form id="F<%=cont%>" action="../concessionariaWeb/compra" method="post">
             <td><input type="text" readonly="readonly" id=<%="id"+cont%> name="id" value="<%=v.getId() %>"></td>
             <td><input type="text" readonly="readonly" tipo=<%="tipo"+cont%> name="tipo" value="<%=v.getTipo() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="targa"+cont%> name="targa" value="<%=v.getTarga() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="produttore"+cont%> name="produttore" value="<%=v.getProduttore() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="prezzo"+cont%> name="prezzo" value="<%=v.getPrezzo() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="modello"+cont%> name="modello" value="<%=v.getModello() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="alimentazione"+cont%> name="alimentazione" value="<%=v.getAlimentazione() %>"></td>
             <td><input type="text" <%=readonly%> id=<%="colore"+cont%> name="colore" value="<%=v.getColore() %>"></td>
             <td><button onclick="return confermaCompra(<%=cont%>)">Compra</td>
             <td><button>Modifica</td>
            </form>

        </tr>
        <%
        cont++;
	}
}

%>
    </table> <%if(dtoSold.success()) {%></td>
    <td>Acquisto confermato</td></tr>
    </table> <%} %>
    <script>
    	function confermaCompra(cont){
    		if(confirm("Confermi l'acquisto?")){
    			document.getElementById("F"+cont).submit();
    		}
    		return false;
    	}
    
    </script>
</body>

</html>
