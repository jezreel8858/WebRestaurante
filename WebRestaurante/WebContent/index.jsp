<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
				      <input type="text" class="form-control" name="login" placeholder="Login" required="required" >
				    </div>
				  </div>
				  <div class="form-group" >
				    <label  class="col-sm-2 control-label" style="margin-top: 15px;">Senha</label>
				    <div class="col-sm-9">
				      <input style="margin-top: 15px;" type="password" class="form-control" name="senha" placeholder="Senha" required="required">
				    </div>
				  </div>
				  <div>
				  
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-12">
				      <div class="checkbox">
				        <label>
				          <input type="checkbox" style="margin-top: 15px;"> Lembra de mim
				        </label>
				      </div>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				    	<a class="btn btn-info" href="cadastroCliente" role="button" >Cadastra-se</a>
				      	<button type="submit" class="btn btn-info" style="margin-left: 126px;">Acessar</button>
				      
				    </div>
				  </div>
			</form>
        </div>
    </div>

</body>
</html>