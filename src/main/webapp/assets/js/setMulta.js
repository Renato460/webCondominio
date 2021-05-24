
$(document).on("click", ".btnAgregar", function () {
    let fila = $(this).closest("tr");
    let userNombre = fila.find('td:eq(0)').text()+" "+fila.find('td:eq(1)').text()+" "+fila.find('td:eq(2)').text();
    let userRut = fila.find('td:eq(3)').text();
    $('#nombreResidente').val(userNombre);
    $('#rutResidente').val(userRut);
    $("#residenteMultas").modal("toggle");
});

$(document).on('click', '.btnEnviarForma', function () {
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
        tabaResidentes.ajax.reload(null, false);
    });
});