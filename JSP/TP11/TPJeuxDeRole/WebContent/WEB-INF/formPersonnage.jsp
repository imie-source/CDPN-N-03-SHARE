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
		<div style="display: inline-block; text-align: left;">
			<div class="standardData">
				<form method="post">
					<input type="hidden" name="idPersonnage" value="${personnage.id}">
					<div>
						<div class="formElement">
							<label for="nomPersonnage">nom</label>
						</div>
						<div class="formElement">
							<input name="nomPersonnage" id="nomPersonnage" type="text"
								value="${personnage.nom}" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="HPPersonnage">HP</label>
						</div>
						<div class="formElement">
							<input <c:if test="${modeCreation}">readonly="readonly"</c:if>
								name="HPPersonnage" id="HPPersonnage" type="text"
								value="${personnage.hp}" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="expPersonnage">exp</label>
						</div>
						<div class="formElement">
							<input <c:if test="${modeCreation}">readonly="readonly"</c:if>
								name="expPersonnage" id="expPersonnage" type="text"
								value="${personnage.exp}" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="dateCreationPersonnage">date Creation</label>
						</div>
						<div class="formElement">
							<input readonly="readonly" name="dateCreationPersonnage"
								id="dateCreationPersonnage" type="text"
								value="${personnage.dateCreation}" />
						</div>
					</div>
					<div>
						<c:choose>
							<c:when test="${modeCreation}">
								<input type="submit" name="commande" value="creer" />
							</c:when>
							<c:otherwise>
								<input type="submit" name="commande" value="modifier" />
							</c:otherwise>
						</c:choose>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>