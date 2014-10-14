<%@page import="java.util.ArrayList, org.imie.tperroin.model.Personnage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="Header.jsp" />

	<div>
		<c:if test="${personnageConnected != null}">
			<form action="PersonnageController" method="POST">
				<input type="submit" name="add" value="Add a perso" />
			</form>
		</c:if>
	</div>
	<div class="table">
		<table>
			<tr>
				<th>Name</th>
				<th>HP</th>
				<th>Level</th>
				<th>Birthday</th>
				<th>image</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="perso" items="${persoList}" varStatus="loopStatus">
				<tr>
					<td><c:out value="${perso.name}" /></td>
					<td><c:out value="${perso.hp}" /></td>
					<td><c:out value="${perso.level}" /></td>
					<td><fmt:formatDate type="date" value="${perso.formatDate}" /></td>
					<td><c:out value="${perso.image}" /></td>
					<td><c:if test="${personnageConnected == null}">
							<form action="PersonnageChoiceController" method="POST">
								<input type="submit" name="choice" value="Choose" /> <input
									type="hidden" name="persoId"
									value="<c:out value="${perso.id}" />" />
							</form>
						</c:if> <c:if test="${personnageConnected != null}">
							<form action="PersonnageController" method="POST">
								<input type="submit" name="view" value="View" /> <input
									type="submit" name="delete" value="Delete" /> <input
									type="hidden" name="persoId" value="${perso.id}" />
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>