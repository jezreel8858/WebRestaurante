<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<c:if test="${home == 'cliente'}">
<%@ include file="navcliente.jsp" %>
</c:if>
<c:if test="${home == 'funcionario'}">
<%@ include file="navfuncionario.jsp" %>
</c:if>
<c:if test="${home == 'gerente'}">
<%@ include file="navgerente.jsp" %>
</c:if>

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
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="delivery" items="${deliverys}">
	            <tr>
	                <th scope="row">${delivery.id}</th>
	                <td><fmt:formatDate type="date" value="${delivery.data}" /></td>
					<td>R$: ${delivery.total}</td>
					<td>${delivery.status}</td>
					<td><a href="DetalharDelivery?idPedido=${delivery.id}&tipo=Delivery" title="detalhar"><img src="image/detalhe.png" class="icon-tb"></a> <a href="RemoverDelivery?id=${delivery.id}" title="remover"><img src="image/delete.png" class="icon-tb"></a></td>
	
	            </tr>
	            </c:forEach>
	            </tbody>
	        </table>       
	        
		</div>
     </div>
     		<form	 style="width: 800px;position: relative;margin:0 auto;padding: 1.5rem;">
                <div class="form-group row" style="margin-top: 30px;">
                  	<div class="col-sm-offset-6 col-sm-5" >
                        <a href="javascript:history.back();" style="float:right;" class="btn btn-secondary">Voltar</a>
                    </div>   
                </div>
            </form>
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