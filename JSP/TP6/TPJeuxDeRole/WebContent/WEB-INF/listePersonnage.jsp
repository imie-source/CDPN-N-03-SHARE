<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.imie.model.Personnage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="./styles/style.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
						<div class="displayCell"><%=personnage.getNom()==null?"":personnage.getNom()%></div>
						<div class="displayCell"><%=personnage.getExp()==null?"":personnage.getExp()%></div>
						<div class="displayCell"><%=personnage.getHp()==null?"":personnage.getHp()%></div>
						<div class="displayCell"><%=personnage.getDateCreation()==null?"":simpleDateFormat.format(personnage.getDateCreation())%></div>
						<div class="displayCell">
							<a
								href="./ListPersonnage?commande=delete&id=<%=personnage.getId()%>">supprimer</a><span>|</span><a
								href="./ListPersonnage?commande=read&id=<%=personnage.getId()%>">éditer</a>
						</div>
					</div>
					<%
						}
					%>

				</div>
				<div style="text-align: center;">
					<a href="./ListPersonnage?commande=creer">créer</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>