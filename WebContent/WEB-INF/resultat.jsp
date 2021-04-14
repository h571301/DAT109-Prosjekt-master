<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="CSS/style.css" />

<title>Yatzy Game</title>
</head>
<body>

	  <div class="container align column">
      <div class="border">
        <h1>Førsteplass</h1>
        <p class="align">${firstPlace}</p>
      </div>
      <div class="align">
        <div class="border margin5">
          <h1>Andreplass</h1>
          <p class="align">${secondPlace}</p>
        </div>
        <div class="border">
          <h1>Tredjeplass</h1>
          <p class="align">${thirdPlace}</p>
        </div>
      </div>
      <a href="innloggingServlet">Spill igjen</a>
    </div>

	
	<script defer src="JS/app.js"></script>
<script  src="JS/calculator.js"></script>
</body>
</html>