<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Deltagere</h1>
<c:forEach var="deltager" items="${deltagere}">
<p>Navn: ${deltager.brukernavn}</p><p> Epost: ${deltager.epost}</p>	
<hr>					
</c:forEach>
<a href="innloggingServlet">Start spill</a>
</body>
</html>