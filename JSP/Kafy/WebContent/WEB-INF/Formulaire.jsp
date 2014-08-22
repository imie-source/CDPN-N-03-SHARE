<%@page import="metier.Personnage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./styles/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h3 class="titrePage">PAGE FORMULAIRE</h3>

	<form action="servletFormulaire" method="post">
	<label>Nom du personnage :</label>
	<%if("Creer".equals(request.getAttribute("action"))) { %>
			<input name="nomPerso" >
			<input name="action" type="submit" value="Creer">
	<% }else{ %>
		<% Personnage lePerso = (Personnage) request.getAttribute("lePerso"); %>
		<input name="nomPerso" placeholder="<%= lePerso.getNom() %>" >
		<input type="hidden" name="id" value="<%= lePerso.getId() %>">
		<input name="action" type="submit" value="Modifier">
	<% } %>
	</form>
</body>
</html>