<%@page import="com.tutev.personelozluk.service.IlServis"%>
<%@page import="java.util.List"%>
<%@page import="com.tutev.personelozluk.entity.Il"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 

	IlServis ilServis = new IlServis();
	
    List<Il> ilList = ilServis.getAll();
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="il" begin="ilList" >
	<c:out value="${il.getTanim()}"></c:out>  
</c:forEach>


</body>
</html>