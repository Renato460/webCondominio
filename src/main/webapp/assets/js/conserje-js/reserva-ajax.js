/**
 * 
 */
$(document).on('change', '#fechaDispo', function () {
	let fecha = $("#fechaDispo").val();
	if (fecha > new Date()){
		let servicio = $(".reservaId").attr("placeholder");
		console.log(fecha);
		console.log(servicio);
		$( "#horarios" ).empty();
		$.ajax({
			url: 'dispo.action',
			type: "POST",
			data:{
				fecha:fecha,
				servicio:servicio
			}
		}).done(function (data) {
			let time = data;
			let i;
			let arrayTime = time.dispo;
			let val = 0;
			for (i = 0; i < arrayTime.length; i++) {
				val=i+1;
				$( "#horarios" ).append( "<option value="+time.dispo[i].idHorario+">"+time.dispo[i].horario+"</option>" );
				console.log("#horarios");
			}
		});
	}else {

	}


});


function getMenuReservas(){
	 $('#cuerpo').load('../residentes/views/reservas.html', function (){
		 $('#tablaReservas').DataTable({
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
			 responsive: true,
			 "ajax": {
				 "url":    'getReserva.action',
				 "type":   'POST',
				 "dataSrc": "reservas"
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
				 {"data": "id"},
				 {"data": "fecha"},
				 {"data": "horario"},
				 {"data": "nombreServicio"},
				 {"data": "costo"}
			 ]
		 });
	 });

};

function modalFormulario(idButton){
	let datosResidente = document.getElementById('datosResidente');
	let recipient = idButton.getAttribute('data-bs-whatever');
	datosResidente.querySelector('.reservaId').placeholder = recipient;
	datosResidente.querySelector('.reservaId').value = recipient;
};
