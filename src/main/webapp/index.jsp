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
<title>Condominio</title>




<!-- Bootstrap core CSS -->
<link
	href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Favicons -->
<meta name="theme-color" content="#7952b3">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template
<link href="${ pageContext.request.contextPath }/assets/css/signin.css"
	rel="stylesheet">-->

	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/paper-dashboard.css" />
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/fontawesome/css/all.min.css"/>
	<!-- CSS Files -->
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/main.css"/>
</head>
<body class="d-flex align-items-center justify-content-center login text-center">

	<main class="form-signin w-25">
		<form action="login.action" class="needs-validation" novalidate method="post">
			<img class="mb-4" src="${ pageContext.request.contextPath }/assets/img/logo_condo.jpg"
				alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Entra tus datos</h1>

			<div class="form-floating">
				<input name="usuario" type="text" class="form-control" id="floatingInput"
					placeholder="Usuario" required> <label for="floatingInput">Usuario</label>
			</div>
			<div class="form-floating">
				<input name="pass" type="password" class="form-control" id="floatingPassword"
					placeholder="Password" required> <label for="floatingPassword">Contraseña</label>
			</div>

			<button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
		</form>

		<a class="navbar-brand" href="notification.action">
			Prueba
		</a>

	</main>


<script src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${ pageContext.request.contextPath }/assets/js/validate.js"></script>
	<script
			src="${ pageContext.request.contextPath }/assets/js/paper-dashboard.min.js" type="text/javascript"></script>
</body>
</html>