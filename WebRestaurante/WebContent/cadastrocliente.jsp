<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<script  type="text/javascript" src="js/mascaras.js" ></script>
	<div class="centrodiv">
        <form name="formC"  id="formulario-cadastro" action="cadastroCliente" method="post" >
            <fieldset id="dados-acesso">
                <legend style="font: bold 18px/45px sans-serif;">Dados de Acesso</legend>
                <div class="input-group">
                	<p>     <label for="cLogin">Login:</label>   <input class="form-control" id="cLogin" type="text" name="tLogin" size="16"  maxlength="20" placeholder="Login" ></p>
                	<p>     <label for="cSenha">Senha:</label>   <input class="form-control" id="cSenha" type="password" name="tSenha" size="16"  maxlength="8" placeholder="Password" /></p>
           	   </div>	
            </fieldset>
            <fieldset id="info-pessoal">
               <legend style="font: bold 18px/45px sans-serif;">Informações Pessoais</legend>
               	<div class="input-group">
                <p>     <label for="cNome">Nome:</label>    <input class="form-control" id="cNome" type="text" name="tNome" size="30" maxlength="40" ></p>
                <p>     <label for="cTelefone">Telefone:</label>    <input class="form-control" id="cTelefone" type="text" name="tTelefone" size="11" maxlength="14" placeholder="(00)00000-0000" onkeypress="return mascaraTEL(this,'(##)#####-####')" ></p>
                <p>     <label for="cData">Data de Nascimento</label>      <input class="form-control" id="cData" type="date" name="tData" ></p>
                <p>     <label for="cEmail">Email:</label>   <input class="form-control" id="cEmail" type="email" name="tEmail" placeholder="nome@example.com" ></p>
                </div>
            </fieldset>
            <fieldset name="fieldEndereco" id="endereco">
                <legend style="font: bold 18px/45px sans-serif;">Endereço</legend>
                <div class="input-group">
                <p>     <label for="cRua">Rua:</label>     <input class="form-control" id="cRua" type="text" name="tRua" ></p>
                <p>     <label for="cNumero">Número:</label>      <input class="form-control" id="cNumero" type="text" name="tNumero"></p>
                <p>     <label for="cComplemento">Complemento:</label>     <input class="form-control" id="cComplemento" type="text" name="tComplemento" ></p>
                <p>     <label for="cBairro">Bairro:</label>      <input class="form-control" id="cBairro" type="text" name="tBairro" ></p>
                <p>     <label for="cCep">CEP:</label>     <input class="form-control" id="cCep" type="text" name="tCep" size="6" maxlength="9" placeholder="00000-000" onkeypress="return mascaraCEP(this,'#####-###')" ></p>
                <p>     <label for="cPais">País:</label>    <input class="form-control" id="cPais" type="text" name="tPais"> </p>
                <p>     <label for="cEst" style="margin-top: 20px;">Estado:</label>
                    <select id="cEst" name="tEst">
                        <option value="DF" >Distrito Federal</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="PB" selected>Paraíba</option>
                        <option value="PE">Pernambuco</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="SP">São Paulo</option>
                    </select>
                </p>
                <p><label for="cCidade">Cidade:</label> <input class="form-control" id="cCidade" type="text" name="tCidade" list="lisCidade">
                        <datalist  id="lisCidade" >
                            <option value="João Pessoa">João Pessoa</option>
                            <option value="São Paulo">São Paulo</option>
                        </datalist>
                </p>
                </div>
            </fieldset>
             <div class="input-group">
            <input name="bntCadastrar" id="bnt-enviar"  class="btn btn-default" type="submit" value="Enviar" >
            <input name="bntVoltar" id="bnt-voltar"  class="btn btn-default" type="button" value="Voltar" >
            </div>
        </form>
       </div>
       <script src="js/bootstrap.min.js"></script>
       
<body>
</body>
</html>