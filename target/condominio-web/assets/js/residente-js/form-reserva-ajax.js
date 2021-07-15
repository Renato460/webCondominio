/**
 * 
 */
function formButton(){
	//params = decodeURIComponent(params,true);
	$('#spin').empty();
	if(validarRut()){

		//$('#spin').text(" ").removeAttr('role', 'alert');
		$(".btnReserva").empty().html("<div class=\"spinner-border text-white\" role=\"status\">\n" +
			"  <span class=\"visually-hidden\">Loading...</span>\n" +
			"</div>")
		//$("#spin").removeClass("alert alert-success").addClass("spinner-border text-white");
		//$('#spin').removeAttr('role', 'alert');
		$.ajax({
			url:	"setReserva.action",
			type:	'POST',
			data:	{
				fecha:$(".fechaReserva").val(),
				servicio:$(".reservaId").attr("placeholder"),
				horarios:$(".horarios").val(),
				rut:$(".rutP").val()
			}
		}).done(function (data){


			console.log(data);
			if (data.exito){
				tablaReserva.ajax.reload(null, false);
				$("#spin").html("<div class=\"alert alert-success\" role=\"alert\">\n" +
					"  Reserva ingresada con éxito\n" +
					"</div>");
				$(".btnReserva").empty().text("Confirmar Reserva");
				$("#datosResidente").modal("hide");
			}else {
				$("#spin").html("<div class=\"alert alert-danger\" role=\"alert\">\n" +
					"  Hubo un problema con su reserva\n" +
					"</div>");
				$(".btnReserva").empty().text("Confirmar Reserva");
			}
		});
	}else{
		//$('#spin').addClass("alert alert-danger").html("Rut incorrecto");
	};
};
