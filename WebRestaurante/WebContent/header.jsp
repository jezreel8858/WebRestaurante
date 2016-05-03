<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap4.css">
    <link rel="stylesheet" href="css/mycss.css">
    <link rel="stylesheet" type="text/css" href="css/cadastrocliente.css">

	 <script  type="text/javascript" src="js/mascaras.js" ></script>
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
    <c:if test="${home == 'cliente'}">
	<%@ include file="navcliente.jsp" %>
	</c:if>
	<c:if test="${home == 'funcionario'}">
	<%@ include file="navfuncionario.jsp" %>
	</c:if>
	<c:if test="${home == 'gerente'}">
	<%@ include file="navgerente.jsp" %>
	</c:if>
	<c:if test="${usuario == null}">
    <div id="topo">
        <span>Restaurante</span>
    </div >
    <div id="topofixo" style="height:50px">
    </div>
    </c:if>
</header>