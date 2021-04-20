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
<title>Reservas</title>

<!-- Bootstrap core CSS -->
<link
	href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	
<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet"/>
<link href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.css" rel="stylesheet"/>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.2/moment.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

	
</head>
	
	

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Condominio</a>
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
	
<div class="mt-5 mb-3">	
	<h4>Reserva de Servicios</h4>
</div>
	
	<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Quincho</h5>
      <small>3 days ago</small>
    </div>
    <p class="mb-1">Costo: $10.000.</p>
    <small>Estado: Disponible.</small>
  </a>
  <a href="#" class="list-group-item list-group-item-action">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Multicancha</h5>
      <small class="text-muted">3 days ago</small>
    </div>
    <p class="mb-1">Costo: $8.000.</p>
    <small class="text-muted">Estado: Disponible.</small>
  </a>
  <a href="#" class="list-group-item list-group-item-action">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Sala de Eventos</h5>
      <small class="text-muted">3 days ago</small>
    </div>
    <p class="mb-1">Costo: $20.000.</p>
    <small class="text-muted">Estado: Disponible.</small>
  </a>
  <a href="#" class="list-group-item list-group-item-action">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Estacionamiento</h5>
      <small class="text-muted">3 days ago</small>
    </div>
    <p class="mb-1">Costo: $0.</p>
    <small class="text-muted">Estado: Disponible.</small>
  </a>
</div>

<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            	<h6>Fecha Reserva</h6>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            	<h6>Hora Inicio</h6>
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker2').datetimepicker();
            });
        </script>
    </div>
</div>
	

<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            	<h6>Hora Termino</h6>
                <div class='input-group date' id='datetimepicker3'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker3').datetimepicker();
            });
        </script>
    </div>
</div>

<div class="mt-3 mb-3">
<button type="button" class="btn btn-primary btn-lg">Confirmar Reserva</button>
<button type="button" class="btn btn-primary btn-lg">Pagar Reserva</button>
</div>

</body>
</html>




<script src=""${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>