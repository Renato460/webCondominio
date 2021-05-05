<div class="mt-2 mb-3">
	<h4>Reserva de Servicios</h4>
</div>
<div class="mt-2 mb-3">
	<h4>Ingresa tu reserva</h4>
</div>
<div class="list-group">
	<a href="#" class="list-group-item list-group-item-action"
		aria-current="true">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 bd-highlight">
				<h5>Quincho</h5>
			</div>
			<div class="p-2 col-4 bd-highlight">
				<h5>Costo: $10.000</h5>
			</div>
			<div class="p-2 col-4 bd-highlight">
				<button type="button" id="buttonQuincho"
					class="btn btn-primary buttonQuincho" data-bs-toggle="modal"
					data-bs-target="#datosResidente" data-bs-whatever="QUINCHO"
					onclick="modalFormulario(buttonQuincho)">Reserva</button>
			</div>
		</div>


	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 bd-highlight">
				<h5 class=>Multicancha</h5>
			</div>
			<div class="p-2 col-4 bd-highlight">
				<h5 class=>Costo: $8.000</h5>
			</div>
			<div class="p-2 col-4 bd-highlight">
				<button type="button" id="buttonMulticancha"
					class="btn btn-primary buttonMulticancha" data-bs-toggle="modal"
					data-bs-target="#datosResidente" data-bs-whatever="MULTICANCHA"
					onclick="modalFormulario(buttonMulticancha)">Reserva</button>
			</div>
		</div>
	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 flex-fill bd-highlight">
				<h5 class="mx-auto">Sala de Eventos</h5>
			</div>
			<div class="p-2 col-4 flex-fill bd-highlight">
				<h5>Costo: $20.000</h5>
			</div>
			<div class="p-2 col-4 flex-fill bd-highlight">
				<button type="button" id="buttonEvento"
					class="btn btn-primary buttonEvento" data-bs-toggle="modal"
					data-bs-target="#datosResidente" data-bs-whatever="SALA EVENTOS"
					onclick="modalFormulario(buttonEvento)">Reserva</button>
			</div>
		</div>


	</a> <a href="#" class="list-group-item list-group-item-action">
		<div class="d-flex w-100 justify-content-between">
			<div class="p-2 col-4 flex-fill bd-highlight">
				<h5>Estacionamiento</h5>
			</div>
			<div class="p-2 col-4 flex-fill bd-highlight">
				<h5>Costo: $1.000</h5>
			</div>
			<div class="p-2 col-4 flex-fill bd-highlight">
				<button type="button" id="buttonEstacionamiento"
					class="btn btn-primary buttonEstacionamiento"
					data-bs-toggle="modal" data-bs-target="#datosResidente"
					data-bs-whatever="ESTACIONAMIENTO"
					onclick="modalFormulario(buttonEstacionamiento)">Reserva</button>
			</div>
		</div>


	</a>
</div>




<div class="card-group">
  <div class="card">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Card title</h5>
      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
    </div>
  </div>
</div>






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
				
				<!-- FORMULARIO DE RESERVA -->
				<div id="form_reserva">
					<div class="container">
						<div class="row">

							<div class='col-lg-12'>
								<div class="input-group mb-2 reservaNombre">
									<span class="input-group-text" id="basic-addon1">Reserva</span>
									<input type="text" class="form-control reservaId" name="servicio"
										aria-label="Reserva" aria-describedby="basic-addon1">
								</div>

								<div class="input-group mb-2">
									<span class="input-group-text" id="basic-addon1">RUN</span> <input
										type="text" class="form-control rutP" placeholder="12345678-9" name="rut"
										aria-label="Rut" aria-describedby="basic-addon1">
								</div>

								<div class="input-group mb-2">
									<span class="input-group-text col-4" id="basic-addon1">Fecha
										de Reserva</span> <input type="date" class="form-control fechaReserva col-5"
										placeholder="dd-mm-aaaa" aria-label="FechaReserva" name="fecha"
										aria-describedby="basic-addon1">
										<a onclick="getHorario()" href="#" class=" col-3 btn btn-primary" role="button">Horarios</a>
										
								</div>

								<div class="input-group mb-2">
									<span class="input-group-text" id="basic-addon1">Horario</span>
									<select name="horarios" id="horarios" class="form-select horarios" aria-label="Default select example">
										<option selected>Open this select menu</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>

								</div>
								<div id="spin" class="col-12"></div>
								<button id="btn" class="btn btn-primary btn-lg" onclick="formButton()">Confirmar
									Reserva</button>
							</div>
						</div>
					</div>
				</div>
				
				
				<!-- FINAL FORMULARIO DE RESERVA -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


