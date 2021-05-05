/**
 * 
 */

 function getPago(){
	$("#cuerpo").empty();
 $.ajax({
		url: 'getPagoView.action',
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
	    	$("#cuerpo").append(data);
			//listaPago();
	    }
	});
};
/*
function listaPago(){

 $.ajax({
		url: 'getPagoDatos.action',
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
			$("#tablaPago").append("<tr><td></td><td></td><td></td><td></td></tr>");

	    }
	});
};*/