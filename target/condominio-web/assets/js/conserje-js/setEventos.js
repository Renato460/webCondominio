$(document).on('click','.btn-ingresarevento',function(){
    $("#modaleven").modal('toggle');
});
$("#formsetevento").submit(function(e){
    e.preventDefault();
    $(".btnEnviarForma").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio = $('#condominioeven').val();
    let fecha = $('#fechaEvento').val();
    let descripcion = $('#descEvento').val();
    console.log(idCondominio);
    console.log(fecha);
    console.log(descripcion);
    $.ajax({
        url:"setEvento.action",
        method: "POST",
        data: {
            fecha:fecha,
            descripcion:descripcion,
            idCondominio:idCondominio
        }

    }).done(function(data){
        if(data.resultado === 1){
            tablaEvento.ajax.reload(null, false);
            $("#cuerpoAlerta").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Usuario ingresado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el usuario</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarForma').empty().text("CONFIRMAR REGISTRO");
    });
});