<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv1">
			<form action="listarPedidos">
				<div class="form-group row">
				
						<label for="inputNumero" class="col-sm-2 form-control-label">Numero do Pedido</label>
	                    <div class="col-sm-1">
	                        <input type="number" class="form-control" id="inputNumero" placeholder="000" name="numero">
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Tipo</label>
	                   	<div class="col-sm-2" >
	                         <select id="inputStatus"  name="tipo" class="form-control" >
	                         			<option  value="Todos" selected="selected" >Todos</option>
			                        	<option  value="Delivery" >Delivery</option>
			                        	<option  value="Tradicional" >Tradicional</option>
	                    	 </select>
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Status</label>
	                   	<div class="col-sm-2" >
	                         <select id="inputStatus"  name="status" class="form-control" >
	                         			<option  value="Todos" selected="selected" >Todos</option>
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
	                <th>Cliente</th>
	                <th>Atendido Por</th>
	                <th>Tipo</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="pedidos" items="${pedidos}">
	            <tr>
	                <th scope="row">${pedidos.id}</th>
	                <td><fmt:formatDate type="date" value="${pedidos.data}" /></td>
					<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${pedidos.total}" /></td>
					<td>${pedidos.status}</td>
					
					<td>
						<c:if test="${pedidos.funcionario == null }">
							<c:out value="${pedidos.cliente.nome}"></c:out>
						</c:if>
						<c:if test="${pedidos.funcionario != null }">
							<c:out value=""></c:out>
						</c:if>
					</td>					
					<td>${pedidos.funcionario.nome}</td>
					<td>
						<c:if test="${pedidos.funcionario == null }">
							<c:out value="Delivery"></c:out>
						</c:if>
						<c:if test="${pedidos.funcionario != null }">
							<c:out value="Tradicional"></c:out>
						</c:if>
					</td>
					<td>
						<a href="detalharDeliveryCliente?id=${pedidos.id}" title="detalhar"><img src="image/detalhe.png" class="icon-tb"></a> 
						<a href="#" title="alterar"><img src="image/edit.png" class="icon-tb"></a>
					</td>
	
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