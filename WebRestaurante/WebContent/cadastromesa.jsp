<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
            <form action="cadastroMesa" method="post">
            	<input type='hidden' name='id' value="${mesa.id}" />
                <div class="form-group row">
                    <label for="inputNumero" class="col-sm-2 form-control-label">Numero</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" id="inputNumero" placeholder="000" name="numero" required="required" value="${mesa.numero}">
                    </div>
                    <label for="inputDescricao" class="col-sm-2 form-control-label">Descricao</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="inputDescricao" placeholder="Mesa" name="descricao" required="required" value="${mesa.descricao}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label">Capacidade</label>
                    <div class="col-sm-4">
                        <input type="number" min=0 class="form-control" id="inputPreco" placeholder="00" name="capacidade" required="required" value="${mesa.capacidade}">
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">De reserva?</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="inputCategoria" name="reserva">
                            <option value="0" <c:if test="${mesa.perReserva == true}">Selected</c:if>
                            >Sim</option>
                            <option value="1" <c:if test="${mesa.perReserva == false}">Selected</c:if>
                            >Não</option>
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