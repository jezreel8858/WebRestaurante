<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
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
	            
				<c:forEach var="mesa" items="${mesas}" >
	            <tr>
	                <th scope="row">${mesa.numero}</th>
	                <td>${mesa.capacidade}</td>
	             
					<td>
					<c:if test="${mesa.perReserva == true}">
							Sim
					</c:if>
					<c:if test="${mesa.perReserva == false}">
							Não
					</c:if>
					</td>
					<td>
						<a href="cadastroMesa?id=${mesa.id}"><img src="image/edit.png" class="icon-tb"></a> 
						<a href="removerMesa?id=${mesa.id}"><img src="image/delete.png" class="icon-tb"></a>
					</td>
	
	            </tr>
	           	</c:forEach>
	            </tbody>
	        </table>
	        
	        

	     
	     	
	     </div>
	     	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
			</c:if>
	</section>
	
<script src="js/bootstrap.min.js"></script>

</body>
</html>