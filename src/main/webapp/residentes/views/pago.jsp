<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<h2>Tabla de pagos</h2>
<div class="input-group col-12">
  <span class="input-group-text">Fecha</span>
  <input id="fechaPago" type="date" aria-label="fecha" class="form-control col-6">
  <div class="col-6">
  <button type="button" class="btn btn-primary col-lg-12" onclick="listaPago()">Buscar</button></div>

</div>
<table class="table table-striped mt-3">
	<thead>
		<tr>
			<th scope="col">Descripción</th>
			<th scope="col">Monto</th>
		</tr>
	</thead>
	<tbody  id="tablaPago" class="tablaPago">




	</tbody>
</table>
<form method="POST" action="pago.action"><button type="submit" class="btn btn-primary col-lg-12">Pago de cuentas</button></div></form>
