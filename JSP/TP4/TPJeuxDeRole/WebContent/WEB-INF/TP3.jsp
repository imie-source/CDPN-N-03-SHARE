<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="font-size: 40px">hello
<%
String param =(String)request.getAttribute("paramInitiale");
if(param==null){
%>
	anonymous
<% 
}else{
%>
	<%=param%>
<%
}
%>

</span>
</body>
</html>