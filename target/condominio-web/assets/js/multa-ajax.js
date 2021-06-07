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
				"loadingRecords": "Cargando...",
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
				{"data": "fechaIng"}
			]
		});
	});

};