<%@page import="metier.Personnage"%>
<header class="maxSize">
	<%
	boolean login = request.getSession().getAttribute("persoSelec")==null; 
	Personnage persoLogged = new Personnage();
	if (!login) { 
		persoLogged = (Personnage) request.getSession().getAttribute("persoSelec"); 
	} 
	
	if (login){ %>
	 	<p>Choisissez un personnage</p>
	<%}else{ %>
		<p style="display:inline-block;">Pseudo : <%= persoLogged.getNom() %></p>
		<form style="display:inline-block;" action="selecPersoServlet" method="post">
			<input type="submit" name="actionHeader" value="Jouer" />
			<input type="submit" name="actionHeader" value="Deconnexion" />
		</form>
	<% } %>
</header>