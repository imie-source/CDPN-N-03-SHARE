<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.imie.model.Personnage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="./styles/style.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="standardData autoMargin displayTable">
<%
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
List<Personnage> personnages = (List<Personnage>) session.getAttribute("personnages"); 
for (Personnage personnage : personnages) {
%>
<div class="displayRow">
	<div class="displayCell"><%=personnage.getNom()%></div>
	<div class="displayCell"><%=personnage.getExp()%></div>
	<div class="displayCell"><%=personnage.getHp()%></div>
	<div class="displayCell"><%=simpleDateFormat.format(personnage.getDateCreation())%></div>
	<div class="displayCell"><a href="./ListPersonnage?commande=delete&id=<%=personnage.getId()%>">delete</a> </div>
</div>
<% 
}
%>

</div>
</body>
</html>