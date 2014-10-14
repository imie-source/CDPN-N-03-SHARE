<%@page import="org.imie.tperroin.model.Personnage"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${personnageConnected != null}">
	<div class="box">
		<h5>
			Hello,
			<c:out value="${personnageConnected.name}"></c:out>
		</h5>
		<form action="PersonnageChoiceController" method="post">
			<input type="submit" name="logout" value="Logout" /> <input
				type="hidden" name="persoId" value="${personnageConnected.id}" />
		</form>
		<form action="PersonnageController" method="post">
			<input type="submit" name="play" value="Play" /> <input type="hidden"
				name="persoId" value="${personnageConnected.id}" />
		</form>
	</div>
</c:if>