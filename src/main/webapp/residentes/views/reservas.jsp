<div class="mt-5 mb-3">
	<h4>Reserva de Servicios</h4>
</div>

<div class="list-group">
	<a href="#" class="list-group-item list-group-item-action active"
		aria-current="true">
		<div class="d-flex w-100 justify-content-between">
			<h5 class="mb-1">Quincho</h5>
		</div>
		<p class="mb-1">Costo: $10.000.</p> <small>Estado: Disponible.</small>
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<h5 class="mb-1">Multicancha</h5>
		</div>
		<p class="mb-1">Costo: $8.000.</p> <small class="text-muted">Estado:
			Disponible.</small>
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<h5 class="mb-1">Sala de Eventos</h5>
		</div>
		<p class="mb-1">Costo: $20.000.</p> <small class="text-muted">Estado:
			Disponible.</small>
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<h5 class="mb-1">Estacionamiento</h5>
		</div>
		<p class="mb-1">Costo: $0.</p> <small class="text-muted">Estado:
			Disponible.</small>
	</a>
</div>

<div class="mt-5 mb-3">
	<h4>Ingresa tu reserva</h4>
</div>

<h5>Ingresa tus datos</h5>

<form action="/action_page.php">
	<div class="container">
		<div class="row">
			<div class='col-lg'>

				<div class="input-group mb-2">
					<span class="input-group-text">Nombre y Apellido</span> <input
						type="text" aria-label="First name" class="form-control">
					<input type="text" aria-label="Last name" class="form-control">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">RUN</span> <input
						type="text" class="form-control" placeholder="12345678-9"
						aria-label="Rut" aria-describedby="basic-addon1">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Fecha de
						Reserva</span> <input type="date" class="form-control"
						placeholder="dd-mm-aaaa" aria-label="FechaReserva"
						aria-describedby="basic-addon1"> <span
						class="input-group-text" id="basic-addon1">Inicio</span>
					<input type="time" class="form-control" placeholder="hh-mm"
						aria-label="horaInicio" aria-describedby="basic-addon1"> <span
						class="input-group-text" id="basic-addon1">Término</span>
					<input type="time" class="form-control" placeholder="hh-mm"
						aria-label="horaTermino" aria-describedby="basic-addon1">
				</div>


			</div>
		</div>
	</div>
</form>

<div class="mt-3 mb-3">
	<button type="button" class="btn btn-primary btn-lg">Confirmar
		Reserva</button>
	<button type="button" class="btn btn-primary btn-lg">Pagar
		Reserva</button>
</div>

