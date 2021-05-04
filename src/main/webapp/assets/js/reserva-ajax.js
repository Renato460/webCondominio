/**
 * 
 */
 
 function getHorario(){
 	let fecha = $(".fechaReserva").val();
 	let servicio = $(".reservaId").attr("placeholder");
 	console.log(fecha);
 	console.log(servicio);
 	
	$.ajax({
            url: 'dispo.action',
            type: "POST",
            data:{
                fecha:$(".fechaReserva").val(),
                servicio:$(".reservaId").attr("placeholder"),
                },
            dataType:"json",
            beforeSend: function (xhr){
            
                console.log('He entrado al sistema ');
            },complete: function (data) {
                console.log('Se ha completado la peticion');
                
            },error: function(XMLHttpRequest, textStatus, errorThrown){
                console.log('Error se ha caido');
            },
            success: function(data){
            console.log(data);
                
            }
        });
 
 };
 
 function getMenuReservas(){
	$("#cuerpo").empty();
	$("#reserva").removeAttr("onclick")
	
	
 $.ajax({
		url: 'reserva.action',
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
	    	$("#reserva").attr("onclick", "getMenuReservas()");
	    }
	});
	
};

function modalFormulario(idButton){
	let datosResidente = document.getElementById('datosResidente');
	let recipient = idButton.getAttribute('data-bs-whatever');
	datosResidente.querySelector('.reservaId').placeholder = recipient;
	datosResidente.querySelector('.reservaId').value = recipient;
	datosResidente.querySelector('.reservaId').setAttribute("value", recipient);
};
