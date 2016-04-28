<!DOCTYPE html>
<html lang="pt-br">
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

</head>
<body>
<header>
    <div id="topo">
        <span>Restaurante</span>
    </div >
    <nav class="navbar" id="topofixo">
        <ul class="nav navbar-nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="LoginSistema">Home</a>
            </li>       
           
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Delivery
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="cadastroDelivery">Fazer Pedido</a>
                    <a class="dropdown-item" href="listarDelivery">Meus Pedidos</a>
                </div>
            </li>
            <li class="nav-item pull-xs-right">
	        	<a class="nav-link" href="logout">Logout</a>
	        </li>
            <li class="nav-item pull-xs-right">
                <a class="nav-link" href="cadastroCliente">Meu Cadastro</a>
            </li>          
            
        </ul>
       
	        
      
    </nav>

</header>