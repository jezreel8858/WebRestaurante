<%@page import="java.util.ArrayList"%>
<%@page import="javax.smartcardio.Card"%>
<%@page import="com.br.services.CardapioService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.br.model.Delivery,java.util.List,com.br.model.Cardapio,com.br.model.ItemCardapio"%>

<%@ include file="header.jsp" %>
	
	<% List<ItemCardapio> lista = (ArrayList<ItemCardapio>)request.getSession().getAttribute("itemCardapio"); %>
	
    <section>
    	<input style="display: none" id="tdNome" >
    	<input style="display: none" id="tdQtd" >
    	<input style="display: none" id="tdPreco" >
        <div class="centrodiv">
        	<% List<Cardapio> cardapios ; %>
            <form action="AdicionarItemCardapioDelivery" method="post">
            	<input type='hidden' name='id'  />
                <div class="form-group row">
                    <label for="inputNome"  class="col-sm-2	 form-control-label">Produto</label>
                 	<div class="col-sm-3" >
                         <select id="cCardapio"  name="cardapio" class="form-control" >
                       		 	<%
			   						cardapios = (List<Cardapio>) CardapioService.listar();                    		
								%>
								<% for (Cardapio cardapio : cardapios){ %>
		                        	<option  value="<%= cardapio.getNome()%>" ><%= cardapio.getNome()%></option>
		                        	 
		                        <%}%>
                    	 </select>
                    </div>
                    <label for="inputQuantidade"   class="col-sm-2 form-control-label">Quantidade</label>
                    <div class="col-sm-2">
                        <input type="number" min=0  class="form-control" id="inputQuantidade" placeholder="00" name="quantidade" required="required" >
                    </div>
                  	<div class="col-sm-offset-0 col-sm-3" >
                        <button style="margin-left: 30px;" type="submit" class="btn btn-secondary">Adicionar Item</button>
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
			<% 
				if(lista!=null){					
					for (ItemCardapio item : lista){				
			%>
	            <tr>
	            	<td><%= item.getCardapio().getNome()%></td>
	            	<td><%= item.getQtd()%></td>
	            	<td><%= item.getQtd()*item.getCardapio().getPreco()%></td>
	                <td><a href="RemoverItemCardapioDelivery?id=<%=item.getIdC()%>"><img src="image/delete.png" class="icon-tb"></a></td>	               
	            </tr>
	            <%	}}%>
	            </tbody>
	        </table>
                <div class="form-group row">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button style="margin-left: 85%;margin-top: 30px;" type="submit" class="btn btn-secondary">Finalizar</button>
                    </div>
                </div>
            </form>
        </div>
    </section>


<script src="js/bootstrap.min.js"></script>
</body>
</body>
</html>