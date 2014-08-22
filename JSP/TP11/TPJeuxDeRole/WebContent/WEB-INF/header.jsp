<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>

	<div style="text-align: right;">
		<c:if test="${not(personnageConnecte==null)}">
			<div style="display: inline-block;">
				<c:out value="${personnageConnecte.nom}" />
			</div>
			<div style="display: inline-block;">
				<form action="Connexion" method="post">
					<input type="submit" name="commande" value="deconnecter" />
				</form>
			</div>
		</c:if>
	</div>
</div>