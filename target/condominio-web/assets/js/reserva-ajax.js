/**
 * 
 */
$(document).on('change', '#fechaDispo', function () {
	let fecha = $("#fechaDispo").val();
	let servicio = $(".reservaId").attr("placeholder");
	console.log(fecha);
	console.log(servicio);
	$( "#horarios" ).empty();
	$.ajax({
		url: 'dispo.action',
		type: "POST",
		data:{
			fecha:fecha,
			servicio:servicio
		}
	}).done(function (data) {
		let time = data;
		let i;
		let arrayTime = time.dispo;
		let val = 0;
		for (i = 0; i < arrayTime.length; i++) {
			val=i+1;
			$( "#horarios" ).append( "<option value="+time.dispo[i].idHorario+">"+time.dispo[i].horario+"</option>" );
			console.log("#horarios");
		}
	});

});


function getMenuReservas(){
	 $('#cuerpo').load('../residentes/views/reservas.html');
	 $('#multicancha').attr('src', '${ pageContext.request.contextPath }/assets/img/reservas/multicancha.jpg');
};

function modalFormulario(idButton){
	let datosResidente = document.getElementById('datosResidente');
	let recipient = idButton.getAttribute('data-bs-whatever');
	datosResidente.querySelector('.reservaId').placeholder = recipient;
	datosResidente.querySelector('.reservaId').value = recipient;
};
