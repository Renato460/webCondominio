$(document).on('click','.btn-ingresarevento',function(){
    $("#modaleven").modal('toggle');
});
$("#formsetevento").submit(function(e){
    e.preventDefault();
   /* var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date+' '+time; */
    $(".btnEnviarFormaEvento").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio = $("#idCondominio").text();
    let descripcion = $('#descEvento').val();
    console.log(idCondominio);
    console.log(descripcion);
    $.ajax({
        url:"setEvento.action",
        method: "POST",
        data: {
            descripcion:descripcion,
            idCondominio:idCondominio
        }

    }).done(function(data){
        if(data.resultado === 1){
            tablaEvento.ajax.reload(null, false);
            $("#cuerpoAlerta").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Evento ingresado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el evento</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('#descEvento').val("");
        $('.btnEnviarFormaEvento').empty().text("CONFIRMAR REGISTRO");
    });
});