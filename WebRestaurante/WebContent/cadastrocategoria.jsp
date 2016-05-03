<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
            <form action="cadastroCategoria" method="post">
            	<input type='hidden' name='id' value="${categoria.id}" />
                <div class="form-group row">
                    <label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="inputNome" placeholder="Nome" name="nome" required="required" value="${categoria.nome}">
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">Status</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="inputCategoria" name="status">
                            <option value="0" <c:if test="${categoria.status == true}">Selected</c:if>
                            >Ativo</option>
                            <option value="1" <c:if test="${categoria.status == false}">Selected</c:if>
                            >Desativado</option>
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