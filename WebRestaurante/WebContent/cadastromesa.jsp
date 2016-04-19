<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.br.model.Mesa"%>

<%@ include file="header.jsp" %>
	<% 
    	Mesa mesa = (Mesa) request.getAttribute("mesa");
     
    %>
    <section>
        <div class="centrodiv">
            <form action="cadastroMesa" method="post">
            	<input type='hidden' name='id' value="<%=mesa == null ? "" : mesa.getId()%>" />
                <div class="form-group row">
                    <label for="inputNome" class="col-sm-2 form-control-label">Numero</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputNome" placeholder="Numero" name="numero" required="required" value="<%=mesa == null ? "" : mesa.getNumero()%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label">Capacidade</label>
                    <div class="col-sm-4">
                        <input type="number" min=0 class="form-control" id="inputPreco" placeholder="00" name="capacidade" required="required" value="<%=mesa == null ? "" : mesa.getCapacidade()%>">
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">De reserva?</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="inputCategoria" name="reserva">
                            <option value="0" <% 
                            						if(mesa != null )
                            							if(mesa.isPerReserva())
                            								out.write("selected");
                            						
                            				  %>
                            >Sim</option>
                            <option value="1" <% 
                            						if(mesa != null )
                            							if(!mesa.isPerReserva())
                            								out.write("selected");
                            				  %>
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


<script src="js/bootstrap.min.js"></script>
</body>
</body>
</html>