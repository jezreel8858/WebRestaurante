<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="header.jsp" %>
	
    <section>
        <div class="centrodiv">
            <table class="table table-sm">
	            <thead>
	            <tr>	            
	                <th>Produto</th>
	                <th>Quantidade</th>
	                <th>Total</th>	               
	            </tr>
	            </thead>
	            <tbody>
		            <tr>
		            	<td><c:out value="${item.cardapio.nome}" /></td>
		            	<td><c:out value="${item.qtd}"/></td>
		            	<td><c:out value="${item.qtd*item.cardapio.preco}"/></td>		                             
		            </tr>
	            </tbody>
	        </table>               	
        </div>
       
         <form	 style="width: 800px;position: relative;margin:0 auto;padding: 1.5rem;">
                <div class="form-group row" style="margin-top: 30px;">
                
                	
                  	<div class="col-sm-offset-7 col-sm-5" >
                        <a href="listarDelivery" style="float:right;" class="btn btn-secondary">Voltar</a>
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