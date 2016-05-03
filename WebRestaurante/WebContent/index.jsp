<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tela Login</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap4.css">
</head>
<body>
	 <div id="login-box">
        <div id="login-box-interno">
            <div id="login-box-interno-label">
                    <span>Controle de Restaurante</span>
            </div>
            <form class="form-horizontal" action="LoginSistema" method="post">
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Login</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" name="tLogin" placeholder="Login" required="required" >
				    </div>
				  </div>
				  <div class="form-group" >
				    <label  class="col-sm-2 control-label" style="margin-top: 15px;">Senha</label>
				    <div class="col-sm-9">
				      <input style="margin-top: 15px;" type="password" class="form-control" name="tSenha" placeholder="Senha" required="required">
				    </div>
				  </div>
								 
				  <div class="form-group" >
				    <div class="col-sm-offset-2 col-sm-10" style="margin-top: 30px;">
				    	<a class="btn btn-info" href="cadastroCliente" role="button" >Cadastra-se</a>
				      	<button type="submit" class="btn btn-info" style="margin-left: 126px;">Acessar</button>				      
				    </div>
				  </div>
			</form>
			
        </div>
        
    </div>
    <div>
			<c:if test="${mensagem != null}">	
				<div class="alert alert-danger" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}
				</div>
			</c:if>
	</div>
		
</body>
</html>