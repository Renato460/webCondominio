<div class="mt-5 mb-3">
	<h4>Reserva de Servicios</h4>
</div>

<div class="list-group">
	<a href="#" class="list-group-item list-group-item-action"
		aria-current="true">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 bd-highlight"><h5>Quincho</h5></div>
			<div class="p-2 col-4 bd-highlight"><h5>Costo: $10.000</h5></div>
			<div class="p-2 col-4 bd-highlight"><button type="button" id="buttonQuincho" class="btn btn-primary buttonQuincho" data-bs-toggle="modal" data-bs-target="#datosResidente" data-bs-whatever="QUINCHO" onclick="modalFormulario(buttonQuincho)">Reserva</button></div>
		</div>
		
		
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 bd-highlight"><h5 class=>Multicancha</h5></div>
			<div class="p-2 col-4 bd-highlight"><h5 class=>Costo: $8.000</h5></div>
			<div class="p-2 col-4 bd-highlight"><button type="button" id="buttonMulticancha" class="btn btn-primary buttonMulticancha" data-bs-toggle="modal" data-bs-target="#datosResidente" data-bs-whatever="MULTICANCHA" onclick="modalFormulario(buttonMulticancha)">Reserva</button></div>
		</div>			
	</a> 
	<a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 flex-fill bd-highlight"><h5 class="mx-auto">Sala de Eventos</h5></div>
			<div class="p-2 col-4 flex-fill bd-highlight"><h5>Costo: $20.000</h5></div>
			<div class="p-2 col-4 flex-fill bd-highlight"><button type="button" id="buttonEvento" class="btn btn-primary buttonEvento" data-bs-toggle="modal" data-bs-target="#datosResidente" data-bs-whatever="SALA DE EVENTOS" onclick="modalFormulario(buttonEvento)">Reserva</button></div>
		</div>
		
			
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 flex-fill bd-highlight"><h5>Estacionamiento</h5></div>
			<div class="p-2 col-4 flex-fill bd-highlight"><h5>Costo: $1.000</h5></div>
			<div class="p-2 col-4 flex-fill bd-highlight"><button type="button" id="buttonEstacionamiento" class="btn btn-primary buttonEstacionamiento" data-bs-toggle="modal" data-bs-target="#datosResidente" data-bs-whatever="ESTACIONAMIENTO" onclick="modalFormulario(buttonEstacionamiento)">Reserva</button></div>
		</div>
		
			
	</a>
</div>

<div class="mt-5 mb-3">
	<h4>Ingresa tu reserva</h4>
</div>

<h5>Ingresa tus datos</h5>



<div class="modal fade" id="datosResidente" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ingrese sus
					datos</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="/action_page.php">
					<div class="container">
						<div class="row">
							
							<div class='col-lg-12'>
								<div class="input-group mb-2 reservaNombre">
									<span class="input-group-text" id="basic-addon1">Reserva</span> <input
										type="text" class="form-control reserva" aria-label="Reserva" aria-describedby="basic-addon1" disabled>
								</div>
								
								<div class="input-group mb-2">
									<span class="input-group-text">Nombre y Apellido</span> <input
										type="text" aria-label="First name" class="form-control"
										placeholder="Nombre"> <input type="text"
										aria-label="Last name" class="form-control"
										placeholder="Apellido">
								</div>

								<div class="input-group mb-2">
									<span class="input-group-text" id="basic-addon1">RUN</span> <input
										type="text" class="form-control" placeholder="12345678-9"
										aria-label="Rut" aria-describedby="basic-addon1">
								</div>

								<div class="input-group mb-2">
									<span class="input-group-text" id="basic-addon1">Fecha
										de Reserva</span> <input type="date" class="form-control"
										placeholder="dd-mm-aaaa" aria-label="FechaReserva"
										aria-describedby="basic-addon1">
								</div>
								
								<div class="input-group mb-2">
									 <span
										class="input-group-text" id="basic-addon1">Inicio</span> <input
										type="time" class="form-control" placeholder="hh-mm"
										aria-label="horaInicio" aria-describedby="basic-addon1">
									<span class="input-group-text" id="basic-addon1">Término</span>
									<input type="time" class="form-control" placeholder="hh-mm"
										aria-label="horaTermino" aria-describedby="basic-addon1">
								</div>
								
								<button type="submit" class="btn btn-primary btn-lg">Confirmar
									Reserva</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


