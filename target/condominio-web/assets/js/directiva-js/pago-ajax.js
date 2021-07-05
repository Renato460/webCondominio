/**
 * 
 */

 function getPagoTotal(){
	$("#cuerpo").empty();
 $.ajax({
		url: 'pagoTotal.action',
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
	    	

	    }
	});
};



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

	    }
	});
};

function listaPago(){

 $.ajax({
		url: 'getPagoDatos.action',
		type: "POST",
		data:{fecha:$("#fechaPago").val()},
		beforeSend: function (xhr){
			console.log('He entrado al sistema de Pago ');
			
		},complete: function (data) {
			console.log('Se ha completado la peticion de Pago');
			
		},error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log('Error se ha caido');
		},
	    success: function(data){
	    	console.log(data);
			$.each(data.arrayPago,function(indice,item){
				console.log(item.montoGastoComun);
				var gastoComun = item.montoGastoComun;
				var gastoComunFinal = parseInt(gastoComun).toLocaleString();
				var montoMulta = item.montoMulta;
				var montoMultaFinal = parseInt(montoMulta).toLocaleString();
				var montoReserva = item.montoReserva;
				var montoReservaFinal = parseInt(montoReserva).toLocaleString();
				$("#tablaPago").append("<tr><td>Gasto Común</td><td>$"+gastoComunFinal+"</td></tr>");
				$("#tablaPago").append("<tr><td>Multa</td><td>$"+montoMultaFinal+"</td></tr>");
				$("#tablaPago").append("<tr><td>Reserva</td><td>$"+montoReservaFinal+"</td></tr>");
			});
					    }
	});
};