/**
 *
 */
function setTablaGastoComunResidente() {

    $("#cuerpo").load("../residentes/views/gastosComunes.html", function () {
        $('#tablaGastoComun').DataTable({
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
            responsive: true,
            "ajax": {
                "url":    'getPlanillaByRut.action',
                "type":   'POST',
                "dataSrc": "planillas"
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
                {"data": "fecha"},
                {"data": "montoTotal"},
                {"data": "fechavenc"},
                {"data": "montoReserva"},
                {"data": "montoGastoComun"},
                {"defaultContent": "<button type='button' class='btn btn-success btnPagarGasto fs-4' title='Pagar Gastos Comunes'><i class=\"fas fa-money-bill-alt\"></i></button>"}
            ]
        });

        $('#tablaGastoComunCancelado').DataTable({
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
            responsive: true,
            "ajax": {
                "url":    'planillaPagada.action',
                "type":   'POST',
                "dataSrc": "planillas"
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
                {"data": "fecha"},
                {"data": "montoTotal"},
                {"data": "fechavenc"},
                {"data": "montoReserva"},
                {"data": "fechaPago"},
                {"data": "montoGastoComun"}
            ]
        });
    });
};


$(document).on('click', '.btnPagarGasto', function () {
    let fila = $(this).closest("tr");
    let button = this;
    let idGasto = fila.find('td:eq(0)').text();
    let descripcion = "Gastos Comunes";
    let tipo = "gastoComun";
    let monto = fila.find('td:eq(2)').text();
    console.log(idGasto,descripcion,tipo,monto);
    $(this).empty().append("<div class='spinner-border text-white'></div>");
    $.ajax({
        url:'pago.action',
        type: 'POST',
        data: {
            'id':idGasto,
            'desc':descripcion,
            'tipo':tipo,
            'monto':monto
        }
    }).done(function (data) {
        console.log(data.urlPago);
        //window.location.href = data.urlPago;

        window.open(data.urlPago);

        $(button).empty().append("<i class=\"fas fa-money-bill-alt\"></i>");


    });
});
