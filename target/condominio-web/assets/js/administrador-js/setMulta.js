
$(document).on("click", ".btnAgregar", function () {
    let fila = $(this).closest("tr");
    let userNombre = fila.find('td:eq(0)').text()+" "+fila.find('td:eq(1)').text()+" "+fila.find('td:eq(2)').text();
    let userRut = fila.find('td:eq(3)').text();
    $('#nombreResidente').val(userNombre);
    $('#rutResidente').val(userRut);
    $("#residenteMultas").modal("toggle");
});

$(document).on('submit', '#formMulta', function (e) {
    e.preventDefault();
    $('#cuerpoAlerta').empty();
    $(".btnEnviarForma").empty().append("<div class='spinner-border text-primary'></div>");
    //$("#btnEnviarForma").append("<div class='spinner-border text-primary'></div>");
    let userRut = $('#rutResidente').val();
    let  descripcionMulta = $('#descMulta').val();
    let  montoDeMulta = $('#montoMulta').val();
    $.ajax({
        url: "setMulta.action",
        method: "POST",
        data: {
            rutResidente: userRut,
            descMulta:descripcionMulta,
            montoMulta:montoDeMulta
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Ingresada con éxito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
            tabaResidentes.ajax.reload(null, false);
        }else{
            $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al ingresar la Multa</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarForma').empty().text("INGRESAR MULTA");
        //$('.btnEnviarForma').text("INGRESAR MULTA");

        $('#descMulta').val("");
        $('#montoMulta').val("");

    }).fail(function () {
        $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});

