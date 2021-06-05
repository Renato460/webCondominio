/**
 * 
 */
$("#btn").click(function(){
	
	//let params=$('#form_reserva').formSerialize(); //This directly serializes the values ​​in the form; it's convenient   
	//console.log(params);
	  
			
	  	});
function formButton(){
	//params = decodeURIComponent(params,true); 	     
	$("#spin").removeClass("alert alert-success");
	$('#spin').text(" ");
	$('#spin').removeAttr('role', 'alert');
	console.log($(".horarios").val());	 	
			 	$.ajax({   
	              	 url : "setReserva.action", // background handler   
	           		 type: 'post', 
	             	 dataType: 'json', // accept data format   
	            	 data: {
						fecha:$(".fechaReserva").val(),
		                servicio:$(".reservaId").attr("placeholder"),
						horarios:$(".horarios").val(),
						rut:$(".rutP").val()
						},beforeSend: function (xhr){
							$("#spin").addClass("spinner-border text-primary");
							console.log('He entrado al sistema ');
						},complete: function (data) {
							console.log('Se ha completado la peticion');
							$("#spin").removeClass("spinner-border text-primary");
						},success:function(data){
	    					console.log(data);
							$("#spin").addClass("alert alert-success"); 
							$('#spin').attr('role', 'alert');
							$('#spin').text("Reserva ingresada con éxito");
							
	    				}
				
	     	 	});return false; 
};
