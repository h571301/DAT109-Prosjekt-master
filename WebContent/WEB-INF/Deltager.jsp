<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeltagerListe</title>
</head>
<body>
<h2>Deltagere</h2>
<c:forEach items="${names}" var="name"> 
<p> Navn: ${name}</p>
</c:forEach>
<br>
  <p>
        <a href="yatzyServlet">Spill Yatzy</a>
    </p>
</body>
</html>