<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.82.0">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link
	href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>


<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Condominio Web</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pagos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Multas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Reservas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">SignOut</a>
        </li>
      </ul>
    </div>
  </div>
</nav>






<script src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>