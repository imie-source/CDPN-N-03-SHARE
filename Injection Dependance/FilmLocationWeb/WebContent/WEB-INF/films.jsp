<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${urlToLanguage.language=='fr'}">
		<c:set var="films" value="${listFilmGUI.filmFR}"></c:set>
	</c:if>
	<c:if test="${urlToLanguage.language=='us'}">
		<c:set var="films" value="${listFilmGUI.filmUS}"></c:set>
	</c:if>
	<a href="./fr">francais</a>
	<a href="./us">américains</a>
	<table>
		<tr>
			<th>Titre</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${films}" var="film">
			<tr>
				<td><c:out value="${film.titre}"></c:out></td>
				<td><c:out value="${film.genre}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<form method="post">
		<input name="titre" /> <input type="submit" value="ajouter">
	</form>

</body>
</html>