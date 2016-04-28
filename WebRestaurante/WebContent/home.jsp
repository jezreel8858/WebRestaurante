<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${home == 'cliente'}">
<%@ include file="navcliente.jsp" %>
</c:if>
<c:if test="${home == 'funcionario'}">
<%@ include file="navfuncionario.jsp" %>
</c:if>
<c:if test="${home == 'gerente'}">
<%@ include file="navgerente.jsp" %>
</c:if>
	<section>


	</section>
<%@ include file="footer.jsp" %>
<script src="js/bootstrap.min.js"></script>
</body>
</body>
</html>	