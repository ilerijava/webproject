<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@page import="com.tutev.personelozluk.service.IlServis"%>
<%@page import="com.tutev.personelozluk.entity.Il"%>
<%@page import="java.util.List"%>

<%
	IlServis ilServis = new IlServis();

	List<Il> ilList = ilServis.getAll();
	request.setAttribute("iller", ilList);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kayıtlı İllerin Listesi</title>
</head>
<body>
	<table>
		<tr>
			<th>Plaka</th>
			<th>Tanım</th>
		</tr>
		<c:forEach items="${iller}" var="il">
			<tr>
				<td><c:out value="${il.plaka}" /></td>
				<td><c:out value="${il.tanim}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>