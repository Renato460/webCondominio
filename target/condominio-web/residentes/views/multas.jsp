<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="mt-2 mb-3">
	<h4>Revisa tus Multas</h4>
</div>
<s:bean name="webCondominio.model.modelLoginUsuario" var="rut">
    <s:param name="rut" value="##session['user'].usuario"></s:param>
</s:bean>

<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">Id Multa</th>
			<th scope="col">Descripción</th>
			<th scope="col">Monto</th>
			<th scope="col">Fecha</th>
		</tr>
	</thead>
	<tbody>

		<s:iterator value="numeroMultas" var="cant" status="status">
			<tr>
				<td><s:property value="#cant.getId_multa()" /></td>
				<td><s:property value="#cant.getDescripcion()" /></td>
				<td><s:property value="#cant.getMonto()" /></td>
				<td><s:property value="#cant.getFecha()" /></td>
			</tr>
		</s:iterator>



	</tbody>
</table>
