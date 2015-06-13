<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<%@ page import="com.tutev.personelozluk.entity.Kisi"%>

<%
	Kisi kisi = (Kisi) session.getAttribute("kisi");

	if (kisi == null) {
		response.sendRedirect("login.jsp");
	} else {
%>



<html>
<body>
	<span><%=kisi.getAd() + " " + kisi.getSoyad()
						+ " hoşgeldiniz "%></span>
	<form action="ColorServlet">
		Lütfen bir renk giriniz<br> <input type="text" name="color"
			size="20px"> <input type="submit" value="submit">
	</form>
</body>
</html>
<%
	}
%>
