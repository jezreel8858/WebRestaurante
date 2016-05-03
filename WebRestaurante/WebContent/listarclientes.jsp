<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv">
			<form action="listarClientes">
				<div class="form-group row">
				
						<label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
	                    <div class="col-sm-2">
	                        <input type="text" class="form-control" id="inputNome" placeholder="Nome" name="fnome">
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
		                <th>CEP</th>
		                <th>Rua</th>
		                <th>Numero</th>
		                <th>Ações</th>
		            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="cliente" items="${clientes}">
	            <tr>
	                <th scope="row">${cliente.nome}</th>
	                <td><fmt:formatNumber type="number" value="${cliente.endereco.cep}" pattern="#####-###" /></td>
					<td>${cliente.endereco.logradouro}</td>
					<td>${cliente.endereco.numero}</td>
					<td>
						<a href="listarPedidosCliente?id=${cliente.id}" title="detalhar"><img src="image/detalhe.png" class="icon-tb"></a> 	
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