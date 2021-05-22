/**
 *
 */
/*
function setTablaMulta() {
    /*$('#cuerpoMulta').append("<div class='card-header'><h5 class='card-title'>Residente</h5><p class='card-category'>Multa residente</p></div>"+
        "<div class='card-body residenteMultas'></div>"+"<div class='card-footer '><hr></div>");
    $('#cuerpoMulta').append("<div class='table-responsive row'><table class=' col-12 table table-striped tablaMultas' id='tablaMultas' style='width: 100%'></table></div>");
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
            {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-danger btnEliminarMulta'><i class='fas fa-minus-circle'></i></button></div>"}
        ]
    });
};*/
/*
function getTablaMultas(userRut){
    let tablaMultas = "<table className=' col-12 table table-striped tablaMultas' id='tablaMultas' style='width: 100%'>"+
        "<thead className='text-primary'>"+
        "<tr><th scope='col'>Id multa</th>"+
            "<th scope='col'>Descripción</th>"+
            "<th scope='col'>Monto</th>"+
            "<th scope='col'>Fecha</th>"+"</tr>"+"</thead><tbody>";
    $.ajax({
        url: "getMulta.action",
        type:"POST",
        async:false,
        data:{rut: userRut}
    }).done(function( data ) {
        console.log(data.numeroMultas);
            $.each(data.numeroMultas,function(index,value){
                console.log(value.descripcion);
                let id_multa = (value.id_multa).toString();
                let descripcion = value.descripcion;
                let monto = value.monto;
                let fechaIng = value.fechaIng;
                tablaMultas +="<tr><td>"+id_multa+"</td><td>"+descripcion+"</td><td>$"+monto+"</td><td>"+fechaIng+"</td></tr>";

            });
            tablaMultas+="</tbody></table>";

        });
    console.log(tablaMultas);
    return tablaMultas;
};*/


$(document).on("click", ".btnBuscar", function () {
    let fila = $(this).closest("tr");
    let userRut = fila.find('td:eq(3)').text();
    let cantMultas = fila.find('td:eq(7)').text();
    let row = $("#tablaResidentes").DataTable().row(fila);
    let imgButton = this.firstChild;
    let buttonSearch = this;
    if (!(cantMultas==='0')){
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            fila.removeClass('shown');
            imgButton.classList.remove("fa-search-minus");
            buttonSearch.classList.remove("btn-danger");
            imgButton.classList.add("fa-search");
            buttonSearch.classList.add("btn-info");
        }
        else {
            // Open this row
            let tablaMultas = "<table className=' col-12 table table-striped tablaMultas' id='tablaMultas' style='width: 100%'>"+
                "<thead className='text-primary'>"+
                "<tr><th scope='col'>Id multa</th>"+
                "<th scope='col'>Descripción</th>"+
                "<th scope='col'>Monto</th>"+
                "<th scope='col'>Fecha</th>"+"</tr>"+"</thead><tbody>";
            $.ajax({
                url: "getMulta.action",
                type:"POST",
                data:{rut: userRut}
            }).done(function( data ) {

                imgButton.classList.remove("fa-search");
                buttonSearch.classList.remove("btn-info");
                imgButton.classList.add("fa-search-minus");
                buttonSearch.classList.add("btn-danger");
                $.each(data.numeroMultas,function(index,value){
                    let id_multa = (value.id_multa).toString();
                    let descripcion = value.descripcion;
                    let monto = parseInt(value.monto).toLocaleString("es-CL");
                    let fechaIng = value.fechaIng;
                    let dt = new Date(fechaIng).toLocaleDateString()
                    tablaMultas +="<tr><td>"+id_multa+"</td><td>"+descripcion+"</td><td>$"+monto+"</td><td>"+dt+"</td></tr>";

                });
                tablaMultas+="</tbody></table>";
                row.child( tablaMultas ).show();

                fila.addClass('shown');
            });
        }
    }
});


/*$(document).on("click", ".btnBuscar", function () {
    let fila = $(this).closest("tr");
    let userRut = fila.find('td:eq(3)').text();
    let row = $("#tablaResidentes").DataTable().row(fila);
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            fila.removeClass('shown');
        }
        else {
            // Open this row
            row.child( getTablaMultas(userRut) ).show();

            fila.addClass('shown');
        }
});*/
/*
$(document).on("click", ".btnBuscar", function () {
    $('#cuerpoMulta').empty();
    let fila = $(this).closest("tr");
    let userName= fila.find('td:eq(0)').text()+" "+fila.find('td:eq(1)').text()+" "+fila.find('td:eq(2)').text();
    let userRut = fila.find('td:eq(3)').text();
    $("#nombreResidente").val(userName);
    $("#rutResidente").val(userRut);
    setTablaMulta();
    getDatosMultas(fila);
});*/