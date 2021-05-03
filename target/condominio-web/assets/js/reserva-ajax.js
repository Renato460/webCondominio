/**
 * 
 */
 function getMenuReservas(){
	$("#cuerpo").empty();
 $.ajax({
		url: 'reserva.action',
		type: "POST",
		
		beforeSend: function (xhr){
			console.log('He entrado al sistema ');
		},complete: function (data) {
			console.log('Se ha completado la peticion');
		},error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log('Error se ha caido');
		},
	    success: function(data){
	    	$("#cuerpo").append(data);
	    }
	});
	
};

function modalFormulario(idButton){
	let datosResidente = document.getElementById('datosResidente')
	let recipient = idButton.getAttribute('data-bs-whatever')
	datosResidente.querySelector('.reserva').placeholder = recipient;
	datosResidente.querySelector('.reserva').value = recipient;
};
