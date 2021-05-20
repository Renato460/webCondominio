/**
 *
 */

function setTablaMulta() {
    /*$('#cuerpoMulta').append("<div class='card-header'><h5 class='card-title'>Residente</h5><p class='card-category'>Multa residente</p></div>"+
        "<div class='card-body residenteMultas'></div>"+"<div class='card-footer '><hr></div>");*/
    $('.#cuerpoMulta').append("<div class='table-responsive row'><table class=' col-12 table table-striped tablaMultas' id='tablaMultas' style='width: 100%'></table></div>");
    $('.tablaMultas').append("<thead class='text-primary'>" +
        "<th scope='col'>Id multa</th>" +
        "<th scope='col'>Descripción</th>" +
        "<th scope='col'>Monto</th>" +
        "<th scope='col'>Fecha</th>" +
        "<th scope='col'>Accion</th>" +
        "</tr>" + "</thead>");
    $('.tablaMultas').append("<tbody></tbody>")



};


function getDatosMultas(fila){
    let userRut = fila.find('td:eq(3)').text();
    $('#tablaMultas').DataTable({
        "language":{
            "decimal":        ",",
            "emptyTable":     "Sin datos",
            "info":           "Mostrando _START_ a _END_ de _TOTAL_ datos",
            "infoEmpty":      "Mostrando 0 a 0 de 0 datos",
            "infoFiltered":   "(filtrado de _MAX_ entradas totales)",
            "infoPostFix":    "",
            "thousands":      ".",
            "lengthMenu":     "Mostrando _MENU_ entradas",
            "loadingRecords": "Cargando...",
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
            "url":    'getMulta.action',
            "type":   'POST',
            "data": {rut: userRut},
            "dataSrc": "numeroMultas"
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
            {"data": "id_multa"},
            {"data": "descripcion"},
            {"data": "monto"},
            {"data": "fecha"},
            {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnEliminarMulta'><i class='fas fa-minus-circle'></i></button></div>"}
        ]
    });
};

$(document).on("click", ".btnBuscar", function () {
    $('#cuerpoMulta').empty();
    let fila = $(this).closest("tr");
    let userName= fila.find('td:eq(0)').text()+" "+fila.find('td:eq(1)').text()+" "+fila.find('td:eq(2)').text();
    let userRut = fila.find('td:eq(3)').text();
    $("#nombreResidente").val(userName);
    $("#rutResidente").val(userRut);
    setTablaMulta();
    getDatosMultas(fila);
});