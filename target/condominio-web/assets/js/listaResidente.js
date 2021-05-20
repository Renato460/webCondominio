/*
function getAjax(){

    $.ajax({
        url: 'getListaResidentes.action',
        type: "POST",

        beforeSend: function (xhr){
            // $("#cuerpo").addClass("spinner-border text-primary");
            console.log('He entrado al sistema ');

        },complete: function (data) {
            console.log('Se ha completado la peticion');
            //$("#cuerpo").removeClass("spinner-border text-primary");

        },error: function(XMLHttpRequest, textStatus, errorThrown){
            console.log('Error se ha caido');

        },
        success: function(data){
            console.log(data.listaResidentes)
            //listaResidente = data.listaResidentes;
            setTabla(data.listaResidentes)
            //$("#cuerpo").append(data);
            //$("#home").attr("onclick", "getAnuncios()");
        }
    });
};*/

function setTabla() {
    console.log("entramos");
    $('#cuerpo').append("<div class='card-header'><h5 class='card-title'>Residentes</h5><p class='card-category'>Información residentes</p></div>"+
    "<div class='card-body residenteLista'></div>"+"<div class='card-footer '><hr></div>");
    $('.residenteLista').append("<div class='table-responsive row'><table class=' col-12 table table-striped tablaResidentes' id='tablaResidentes' style='width: 100%'></table></div>");
    $('.tablaResidentes').append("<thead class='text-primary'>" +"<tr>"+"<th scope='col'>Nombre</th>" +
        "<th scope='col'>Apellido P</th>" +
        "<th scope='col'>Apellido M</th>" +
        "<th scope='col'>Run</th>" +
        "<th scope='col'>Nacionalidad</th>" +
        "<th scope='col'>Telefono</th>" +
        "<th scope='col'>Correo</th>" +
        "<th scope='col'>Cantidad Multas</th>" +
        "<th scope='col'>Acciones</th>" +
        "</tr>" + "</thead>");
    $('.tablaResidentes').append("<tbody></tbody>")

    getDatos();

};

function getDatos(){
    $('#tablaResidentes').DataTable({
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
            "url":    'getListaResidentes.action',
            "type":   'POST',
            "dataSrc": "listaResidentes"
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
            {"data": "nombre"},
            {"data": "aPaterno"},
            {"data": "aMaterno"},
            {"data": "run"},
            {"data": "nacionalidad"},
            {"data": "telefono"},
            {"data": "correo"},
            {"data": "cantidad_multas"},
            {"defaultContent": "<div class='text-center'><button type='button' data-bs-toggle='modal' data-bs-target='#residenteMultas' class='btn btn-info btnBuscar'><i class='fas fa-search'></i></button></div>"}
        ]
    });
};