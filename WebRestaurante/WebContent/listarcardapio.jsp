<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%@ include file="header.jsp" %>

	<section>
		<div class="centrodiv">
		<form action="listarCardapio">
				<div class="form-group row">

						<label for="inputNome" class="col-sm-1 form-control-label">Nome</label>
	                    <div class="col-sm-3">
	                        <input type="text" class="form-control" id="inputNome" name="filtroNome">
	                    </div>
	                    <label for="inputCategoria" class="col-sm-2 form-control-label">Categoria</label>
	                   	<div class="col-sm-3" >
	                         <select id="inputCategoria"  name="filtroCategoria" class="form-control" >
	                         			<option  value="0" >Todos</option>
	                         			<c:forEach var="categoria" items="${categorias}">
	                         				<option  value="${categoria.id }" >${categoria.nome}</option>
	                         			</c:forEach>			                        
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
	                <th>Codigo</th>
	                <th>Descrição</th>
	                <th>Preço</th>
	                <th>Status</th>
	                <th>Categoria</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="cardapio" items="${cardapios}" >
	            <tr>
	                <th scope="row">${cardapio.id}</th>
	                <td>${cardapio.nome}</td>
	                <td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${cardapio.preco}"/></td>
	                <td>
	                	<c:if test="${cardapio.status == true}">Ativo</c:if>
	                	<c:if test="${cardapio.status == false}">Inativo</c:if>
	                </td>
					<td>${cardapio.categoria.nome}</td>
					<td>
						<a href="cadastroCardapio?id=${cardapio.id}"><img src="image/edit.png" class="icon-tb"></a> 
						<a href="removerCardapio?id=${cardapio.id}"><img src="image/switch.png" class="icon-tb"></a>
					</td>
	
	            </tr>
	           	</c:forEach>
	            </tbody>
	        </table>
   	
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