function setTablaGastosComunes(){

    $('#cuerpo').load("../administracion/views/planillas.html", function () {
        console.log("Entramos a datatable")
        tablaplani=$('#tablaPlanillas').DataTable({
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
                "url":    'getPlanillas.action',
                "type":   'POST',
                "dataSrc": "planillas"
            },
            dom: 'Bfrtip',
            buttons: [

            ],
            "columns":[
                {data: "nroVivienda"},
                {data: "idPlanilla"},
                {data: "rut"},
                {data: "nombre"},
                {data: "apaterno"},
                {data:"fecha"},
                {data: "montoTotal"},
                {data: "fechavenc"},
                {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnConfirmarPago'><i class=\"fas fa-check-square\">Confirmar Pago</i></button></div>"}
            ]
        });
    });
}
$(document).on('click','.btnConfirmarPago',function(){
    let fila = $(this).closest("tr");
    let idPlanilla = fila.find('td:eq(1)').text();
    $(".btnConfirmarPago").empty().append("<div class='spinner-border text-primary'></div>");
    $.ajax({
        url: "setPagoManual.action",
        type: "POST",
        data:{
            idPlanilla:idPlanilla
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta4").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Pago Gasto comun confirmado</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta4").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el pago del gasto comun</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };

        tablaplani.ajax.reload(null,false);

    }).fail(function () {
        $("#cuerpoAlerta4").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });

});

