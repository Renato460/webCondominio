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
	
}

function modalFormulario(){
	let datosResidente = document.getElementById('datosResidente')
	let button = document.getElementById('buttonQuincho')
	 let recipient = button.getAttribute('data-bs-whatever')
  // Extract info from data-bs-* attributes
	console.log(recipient)
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
	datosResidente.querySelector('.reserva').placeholder = recipient;
	datosResidente.querySelector('.reserva').value = recipient;
}
