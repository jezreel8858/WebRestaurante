<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap4.css">
    <link rel="stylesheet" href="css/mycss.css">

	
    <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
        $(window).scroll(function(){
            if ($(window).scrollTop() >= 80)
            {
                $("#topofixo").css({position:'fixed',left:'0',top:'0'});
            }
            else
            {
                $("#topofixo").css({position:'absolute',left:'0',top:'80px'});
            }
        });
    </script>
	<script  type="text/javascript" src="js/mascaras.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/cadastrocliente.css">
</head>
<body>
<header>
    <div id="topo">
        <span>Restaurante</span>
    </div >
    <div id="topofixo" style="height:50px">
    </div>
</header>

<section>
	<div class="centrodiv" >
        <form name="formC" class="form-inline"  id="formulario-cadastro" action="cadastroCliente" method="post" >
            <fieldset id="dados-acesso">
                <legend style="font: bold 18px/45px sans-serif;">Dados de Acesso</legend>
                <div class="form-group">
                  <label for="cLogin" class="col-sm-2 form-control-label">Login:</label>
                	<div class="col-sm-10">
                	   <input class="form-control" id="cLogin" type="text" name="tLogin" size="16"  maxlength="20" placeholder="Login" required>
               	   </div>
               	</div>
               	<div class="form-group">
                	<label for="cSenha" class="col-sm-2 form-control-label">Senha:</label> 
                	<div class="col-sm-10">  
                		<input class="form-control" id="cSenha" type="password" name="tSenha" size="16"  maxlength="8" placeholder="Password" style="margin-left: 10px;" required/>
                	</div>	
           	   </div>	
            </fieldset>
            <fieldset id="info-pessoal">
               <legend style="font: bold 18px/45px sans-serif;">Informações Pessoais</legend>
               	<div class="form-group" >
          	     	<label for="cNome" class="col-sm-2 form-control-label">Nome:</label>    
	           	     	<div class="col-sm-10"> 
	            	     <p>	<input class="form-control" id="cNome" type="text" name="tNome" size="30" maxlength="30" required> </p>
						</div>
				
					<label for="cTelefone" class="col-sm-2 form-control-label">Telefone:</label>    
						<div class="col-sm-10"> 	
						<p>	<input class="form-control" id="cTelefone" type="text" name="tTelefone" size="11" maxlength="14" placeholder="(00)00000-0000" onkeypress="return mascaraTEL(this,'(##)#####-####')" > </p>
						</div>
				</div>
				<div class="form-group" >                    
                    <label for="cEmail" class="col-sm-2 form-control-label">Email:</label> 
                    	<div class="col-sm-10"> 
                    	<p>	<input class="form-control" id="cEmail" type="email" name="tEmail" placeholder="nome@example.com" required> </p>
               	 		</div>
           	 		<label for="cData" class="col-sm-2 form-control-label">Data de Nascimento</label>  
                    	<div class="col-sm-10"> 
                        <p>	<input class="form-control" id="cData" type="date" name="tData" > </p>
               	 		</div>
                </div>
            </fieldset>
            <fieldset name="fieldEndereco" id="endereco" >
                <legend style="font: bold 18px/45px sans-serif;">Endereço</legend>
                <div class="form-group">
                     <label for="cRua" class="col-sm-2 form-control-label">Rua:</label>     
                     <div class="col-sm-10"> 
                        <p>	<input class="form-control" id="cRua" type="text" name="tRua" > </p>
               		 </div>
               
                     <label for="cNumero" class="col-sm-2 form-control-label">Número:</label>  
                     <div class="col-sm-10"> 
                     	<p>	<input class="form-control" id="cNumero" type="text" name="tNumero"> </p>
                	 </div>
                
                     <label for="cComplemento" class="col-sm-2 form-control-label">Complemento:</label>     
                     <div class="col-sm-10"> 
                     	<p>	<input class="form-control" id="cComplemento" type="text" name="tComplemento" > </p>
                	 </div>
                
                     <label for="cBairro" class="col-sm-2 form-control-label">Bairro:</label>    
                     <div class="col-sm-10"> 
                     	<p>	<input class="form-control" id="cBairro" type="text" name="tBairro" > </p>
                	 </div>
                
                     <label for="cCep" class="col-sm-2 form-control-label">CEP:</label>   
                     <div class="col-sm-10">   
                     	<p>	<input class="form-control" id="cCep" type="text" name="tCep" size="6" maxlength="9" placeholder="00000-000" onkeypress="return mascaraCEP(this,'#####-###')" > </p>
                	 </div>
               	
                     <label for="cPais" class="col-sm-2 form-control-label">País:</label>
                     <div class="col-sm-10"> 
                     	<p> <input class="form-control" id="cPais" type="text" name="tPais"> </p>
                	 </div>
               	 
	                     <label for="cEst"  class="col-sm-2 form-control-label">Estado:</label>
	                   	 <div class="col-sm-10">
	                   	 <p>
		                   	 <select id="cEst" name="tEst" class="form-control">
		                        <option value="DF" >Distrito Federal</option>
		                        <option value="MT">Mato Grosso</option>
		                        <option value="PB" selected>Paraíba</option>
		                        <option value="PE">Pernambuco</option>
		                        <option value="RJ">Rio de Janeiro</option>
		                        <option value="SP">São Paulo</option>
	                    	 </select>
                    	  </p>
	                	</div>
	                	
	                	<label for="cCidade" class="col-sm-2 form-control-label">Cidade:</label>
	                	<div class="col-sm-10"> 
	                		<input class="form-control" id="cCidade" type="text" name="tCidade" list="lisCidade">
	                		 <p>
		                		 <datalist  id="lisCidade"  >
			                            <option value="João Pessoa">João Pessoa</option>
			                            <option value="São Paulo">São Paulo</option>
		                       	 </datalist>
	                       	 </p>
	                	</div>
                	
               	</div>
                	
            </fieldset>
            		
           	<input name="bntEnviar" id="bnt-enviar"  class="btn btn-info" type="submit" value="Enviar" >
       		<a id="bnt-voltar" class="btn btn-info" role="button" href="LoginSistema" >Voltar</a>
        </form>
       </div>
</section>
<%@ include file="footer.jsp" %>
<script src="js/bootstrap.min.js"></script>     
<body>
</body>
</html>