<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.imie.model.Personnage"%>
<%@page import="org.imie.model.Arme"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="header.jspf"%>
	<div style="text-align: center">
		<div style="display: inline-block; text-align: left;"">
			<div class="standardData autoMargin">
				<div class="displayTable">
					<%  
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
								"dd/MM/yyyy");
						List<Personnage> personnages = (List<Personnage>) request
								.getAttribute("personnages");
						for (Personnage personnage : personnages) {
					%>
					<div class="displayRow">
						<%
							Boolean currentPersonnageConnecte = false;
								if (idConnecte != null && idConnecte == personnage.getId()) {
									currentPersonnageConnecte = true;
								}
						%>
						<div
							class="displayCell <%=currentPersonnageConnecte ? "highlight" : ""%>"><%=personnage.getNom() == null ? "" : personnage
						.getNom()%></div>
						<div
							class="displayCell <%=currentPersonnageConnecte ? "highlight" : ""%>"><%=personnage.getExp() == null ? "" : personnage
						.getExp()%></div>
						<div
							class="displayCell <%=currentPersonnageConnecte ? "highlight" : ""%>"><%=personnage.getHp() == null ? "" : personnage.getHp()%></div>
						<div
							class="displayCell <%=currentPersonnageConnecte ? "highlight" : ""%>"><%=personnage.getDateCreation() == null ? ""
						: simpleDateFormat.format(personnage.getDateCreation())%></div>
						<div
							class="displayCell <%=currentPersonnageConnecte ? "highlight" : ""%>">
							<%
								if (!connexion) {
							%>
							<a
								href="./ListPersonnage?commande=supprimer&id=<%=personnage.getId()%>">supprimer</a><span>|</span><a
								href="./ListPersonnage?commande=editer&id=<%=personnage.getId()%>">éditer</a>
							<%
								} else {
							%>
							<a
								href="./Connexion?commande=connexion&id=<%=personnage.getId()%>">connexion</a>
							<%
								}
							%>
						</div>
					</div>
					<%
						}
					%>

				</div>
				<%
					if (!connexion) {
				%>
				<div style="text-align: center;">
					<a href="./ListPersonnage?commande=creer">créer</a>				
				</div>
				<h2>Choissisez une arme !!!!</h2>
				
				<% 	List<Arme> armes = (List<Arme>) request.getSession().getAttribute("armes"); %>
				<TABLE BORDER="1"> 
					<CAPTION>Choix des armes</CAPTION> 
				
					<% if (armes != null){ 
						for (Arme arme : armes) { %>			
							<TR> 
								<TD><%= arme.getName() %></TD>	
								<TD><img src="image/<%= arme.getAddrImg()%>" alt="<%= arme.getName()%>"  height="42" width="42"></TD>
								<TD><a href="./ListPersonnage?commande=selectArme&id=<%=arme.getName()%>">Selectionner</a></TD>  									
							</TR> 
						<% } %>
					<% } %>
				</TABLE> 								
				<%@ include file="Plateau.jsp" %>
				
					
				<% } %>
			</div>
		</div>
			
	</div>
</body>
</html>