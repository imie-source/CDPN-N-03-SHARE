<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<c:import url="header.jsp" />
	<div style="text-align: center">
		<div style="display: inline-block; text-align: left;"">
			<div class="standardData autoMargin">
				<div class="displayTable">
					<c:forEach var="bean" items="${personnages}" varStatus="loopStatus">
						<div class="displayRow">
							<c:set var="classCell" value="displayCell " />
							<c:if test="${bean.id==personnageConnecte.id}">
								<c:set var="classCell" value="displayCell highlight" />
							</c:if>
							<div class="${classCell}">
								<c:out value="${bean.nom}" />
							</div>
							<div class="${classCell}">
								<c:out value="${bean.exp}" />
							</div>
							<div class="${classCell}">
								<c:out value="${bean.hp}" />
							</div>
							<div class="${classCell}">
								<fmt:formatDate value="${bean.dateCreation}" />
							</div>
							<div class="${classCell}">
								<c:choose>
									<c:when test="${not (personnageConnecte==null)}">
										<a href="./ListPersonnage?commande=supprimer&id=${bean.id}">supprimer</a>
										<span>|</span>
										<a href="./ListPersonnage?commande=editer&id=${bean.id}">éditer</a>
									</c:when>
									<c:otherwise>
										<a href="./Connexion?commande=connexion&id=${bean.id}">connexion</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</c:forEach>

				</div>
				<div style="text-align: center;">
					<c:choose>
						<c:when test="${not (personnageConnecte==null)}">
							<a href="./ListPersonnage?commande=creer">créer</a>
						</c:when>
						<c:otherwise>
							<span>vous devez vous connecter</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>