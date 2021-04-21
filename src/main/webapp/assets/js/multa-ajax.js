/**
 * 
 */
 function getMenuMultas(){
	$("#cuerpo").append(' ');
 $.ajax({
		url: 'multa.action',
		type: "POST",
		
		beforeSend: function (xhr){
			console.log('He entrado al sistema ');
			
		},complete: function (data) {
			console.log('Se ha completado la peticion');
			
		},error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log('Error se ha caido');
		},
	    success: function(data){
	    	console.log(data);
			
	    	$("#cuerpo").append(data);
			$("#modal").modal('show');
			$("#modalTexto").text('Bienvenido al modulo de multas');
	    }
	});
}