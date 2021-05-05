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

 /*function formButton(event){
	event.preventDefault();
	
	//var _form = $(event.target);
    //var _formData = _form.serialize(true);

        $.ajax({
            type: "POST",
            url: "setReserva.action",
            data: {
				fecha:$(".fechaReserva").val(),
                servicio:$(".reservaId").attr("placeholder"),
				horarios:$(".horarios").val(),
				rut:$(".rutP").val()
	
			},
			dataType:"json",
			
            error:function(XMLHttpRequest, textStatus, errorThrown){
				console.log('Error se ha caido');
				},
			success: function(data){
	    		console.log(data);

	    	}
        });
};
	








/*$(function(){
	
    $("#form_reserva").on("submit", function(e){
    	let idServicio= $("#horarios").val();
		console.log(idServicio);          
        // Cancelamos el evento si se requiere 
        e.preventDefault();
 
        // Obtenemos los datos del formulario 
        let f = $(this);
        let formData = new FormData(document.getElementById("form_reserva"));
        formData.append("dato", "valor");
        console.log(formData);
        // Enviamos los datos al archivo PHP que procesará el envio de los datos a un determinado correo 
        $.ajax({
            url: "setReserva.action",
            type: "post",
            dataType: "json",
            data: formData,
            beforeSend: function() {
              //$('.msg').html("<img src='img/ajax-loader.gif' />");
            },
        })
 
        // Cuando el formulario es enviado, mostramos un mensaje en la vista HTML 
        // En el archivo enviarcorreo.php devuelvo el valor '1' el cual es procesado con jQuery Ajax 
        // y significa que el mensaje se envio satisfactoriamente. 
        .done(function (res) {                  
 			console.log(res);
          /*if(res.a == "1"){
                    
            // Mostramos el mensaje 'Tu Mensaje ha sido enviado Correctamente !' 
            $(".msg").html(res.b);                   
            $("#formulario_contacto").trigger("reset");    
 
          }  else {                                       
            $(".msg").html(res.b); 
          }
                                                      
        })
 
        // Mensaje de error al enviar el formulario 
        .fail(function (res) {                    
           // $(".msg").html(res.b);
        });
 
    });
});*/