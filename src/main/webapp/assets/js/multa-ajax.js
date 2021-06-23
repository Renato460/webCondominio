/**
 * 
 */
function setTablaMulta() {

	$("#cuerpo").load("../residentes/views/multas.html", function () {
		$('#tablaMultas').DataTable({
			"language":{
				"decimal":        ",",
				"emptyTable":     "Sin datos",
				"info":           "Mostrando _START_ a _END_ de _TOTAL_ datos",
				"infoEmpty":      "Mostrando 0 a 0 de 0 datos",
				"infoFiltered":   "(filtrado de _MAX_ entradas totales)",
				"infoPostFix":    "",
				"thousands":      ".",
				"lengthMenu":     "Mostrando _MENU_ entradas",
				"loadingRecords": "<div class='spinner-border text-primary'></div>",
				"processing":     "Procesando...",
				"search":         "Buscar:",
				"zeroRecords":    "No hay coincidencias",
				"paginate": {
					"first":      "Primero",
					"last":       "Último",
					"next":       "Siguiente",
					"previous":   "Anterior"
				},
			},
			responsive: "true",
			"ajax": {
				"url":    'multaResidente.action',
				"type":   'POST',
				"dataSrc": "numeroMultas"
			},
			dom: 'Bfrtip',
			buttons: [
				{
					extend:     'excelHtml5',
					text:       '<i class="far fa-file-excel"></i>',
					titleAttr:  'Exportar a Excel',
					className:  'btn btn-success'
				},
				{
					extend:     'pdfHtml5',
					text:       '<i class="far fa-file-pdf"></i>',
					titleAttr:  'Exportar a PDF',
					className:  'btn btn-danger'
				},
				{
					extend:     'print',
					text:       '<i class="fas fa-print"></i>',
					titleAttr:  'Imprimir',
					className:  'btn btn-info'
				}
				//'excel', 'pdf', 'print'
			],
			"columns":[
				{"data": "id_multa"},
				{"data": "descripcion"},
				{"data": "monto"},
				{"data": "fechaIng"},
				{"defaultContent": "<div class='btn-group-sm' role='group'><button type='button' class='btn btn-info btnPagar fs-4' title='Información Multas'><i class=\"fas fa-money-bill-alt\"></i></button></div>"}
			]
		});
	});

};

$(document).on('click', '.btnPagar', function () {
	let fila = $(this).closest("tr");
	let button = this;
	let idMulta = fila.find('td:eq(0)').text();
	let descripcion = fila.find('td:eq(1)').text();
	let tipo = "multa";
	let monto = fila.find('td:eq(2)').text();
	console.log(idMulta,descripcion,tipo,monto);
	$(this).empty().append("<div class='spinner-border text-info'></div>");
	$.ajax({
		url:'pago.action',
		type: 'POST',
		data: {
			'id':idMulta,
			'desc':descripcion,
			'tipo':tipo,
			'monto':monto
		}
	}).done(function (data) {
		console.log(data);
		//window.location.href = data.urlPago;
		window.open(data.urlPago,"_blank")
		$(button).empty().append("<i class=\"fas fa-money-bill-alt\"></i>");


	});
});