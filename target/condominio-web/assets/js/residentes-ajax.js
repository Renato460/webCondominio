/**
 * 
 */

 function getAnuncios(){
	$("#cuerpo").empty();
 $.ajax({
		url: 'anuncio.action',
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

	    }
	});
};
$(document).ready(function(){
	getAnuncios();
	
});

