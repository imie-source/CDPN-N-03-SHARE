<%@page import="metier.Case"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Plateau du jeu</title>
<link href="./styles/style.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>

</head>
<body>
	<%@ include file="header.jsp" %>
	
	<% 
	String deplacement= request.getParameter("deplacement");
	if(deplacement==null){
		deplacement="bas";
	} %>

	<h3 class="titrePage">Plateau</h3>
	
	<div style="display:table; margin:auto;">
	
		<div style="display:table-cell; min-width:400px;" >
			<form action="servletPlateau" method="post">
				<input id="boutonGauche" type="submit" name="deplacement" value="gauche" />
				<input id="boutonBas" type="submit" name="deplacement" value="bas" />
				<input id="boutonHaut" type="submit" name="deplacement" value="haut" />
				<input id="boutonDroite" type="submit" name="deplacement" value="droite" />
			</form>
		</div>
		
		
		<div id="divPlateauJeu" style="display:table-cell; width:100%">
			<table id="plateauJeu">
				<% 	
				 	Case[][] tab = persoLogged.getPlateau().getTabPlateau();
					int i,j;
					for (i=0; i<10; i++){
					%> 
						<tr>
					<% 
						for (j=0; j<10; j++){
							%>
								<td class=" case sol sol<%= tab[i][j].getIdSol() %>">
									<%  if(tab[i][j].getIdElement()==1){ %>
										<div id ="casePerso" class="case element <%= deplacement %>">
											
										</div>
									<% } %>
								</td>
							<% } %> 
						<tr>
					<% } %>
			</table>
		</div>
		
		<div style="display:table-cell; min-width:400px;">
			<div style="border:1px solid black;">
				<table>
				<tr>
					<td>
						Nom
					</td>
					<td>
					 	<%= persoLogged.getNom() %>
					</td>
				</tr>
				<tr>
					<td>
						Niveau
					</td>
					<td>
						<%= persoLogged.getNiveau() %>
					</td>
				</tr>
				<tr>
					<td>
						Vie
					</td>
					<td>
						<%= persoLogged.getVie() %>
					</td>
					
				</tr>
				<tr>
					<td>
						Experience
					</td>
					<td>
						<%= persoLogged.getExp() %>
					</td>
				</tr>
				</table>
			</div>
		</div>
	</div>
	<script>

	$(function() {
		$('html, body').animate({
            scrollTop: $("#plateauJeu").offset().top
        }, 0);
	});
		
		var gauche = 81;
		var haut = 90;
		var droit = 68;
		var bas = 83;
		$(document).keydown(function (e) {  
		    if (e.keyCode === gauche) {
		    	if ( $("#casePerso").hasClass("gauche") ){
					$("#boutonGauche").click();
				}else{
				    $("#casePerso").removeClass();
				    $("#casePerso").addClass("case");
				    $("#casePerso").addClass("gauche"); 
				}
		    }
		    if (e.keyCode === haut) {
		    	if ( $("#casePerso").hasClass("haut") ){
					$("#boutonHaut").click();
				}else{
			    	$("#casePerso").removeClass();
				    $("#casePerso").addClass("case");
				    $("#casePerso").addClass("haut");  
				}
		    }
		    if (e.keyCode === droit) { 
		    	if ( $("#casePerso").hasClass("droite") ){
					$("#boutonDroite").click();
				}else{
			    	$("#casePerso").removeClass();
				    $("#casePerso").addClass("case");
				    $("#casePerso").addClass("droite"); 
		    	}
		    }
		    if (e.keyCode === bas) {  
				if ( $("#casePerso").hasClass("bas") ){
					$("#boutonBas").click();
				}else{
			    	$("#casePerso").removeClass();
				    $("#casePerso").addClass("case");
				    $("#casePerso").addClass("bas");
				}
		    }
		});
	</script>
</body>
</html>