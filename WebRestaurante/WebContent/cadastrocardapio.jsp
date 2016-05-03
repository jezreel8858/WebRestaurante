<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
            <form action="cadastroCardapio" method="post">
            	<input type='hidden' name='id' value="${cardapio.id}" />
                <div class="form-group row">
                    <label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputNome" placeholder="Nome" name="nome" value="${cardapio.nome}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label" >Preço</label>
                    <div class="col-sm-4">
                        <input type="number" step="0.01" min=0 class="form-control" id="inputPreco" placeholder="0.00" name="preco" value="${cardapio.preco}"required>
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">Categoria</label>
                    <div class="col-sm-4">
                       		
                            <select id="inputReserva"  name="opcao" class="form-control" >
                            	<c:if test="${cardapio.categoria.status == false}">
                            		<option  value="${cardapio.categoria.id}" selected> ${cardapio.categoria.nome}</option> 
                            	</c:if>
	                         			<c:forEach var="categoria" items="${categorias}">
	                         				<option  value="${categoria.id}"  <c:if test="${categoria.nome == cardapio.categoria.nome}">selected </c:if>>${categoria.nome}</option>
	                         			</c:forEach>			                        
	                    	 </select>
                      
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-secondary">Cadastrar</button>
                    </div>
                </div>
            </form>
        </div>
    </section>

<%@ include file="footer.jsp" %>
<script src="js/bootstrap.min.js"></script>
</body>
</body>
</html>