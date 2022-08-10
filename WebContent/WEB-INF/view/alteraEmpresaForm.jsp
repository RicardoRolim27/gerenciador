<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controller" var="linkAlteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Altera Empresa</title>
</head>
<body>
	<h1>Alterar Empresa</h1>
	<form action="${linkAlteraEmpresa}" method="post">
		Nome: <input type="text" name="nomeEmpresa" value="${empresa.name}"></input> 
		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"></input>
		<input type="hidden" name="id" value="${empresa.id}">
		<input type="hidden" name="executa" value="AlteraEmpresaController"> 
		<input type="submit"></input>
	</form>

</body>
</html>