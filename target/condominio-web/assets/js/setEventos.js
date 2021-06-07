$(document).on('click','.btn-ingresar',function (){
    $.ajax({
        url:'getCondominios.action',
        type: 'POST'
    }).done(function(data){

        console.log(data);
        $("#condominio").empty();
        $.each(data.condominio,function(index,value){
            let idCondominio = (value.idCondominio).toString();
            let nombre = value.nombre;
            $("#condominio").append('<option value='+idCondominio+'> '+nombre+' </option>');
        });
        $("#modaleven").modal('toggle');
    });
});

$("#formsetevento").submit(function(e){
    e.preventDefault();
    $(".btnEnviarForma").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio = $('#condominio').val();
    let fecha = $('#fechaEvento').val();
    let descripcion = $('#descEvento').val();

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