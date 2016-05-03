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
       		<div class="form-group" >
			    <div  style="margin-top: 30px;">
			    	<label class="col-sm-offset-0 col-sm-3">Numero: ${numero}</label>
        			<label class="col-sm-offset-0 col-sm-3">Status: ${status}</label>			      
			    </div>
		  	</div>
        	
            <table class="table table-sm">
	            <thead>
	            <tr>	            
	                <th>Produto</th>
	                <th>Quantidade</th>
	                <th>Total</th>	               
	            </tr>
	            </thead>
	            <tbody>
	             <c:forEach var="item" items="${itens}">
		            <tr>		           
		            	<td><c:out value="${item.cardapio.nome}" /></td>
		            	<td><c:out value="${item.qtd}"/></td>
		            	<td><c:out value="R$: ${item.qtd*item.cardapio.preco}"/></td>		            		                             
		            </tr>
		            </c:forEach>
	            </tbody>
	        </table>               	
        </div>       
         	<form	 style="width: 800px;position: relative;margin:0 auto;padding: 1.5rem;">
                <div class="form-group row" style="margin-top: 30px;">
                	                	
                  	<div class="col-sm-offset-1 col-sm-10" >                  	 
	                  	<c:if test="${home == 'funcionario' || home == 'gerente'}">	   
	                  		<a href="AlterarPedido?idPedido=${numero}&status=Atendido&tipo=${tipo}" style="margin-left: 0px;" class="btn btn-secondary">Atender</a>  
	                  		<a href="AlterarPedido?idPedido=${numero}&status=Cancelado&tipo=${tipo}" style="margin-left: 80px;" class="btn btn-secondary">Cancelar</a>  
	                  		<a href="javascript:history.back();" style="margin-left: 100px;margin-right: auto;float: right;" class="btn btn-secondary">Voltar</a>                   		
	                  	</c:if>	
	                  	<c:if test="${home != 'funcionario' && home != 'gerente'}">
	                  		<a href="javascript:history.back();" style="float: right;" class="btn btn-secondary">Voltar</a>                   		
	                  	</c:if>	
	                  		                      
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
</body>
</html>