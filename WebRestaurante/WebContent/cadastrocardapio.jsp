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
            <form action="cadastroCardapio" method="post">
                <div class="form-group row">
                    <label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputNome" placeholder="Nome" name="nome">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label">Preço</label>
                    <div class="col-sm-4">
                        <input type="number" step="any" min=0 class="form-control" id="inputPreco" placeholder="0.00" name="preco">
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">Categoria</label>
                    <div class="col-sm-4">
                       
                            <select id="inputReserva"  name="opcao" class="form-control" >
	                         			<c:forEach var="categoria" items="${categorias}">
	                         				<option  value="${categoria.id}" >${categoria.nome}</option>
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