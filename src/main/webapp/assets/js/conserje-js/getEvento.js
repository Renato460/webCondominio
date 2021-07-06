$(document).on('click','.btnEnviarCondominioeven',function(){
    console.log("Entramos a datatable")
    let idCondo=$('#condominioeven').val();
    console.log(idCondo);
    tablaEvento = $('#tablaEventos').DataTable({
        "language": {
            "decimal": ",",
            "emptyTable": "Sin datos",
            "info": "Mostrando _START_ a _END_ de _TOTAL_ datos",
            "infoEmpty": "Mostrando 0 a 0 de 0 datos",
            "infoFiltered": "(filtrado de _MAX_ entradas totales)",
            "infoPostFix": "",
            "thousands": ".",
            "lengthMenu": "Mostrando _MENU_ entradas",
            "loadingRecords": "<div class='spinner-border text-primary'></div>",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "No hay coincidencias",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            },
        },
        responsive: "true",
        "ajax": {
            "url": 'getEvento.action',
            "type": 'POST',
            "dataSrc": "resultado",
            "data": {
                idCondominio:idCondo,
            }
        },
        dom: 'Bfrtip',
        buttons: [
            {
                text: '<i class="fas fa-user-plus"></i>',
                className: 'btn btn-primary btn-ingresarevento '
            },
            {
                extend: 'excelHtml5',
                text: '<i class="far fa-file-excel"></i>',
                titleAttr: 'Exportar a Excel',
                className: 'btn btn-success'
            },
            {
                extend: 'pdfHtml5',
                text: '<i class="far fa-file-pdf"></i>',
                titleAttr: 'Exportar a PDF',
                className: 'btn btn-danger'
            },
            {
                extend: 'print',
                text: '<i class="fas fa-print"></i>',
                titleAttr: 'Imprimir',
                className: 'btn btn-info'
            }
            //'excel', 'pdf', 'print'
        ],
        "columns": [
            {"data": "id"},
            {"data": "fecha"},
            {"data": "descripcion"},

        ]
    });
});
//    $('#cuerpo').empty();



function menuCondos() {
    $('#cuerpo').load("../conserje/views/eventos.html", function(){
    $.ajax({
        url: 'getCondominios.action',
        type: 'POST'
    }).done(function (data) {

        console.log(data);
        $("#condominioeven").empty();
        $.each(data.condominio, function (index, value) {
            let idCondominio = (value.idCondominio).toString();
            let nombre = value.nombre;
            $("#condominioeven").append('<option value=' + idCondominio + '> ' + nombre + ' </option>');
        });
    });
    });
};
