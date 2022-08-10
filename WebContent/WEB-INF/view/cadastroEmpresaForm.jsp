<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="linkCadastroEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro Empresa</h1>
	<form action="${linkCadastroEmpresa}" method="post">
		Nome: <input type="text" name="nomeEmpresa"></input> 
		Data Abertura: <input type="text" name="data"></input>
		<input type="hidden" name="executa" value="NovaEmpresaController"></input> 
		<input type="submit"></input>
	</form>

</body>
</html>