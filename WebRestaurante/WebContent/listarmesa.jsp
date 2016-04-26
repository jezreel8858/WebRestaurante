<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv">
		<form action="listarMesa">
				<div class="form-group row">

						<label for="inputNome" class="col-sm-1 form-control-label">Nome</label>
	                    <div class="col-sm-3">
	                        <input type="text" class="form-control" id="inputNome" name="nome">
	                    </div>
	                    <label for="inputReserva" class="col-sm-2 form-control-label">De reserva?</label>
	                   	<div class="col-sm-3" >
	                         <select id="inputReserva"  name="opcao" class="form-control" >
	                         			<option  value="-1" >Todas</option>
			                        	<option  value="0" >Sim</option>
			                        	<option  value="1" >Não</option>
			                        
	                    	 </select>
	                    </div>
	                    <div class="col-sm-offset-0 col-sm-2" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Pesquisar</button>
	                    </div>
	              
				</div>
			</form>
	 		<table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Numero</th>
	                <th>Descrição</th>
	                <th>Capacidade</th>
	                <th>Resevavel</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="mesa" items="${mesas}" >
	            <tr>
	                <th scope="row">${mesa.numero}</th>
	                <td>${mesa.descricao}</td>
	                <td>${mesa.capacidade}</td>
	             	
					<td>
					<c:if test="${mesa.perReserva eq true}">
							Sim
					</c:if>
					<c:if test="${mesa.perReserva eq false}">
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
	
<%@ include file="footer.jsp" %>
<script src="js/bootstrap.min.js"></script>
</body>
</html>