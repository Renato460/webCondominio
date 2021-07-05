/**
 * 
 */
function formButton(){
	//params = decodeURIComponent(params,true);
	$('#spin').empty();
	if(validarRut()){

		$('#spin').text(" ").removeAttr('role', 'alert');
		$("#spin").removeClass("alert alert-success").addClass("spinner-border text-primary");
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
			$("#spin").removeClass("spinner-border text-primary alert alert-danger").addClass("alert alert-success");

			$('#spin').attr('role', 'alert').text("Reserva ingresada con éxito");

		});
	}else{
		$('#spin').addClass("alert alert-danger").html("Rut incorrecto");
	};

};
