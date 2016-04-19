<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, com.br.model.Mesa" %>	
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv">
	 		<table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Numero</th>
	                <th>Capacidade</th>
	                <th>Resevavel</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            <%
			   		List<Mesa> mesas = (List<Mesa>) request.getAttribute("mesas"); 
				%>
				<%for (Mesa mesa : mesas) {%>
	            <tr>
	                <th scope="row"><%=mesa.getNumero()%></th>
	                <td><%=mesa.getCapacidade()%></td>
					<td><%=mesa.isPerReserva() ? "Sim" : "Não" %></td>
					<td><a href="cadastroMesa?id=<%=mesa.getId()%>"><img src="image/edit.png" class="icon-tb"></a> <a href="removerMesa?id=<%=mesa.getId()%>"><img src="image/delete.png" class="icon-tb"></a></td>
	
	            </tr>
	           	<%}%>
	            </tbody>
	        </table>
	        
	        

	     
	     	
	     </div>
	     	<% 
				String mensagem = (String) request.getAttribute("mensagem");
				if(mensagem != null){
			%>		
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					<%=mensagem%>.
				</div>
			<% 		
				}
		 	%>
	</section>
	
<script src="js/bootstrap.min.js"></script>
</body>
</html>