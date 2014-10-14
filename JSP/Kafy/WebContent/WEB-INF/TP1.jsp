<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="metier.Personnage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Les persos</title>
</head>
<link href="./styles/style.css" rel="stylesheet" type="text/css"/>
<body>

<%@ include file="header.jsp" %>
	
	<h3 class="titrePage">PAGE TP1</h3>
	
	<div class="maxSize">
		<form action="servletFormulaire" method="get" >
			<input name="action" type="submit" value="Creer">
		</form>
	</div>
	<div class="maxSize">
		<table class="tableauPersos">
			<tr>
				<td>Nom</td>
				<td>Date de Création</td>
				<td>Vie</td>
				<td>Exp</td>
				<td>Niveau</td>
				<td>Action</td>
			</tr>
			<c:if test="${listePersonnages !=null}">
			<c:forEach var="p" items="${listePersonnages}" varStatus="loopStatus">
			<tr>
				<td>
					<c:out value="${p.nom}"/>
				</td>
				<td>
					<%-- <%
						DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
							DateFormat.MEDIUM,
							DateFormat.MEDIUM);
					%>
					<%= mediumDateFormat.format(p.getDateCreation()) %> --%>
					<c:out value="${p.dateCreation}"/>
				</td>
				<td>
					<c:out value="${p.vie}"/>
				</td>
				<td>
					<c:out value="${p.exp}"/>
				</td>
				<td>
					<c:out value="${p.niveau}"/>
				</td>
				<td>
					<c:choose>
						<c:when test="${login}">
							<form action="selecPersoServlet" method="post" >
						</c:when>
						<c:otherwise>
							<form action="servletTP1" method="post" >
					    </c:otherwise>
					</c:choose>
					
					<input type="hidden" name="id" value="${p.id}"/><br>
						<c:choose>
							<c:when test="${login}">
								<input name="action" type="submit" value="Choisir">
							</c:when>
							<c:otherwise>
								<input name="action" type="submit" value="Supprimer">
								<input name="action" type="submit" value="Afficher">
						    </c:otherwise>
						</c:choose>
					</form>
				</td>
			</tr>
			</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>