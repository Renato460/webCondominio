
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" href="../assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>
		Residente
	</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<!--     Fonts and icons     -->
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/paper-dashboard.css" />
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/fontawesome/css/all.min.css"/>
	<!-- CSS Files -->
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/css/buttons.bootstrap4.min.css"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/css/dataTables.bootstrap5.min.css"/>

	<!-- CSS Just for demo purpose, don't include it in your project <link href="../assets/demo/demo.css" rel="stylesheet" />-->

</head>

<body class="">
<div class="wrapper ">
	<div class="sidebar" data-color="white" data-active-color="danger">
		<div class="logo">
			<a href="https://www.creative-tim.com" class="simple-text logo-mini">
				<div class="logo-image-small">
					<img src="${ pageContext.request.contextPath }/assets/img/logo-small.png">
				</div>
				<!-- <p>CT</p> -->
			</a>
			<a href="https://www.creative-tim.com" class="simple-text logo-normal">
				<s:property value="#session['user'].nombre" />
				<s:property value="#session['user'].pagos['key']" />
				<!-- <div class="logo-image-big">
                  <img src="../assets/img/logo-big.png">
                </div> -->
			</a>
		</div>
		<div class="sidebar-wrapper">
			<ul class="nav">
				<li class="active ">
					<a href="./dashboard.html">
						<i class="nc-icon nc-bank"></i>
						<p>Dashboard</p>
					</a>
				</li>
				<li id="opcResidentes">
					<a href="javascript:getMenuReservas()">
						<i class="nc-icon nc-circle-10"></i>
						<p>Reservas</p>
					</a>
				</li>
				<li id="opcMultas">
					<a href="javascript:setTablaMulta()">
						<i class="nc-icon nc-map-big"></i>
						<p>Multas</p>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="main-panel">
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
			<div class="container-fluid">
				<div class="navbar-wrapper">
					<div class="navbar-toggle">
						<button type="button" class="navbar-toggler">
							<span class="navbar-toggler-bar bar1"></span>
							<span class="navbar-toggler-bar bar2"></span>
							<span class="navbar-toggler-bar bar3"></span>
						</button>
					</div>
					<h2>Dashboard</h2>
				</div>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-bar navbar-kebab"></span>
					<span class="navbar-toggler-bar navbar-kebab"></span>
					<span class="navbar-toggler-bar navbar-kebab"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-end" id="navigation">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="navbar-brand" href="logout.action">
								Salir
							</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navbar -->
		<div class="content">
			<!--<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="card card-stats">
						<div class="card-body ">
							<div class="row">
								<div class="col-5 col-md-4">
									<div class="icon-big text-center icon-warning">
										<i class="nc-icon nc-globe text-warning"></i>
									</div>
								</div>
								<div class="col-7 col-md-8">
									<div class="numbers">
										<p class="card-category">Capacity</p>
										<p class="card-title">150GB<p>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer ">
							<hr>
							<div class="stats">
								<i class="fa fa-refresh"></i>
								Update Now
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="card card-stats">
						<div class="card-body ">
							<div class="row">
								<div class="col-5 col-md-4">
									<div class="icon-big text-center icon-warning">
										<i class="nc-icon nc-money-coins text-success"></i>
									</div>
								</div>
								<div class="col-7 col-md-8">
									<div class="numbers">
										<p class="card-category">Revenue</p>
										<p class="card-title">$ 1,345<p>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer ">
							<hr>
							<div class="stats">
								<i class="fa fa-calendar-o"></i>
								Last day
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="card card-stats">
						<div class="card-body ">
							<div class="row">
								<div class="col-5 col-md-4">
									<div class="icon-big text-center icon-warning">
										<i class="nc-icon nc-vector text-danger"></i>
									</div>
								</div>
								<div class="col-7 col-md-8">
									<div class="numbers">
										<p class="card-category">Errors</p>
										<p class="card-title">23<p>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer ">
							<hr>
							<div class="stats">
								<i class="fa fa-clock-o"></i>
								In the last hour
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="card card-stats">
						<div class="card-body ">
							<div class="row">
								<div class="col-5 col-md-4">
									<div class="icon-big text-center icon-warning">
										<i class="nc-icon nc-favourite-28 text-primary"></i>
									</div>
								</div>
								<div class="col-7 col-md-8">
									<div class="numbers">
										<p class="card-category">Followers</p>
										<p class="card-title">+45K<p>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer ">
							<hr>
							<div class="stats">
								<i class="fa fa-refresh"></i>
								Update now
							</div>
						</div>
					</div>
				</div>
			</div>-->

			<!-- CUERPO-->
			<div class="row">
				<div class="col-md-12">
					<div class="card" id="cuerpo">


					</div>
				</div>
			</div>
			<!--CUERPO-->
			<!--Cuerpo2-->
			<div class="row">
				<div class="col-md-12">
					<div class="card" id="cuerpo2">

					</div>
				</div>
			</div>
			<!--Cuerpo2-->
		</div>
		<footer class="footer footer-black  footer-white ">

		</footer>
	</div>
</div>


<!--Modal-->

<!--   Core JS Files   -->
<script
		src="${ pageContext.request.contextPath }/assets/js/jquery.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/rutValidar.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/popper.min.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/plugins/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>




<script
		src="${ pageContext.request.contextPath }/assets/js/pago-ajax.js"></script>

<script
		src="${ pageContext.request.contextPath }/assets/js/reserva-ajax.js"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/form-reserva-ajax.js"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/multa-ajax.js"></script>





<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/JSZip-2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/dataTables.bootstrap5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.bootstrap4.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.print.min.js"></script>
<!--  Notifications Plugin    -->
<script
		src="${ pageContext.request.contextPath }/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script
		src="${ pageContext.request.contextPath }/assets/js/paper-dashboard.min.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/main.js" type="text/javascript"></script>
<script
		src="${ pageContext.request.contextPath }/assets/js/rutValidar.js" type="text/javascript"></script>



<!-- Paper Dashboard DEMO methods, don't include it in your project! <script src="../assets/demo/demo.js"></script>
<script>
    $(document).ready(function() {
        // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
        demo.initChartsPages();
    });
</script>
-->


</body>
</html>
