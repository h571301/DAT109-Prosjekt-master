<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrering</title>
</head>
<body>
<h2>Registrering</h2>
  <form action="PaaMeldingServlet" method="post">
  <input type="text" name="brukernavn" value="${skjema.brukernavn}"/> brukernavn <br>
  <input type="text" name="epost" value="${skjema.epost}"/> epost <br>
  <input type="text" name="passord" value="${skjema.passord}"/> passord <br>
  <input type="submit" value="Registrer deg">
  </form>
</body>
</html>