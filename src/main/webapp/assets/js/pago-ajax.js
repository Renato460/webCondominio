/**
 * 
 */

 function getPago(){
	$("#cuerpo").empty();
 $.ajax({
		url: 'getPagoAction.action',
		type: "POST",
		
		beforeSend: function (xhr){
			console.log('He entrado al sistema de Pago ');
			
		},complete: function (data) {
			console.log('Se ha completado la peticion de Pago');
			
		},error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log('Error se ha caido');
		},
	    success: function(data){
	    	console.log(data);
			
	    	//$("#cuerpo").append(data);

	    }
	});
}