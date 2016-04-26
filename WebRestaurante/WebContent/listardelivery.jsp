<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv">
			<form action="listarDelivery">
				<div class="form-group row">
				
						<label for="inputNumero" class="col-sm-3 form-control-label">Numero do Pedido</label>
	                    <div class="col-sm-2">
	                        <input type="number" class="form-control" id="inputNumero" placeholder="000" name="numero">
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Status</label>
	                   	<div class="col-sm-3" >
	                         <select id="inputStatus"  name="cardapio" class="form-control" >
			                        	<option  value="Pendente" >Pendente</option>
			                        	<option  value="Atendido" >Atendido</option>
			                        	<option  value="Cancelado" >Cancelado</option>
	                    	 </select>
	                    </div>
	                    <div class="col-sm-offset-0 col-sm-2" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Pesquisar</button>
	                    </div>
				</div>
			</form>
			<div class="form-group row">
	 		<table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Numero</th>
	                <th>Data</th>
	                <th>Total</th>
	                <th>Status</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="delivery" items="${deliverys}">
	            <tr>
	                <th scope="row">${delivery.id}</th>
	                <td><fmt:formatDate type="date" value="${delivery.data}" /></td>
					<td>${delivery.total}</td>
					<td>${delivery.status}</td>
					<td><a href="cadastroMesa?id=${delivery.id}"><img src="image/edit.png" class="icon-tb"></a> <a href="removerMesa?id=${delivery.id}"><img src="image/delete.png" class="icon-tb"></a></td>
	
	            </tr>
	            </c:forEach>
	            </tbody>
	        </table>
	        
	        
		</div>
	     
	     	
	     </div>
	     	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
			</c:if>	
	</section>
<%@ include file="footer.jsp" %>
<script src="js/bootstrap.min.js"></script>
</body>
</html>