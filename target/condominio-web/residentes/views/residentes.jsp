<%@ taglib prefix="d" uri="/struts-tags"%>
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
<title>Residentes</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/dashboard/">



<!-- Bootstrap core CSS -->

<link
	href="${ pageContext.request.contextPath }/assets/css/adminlte.min.css"
	rel="stylesheet">
<link
	href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Favicons -->



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


<!-- Custom styles for this template -->
<link
	href="${ pageContext.request.contextPath }/assets/css/dashboard.css"
	rel="stylesheet">
</head>
<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Condominio</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><d:a class="nav-link"
					href="logout.action">Salir</d:a></li>
		</ul>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav nav-pills nav-sidebar flex-column">
						<li class="nav-item"><d:a class="nav-link home" id="home"
								aria-current="page" onclick="getAnuncios()" href="#">Home</d:a>
						</li>
						<li class="nav-item"><d:a class="nav-link multa" id="multa"
								aria-current="page" onclick="getMenuMultas()" href="#">Multas</d:a>
						</li>
						<li class="nav-item"><d:a class="nav-link reserva" id="reserva"
								aria-current="page" onclick="getMenuReservas()" href="#">Reservas</d:a>
						</li>
						<li class="nav-item"><d:a class="nav-link pago" id="pago"
								aria-current="page" onclick="getPago()">Pagar</d:a></li>
					</ul>
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>

				</div>


				<h3>
					Bienvenido
					<d:property value="#session['user'].usuario" />
				</h3>

				<!-- SECCION -->

				<section class="content">
					<div class="container-fluid">
						<!-- Small boxes (Stat box) -->
						<div class="row">
							<div class="col-lg-3 col-6">
								<!-- small box -->
								<div class="small-box bg-info">
									<div class="inner">
										<h3>430</h3>

										<p>Pagos Efectuados</p>
									</div>
									<div class="icon">
										<i class="ion ion-bag"></i>
									</div>
									<a href="#" class="small-box-footer">Más Información <i
										class="fas fa-arrow-circle-right"></i></a>
								</div>
							</div>
							<!-- ./col -->
							<div class="col-lg-3 col-6">
								<!-- small box -->
								<div class="small-box bg-success">
									<div class="inner">
										<h3>
											4<sup style="font-size: 20px">%</sup>
										</h3>

										<p>Morosidades</p>
									</div>
									<div class="icon">
										<i class="ion ion-stats-bars"></i>
									</div>
									<a href="#" class="small-box-footer">Más Información <i
										class="fas fa-arrow-circle-right"></i></a>
								</div>
							</div>
							<!-- ./col -->
							<div class="col-lg-3 col-6">
								<!-- small box -->
								<div class="small-box bg-warning">
									<div class="inner">
										<h3>500</h3>

										<p>Registros en Aplicación</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a href="#" class="small-box-footer">Más Información <i
										class="fas fa-arrow-circle-right"></i></a>
								</div>
							</div>
							<!-- ./col -->
							<div class="col-lg-3 col-6">
								<!-- small box -->
								<div class="small-box bg-danger">
									<div class="inner">
										<h3>65</h3>

										<p>Reservas</p>
									</div>
									<div class="icon">
										<i class="ion ion-pie-graph"></i>
									</div>
									<a href="#" class="small-box-footer">Más Información <i
										class="fas fa-arrow-circle-right"></i></a>
								</div>
							</div>
							<!-- ./col -->
						</div>
						
						
						<div class="row">
							<div id="cuerpo" class="cuerpo"><span class="visually-hidden">Loading...</span></div>
						</div>
						
						
						
					</div>
					<!-- /.row -->
					<!-- Main row -->
				</section>


				<!--  FINAL SECCION -->





			</main>
		</div>
	</div>

	<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script> -->
	 <script
		src="${ pageContext.request.contextPath }/assets/js/jquery.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/pago-ajax.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.2/moment.min.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/pago-ajax.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/residentes-ajax.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/reserva-ajax.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/form-reserva-ajax.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/multa-ajax.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>
	<script
		src="${ pageContext.request.contextPath }/assets/js/adminlte.js"></script>

</body>
</html>