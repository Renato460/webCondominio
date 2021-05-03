<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="modal fade" id="pagoTotal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Datos de su pago</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="pago.action">
					<div class="container">
						<div class="row">

							<div class='col-lg-12'>
								<div class="input-group mb-2 reservaNombre">
									<span class="input-group-text" id="basic-addon1">Rut</span>
									<input type="text" class="form-control rut" placeholder="#session['user'].rut" value="#session['user'].usuario"
										aria-label="Reserva" aria-describedby="basic-addon1" disabled>
								</div>


								<button type="submit" class="btn btn-primary btn-lg">Confirmar
									Pago</button>
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