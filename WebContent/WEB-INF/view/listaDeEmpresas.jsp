<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, alura.com.gerenciador.entities.Empresa"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Usuario Logado: ${usuarioLogado.login } <c:import url="logout-parcial.jsp"></c:import>
	<br/>	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.name}- <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/controller?executa=MostraEmpresaController&id=${empresa.id}">editar</a> 
				<a href="/gerenciador/controller?executa=RemoveEmpresaController&id=${empresa.id}">deletar</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>