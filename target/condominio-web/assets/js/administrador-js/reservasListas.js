function setTablaServicios(){
    $('#cuerpo').load("../administracion/views/reserva-tabla.html", function () {
        console.log("Entramos a datatable")
        tablaServicio= $('#tablaServicio').DataTable({
            "language":{
                "decimal":        ",",
                "emptyTable":     "Sin datos",
                "info":           "Mostrando _START_ a _END_ de _TOTAL_ datos",
                "infoEmpty":      "Mostrando 0 a 0 de 0 datos",
                "infoFiltered":   "(filtrado de _MAX_ entradas totales)",
                "infoPostFix":    "",
                "thousands":      ".",
                "lengthMenu":     "Mostrando _MENU_ entradas",
                "loadingRecords": "<div class='spinner-border text-primary'></div>",
                "processing":     "Procesando...",
                "search":         "Buscar:",
                "zeroRecords":    "No hay coincidencias",
                "paginate": {
                    "first":      "Primero",
                    "last":       "Último",
                    "next":       "Siguiente",
                    "previous":   "Anterior"
                },
            },
            responsive: "true",
            "ajax": {
                "url":    'reserva.action',
                "type":   'POST',
                "dataSrc": "reservas"
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    extend:     'excelHtml5',
                    text:       '<i class="far fa-file-excel"></i>',
                    titleAttr:  'Exportar a Excel',
                    className:  'btn btn-success'
                },
                {
                    extend:     'pdfHtml5',
                    text:       '<i class="far fa-file-pdf"></i>',
                    titleAttr:  'Exportar a PDF',
                    className:  'btn btn-danger'
                },
                {
                    extend:     'print',
                    text:       '<i class="fas fa-print"></i>',
                    titleAttr:  'Imprimir',
                    className:  'btn btn-info'
                }
                //'excel', 'pdf', 'print'
            ],
            "columns":[
                {"data": "id_servicio"},
                {"data": "nombre_servicio"},
                {"data": "costo"},
                {"defaultContent": "<div class='text-center'> <button type='button' class='btn btn-info btnEditReserva'><i class=\"far fa-edit\"></i></button> </div> "}
            ]
        });
    });
};

$(document).on('click', '.btnEditReserva', function () {
    $("#editReservas").modal("toggle");
    let fila = $(this).closest("tr");
    let id = fila.find('td:eq(0)').text();
    let descripcion = fila.find('td:eq(1)').text();
    let monto = fila.find('td:eq(2)').text();
    $("#idReserva").val(id);
    $("#descripcionReserva").val(descripcion);
    $("#montoReserva").val(monto);
});

$(document).on('submit','#formReservaEdicion',function (e) {
    e.preventDefault();
    console.log();
    let monto = $('#montoReserva').val().replace(/\./g,'')
    $.ajax({
        url: "editarServicio.action",
        type: "POST",
        data:{
            idServicio:$("#idReserva").val(),
            descripcion:$('#descripcionReserva').val(),
            monto:monto
        }
    }).done(function (data) {
        if (data.respuesta ===1){
            $("#cuerpoAlertaEdicionServicio").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Ingresada con éxito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        }
        else {
            $("#cuerpoAlertaEdicionServicio").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al ingresar</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        }
    }).fail(function (){
        $("#cuerpoAlertaEdicionServicio").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al ingresar</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
