/**
 * 
 */
 function getMenuMultas(){
	$("#cuerpo").empty();
	$("#multa").removeAttr("onclick")
 $.ajax({
		url: 'multa.action',
		type: "POST",
		
		beforeSend: function (xhr){
		$("#cuerpo").addClass("spinner-border text-primary");
			console.log('He entrado al sistema ');
			
		},complete: function (data) {
			console.log('Se ha completado la peticion');
			$("#cuerpo").removeClass("spinner-border text-primary");
			
		},error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log('Error se ha caido');
		},
	    success: function(data){
	    	console.log(data);
			
	    	$("#cuerpo").append(data);
	    	$("#multa").attr("onclick", "getMenuMultas()");

	    }
	});
}