function setTablaMorosos(){
    $('#cuerpo').load("../administracion/views/morosos.html", function () {
        console.log("Entramos a datatable")
        tableResidente= $('#tablaMorosos').DataTable({
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
                "url":    'getMorosos.action',
                "type":   'POST',
                "dataSrc": "morosos",
                "data": {idCondo:0
                }
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
                {"data": "idPlanilla"},
                {"data": "rut"},
                {"data": "nombre"},
                {"data": "fechainicial"},
                {"data": "fechavencimiento"},
                {"data": "montototal"},
                {"defaultContent": "<div class='text-center'> <button type='button' class='btn btn-info btnEliminarMorosidad'><i class=\"far fa-trash-alt\"></i></button> </div> "}
            ]
        });
    });
};
$(document).on('click','.btnEliminarMorosidad', function(){
    let fila = $(this).closest("tr");
    let idPlanilla = fila.find('td:eq(0)').text();
    $.ajax({
        url: "setPagoManual.action",
        method: "POST",
        data:{
            idPlanilla:idPlanilla
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoconfirm2").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Morosidad Condonada</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoconfirm2").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al Condonar Deuda</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };


    }).fail(function () {
        $("#cuerpoconfirm2").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
})