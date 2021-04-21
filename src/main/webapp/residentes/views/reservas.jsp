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
