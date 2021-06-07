function setTablaEventosCon(){
//    $('#cuerpo').empty();
    $('#cuerpo').load("../conserje/views/eventos.html", function () {
        console.log("Entramos a datatable")

        $('#tablaEventos').DataTable({
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
                "url":    'getEvento.action',
                "type":   'POST',
                "dataSrc": "resultado", 
				"data": {idCondominio:idcondo}
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    text:'<i class="fas fa-user-plus"></i>',
                    className: 'btn btn-primary btn-ingresar '
                },
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
                {"data": "idCondominio"},
                {"data": "nombre"},
                {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnBuscar'><i class='fas fa-search'></i></button></div>"}
            ]
        });

    });

};