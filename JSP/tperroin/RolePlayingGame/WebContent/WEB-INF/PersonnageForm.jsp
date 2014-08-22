<%@page import="java.util.ArrayList, org.imie.tperroin.model.Personnage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<title>Form personnage</title>
</head>
<body>

	<jsp:include page="Header.jsp" />

	<form action="PersonnageFormController" method="post">

		<c:choose>
			<c:when test="${persoToView != null}">
				<label>Name:</label>
				<input name="name" type="text" value="${persoToView.name}" />
				<label>HP:</label>
				<input name="hp" type="text" value="${persoToView.hp}" disabled />
				<label>Exp:</label>
				<input name="exp" type="text" value="${persoToView.exp}" disabled />
				<label>Birthday:</label>
				<input name="birthday" type="text" value="${persoToView.birthday}"
					disabled />
				<label>Image:</label>
				<input name="image" type="text" value="${persoToView.image}" />
				<input type="submit" value="Edit" name="edit">
				<input type="hidden" name="persoId" value="${persoToView.id}" />
			</c:when>
			<c:otherwise>
				<label>Name:</label>
				<input name="name" type="text" />
				<label>HP:</label>
				<input name="hp" type="text" disabled />
				<label>Exp:</label>
				<input name="exp" type="text" disabled />
				<label>Birthday:</label>
				<input name="birthday" type="text" disabled />
				<label>Image:</label>
				<input name="image" type="text" />
				<input type="submit" value="New" name="new">
			</c:otherwise>
		</c:choose>


	</form>
	<a href="./PersonnageController">Back</a>
</body>
</html>