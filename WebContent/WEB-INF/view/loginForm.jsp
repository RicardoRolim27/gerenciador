<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="linkLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Usuário</h1>
	<form action="${linkLogin}" method="post">
		Usuário: <input type="text" name="usuario"></input> 
		Senha: <input type="password" name="senha"></input>
		<input type="hidden" name="executa" value="LoginController"></input> 
		<input type="submit"></input>
	</form>

</body>
</html>