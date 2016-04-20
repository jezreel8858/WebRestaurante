<%@page import="java.util.ArrayList"%>
<%@page import="javax.smartcardio.Card"%>
<%@page import="com.br.services.CardapioService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.br.model.Delivery,java.util.List,com.br.model.Cardapio,com.br.model.ItemCardapio"%>

<%@ include file="header.jsp" %>
	
	
    <section>
    	<input style="display: none" id="tdNome" >
    	<input style="display: none" id="tdQtd" >
    	<input style="display: none" id="tdPreco" >
        <div class="centrodiv">
            <form action="cadastroDelivery" method="post">
            	<input type='hidden' name='id'  />
                <div class="form-group row">
                    <label for="inputNome" style="width: 80px;margin-left: 4px;" class="col-sm-1 form-control-label">Produto</label>
                 	<div class="col-sm-2">
                         <select id="cCardapio" style="width: 110px;" name="cardapio" class="form-control" >
                       		 	<%
			   						List<Cardapio> cardapios = (List<Cardapio>) CardapioService.listar();                    		
								%>
								<% for (Cardapio cardapio : cardapios){ %>
		                        	<option  value="<%= cardapio.getId()%>" ><%= cardapio.getNome()%></option>
		                        <%}%>
                    	 </select>
                    </div>
                    <label for="inputQuantidade"  style="width: 110px;margin-left: 20px;" class="col-sm-2 form-control-label">Quantidade</label>
                    <div class="col-sm-2">
                        <input type="number" min=0  class="form-control" id="inputQuantidade" placeholder="00" name="quantidade" required="required" >
                    </div>
                  	<div class="col-sm-offset-0 col-sm-5" style="width: 80px;margin-left: 60px;">
                        <button type="submit" class="btn btn-secondary" >Adicionar Item</button>
                    </div>
                </div>
                <table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Produto</th>
	                <th>Quantidade</th>
	                <th>Total</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

	            <tr>
	            	<td></td>
	            	<td></td>
	            	<td></td>
	               <td><a href="cadastroDelivery?id="><img src="image/edit.png" class="icon-tb"></a> <a href="removerDelivery?id="><img src="image/delete.png" class="icon-tb"></a></td>
	               
	            </tr>
	            </tbody>
	        </table>
                <div class="form-group row">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-secondary">Finalizar</button>
                    </div>
                </div>
            </form>
        </div>
    </section>


<script src="js/bootstrap.min.js"></script>
</body>
</body>
</html>