<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv">
			<form action="ListarPedidos">
				<div class="form-group row">
				
						<label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
	                    <div class="col-sm-1">
	                        <input type="text" class="form-control" id="inputNome" placeholder="000" name="fNome">
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
		                <th>Nome</th>
		                <th>CPF</th>
		                <th>Cargo</th>
		                <th>Salário</th>
		                <th>Açoes</th>
		            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="funcionario" items="${funcionarios}">
	            <tr>
	                <th scope="row">${funcionario.nome}</th>
	                <td><fmt:formatNumber type="number" value="${funcionario.cpf}" pattern="###.###.###-##" /></td>
					<td>${funcionario.cargo.nome}</td>
					<td>${funcionario.salario}</td>
					<td>
						<a href="DetalharDeliveryCliente?id=${pedidos.id}" title="detalhar"><img src="image/detalhe.png" class="icon-tb"></a> 
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