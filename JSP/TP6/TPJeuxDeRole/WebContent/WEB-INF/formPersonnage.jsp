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
<%
	Boolean creation=(Boolean)request.getAttribute("modeCreation");
	creation=creation==null?false:creation;
%>
<body>
	<div style="text-align: center">
		<div style="display: inline-block; text-align: left;">
			<div class="standardData">
				<%
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
									"dd/MM/yyyy");
							Personnage personnage = (Personnage) request
									.getAttribute("personnage");
				%>
				<form method="post">
					<input type="hidden" name="idPersonnage"
						value="<%=personnage == null ? "" : personnage.getId()%>">
					<div>
						<div class="formElement">
							<label for="nomPersonnage">nom</label>
						</div>
						<div class="formElement">
							<input name="nomPersonnage" id="nomPersonnage" type="text"
								value="<%=personnage == null || personnage.getNom()==null ? "" : personnage.getNom()%>" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="HPPersonnage">HP</label>
						</div>
						<div class="formElement">
							<input <%if (creation) {%> readonly="readonly" <%}%>
								name="HPPersonnage" id="HPPersonnage" type="text"
								value="<%=personnage == null ? "" : personnage.getHp()%>" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="expPersonnage">exp</label>
						</div>
						<div class="formElement">
							<input <%if (creation) {%> readonly="readonly"  <%}%>
								name="expPersonnage" id="expPersonnage" type="text"
								value="<%=personnage == null ? "" : personnage.getExp()%>" />
						</div>
					</div>
					<div>
						<div class="formElement">
							<label for="dateCreationPersonnage">date Creation</label>
						</div>
						<div class="formElement">
							<input readonly="readonly"  id="dateCreationPersonnage"
								type="text"
								value="<%=personnage == null ? "" : simpleDateFormat
					.format(personnage.getDateCreation())%>" />
						</div>
					</div>
					<div>
						<%
							if (!creation) {
						%>
						<input type="submit" name="commande" value="modifier" />
						<%
							} else {
						%>
						<input type="submit" name="commande" value="creer" />
						<%
							}
						%>

					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>