<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Logg inn</h2>
  <form action="login" method="post">
    <p> 
     ${skjema.feilmelding}<br/>
    </p>
    <p>
      <input type="text" name="brukernavn" /> Brukernavn
    </p>
    <p>
      <input type="text" name="passord" /> Passord 
    </p>
    <p>
      <input type="submit" value="Logg inn" />
    </p>
  </form>
  <p>
        <a href="PaaMeldingServlet">Registrer</a>
    </p>
</body>
</html>
