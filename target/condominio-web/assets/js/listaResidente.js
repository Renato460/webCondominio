
function setTabla(){
    $('#cuerpo').load("../directiva/views/tablaResidente.html", function () {
        console.log("Entramos a datatable")
        tabaResidentes =$('#tablaResidentes').DataTable({
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
                "url":    'getResidentes.action',
                "type":   'POST',
                "dataSrc": "listaResidentes"
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    extend:     'excelHtml5',
                    text:       '<i class="fs-4 far fa-file-excel"></i>',
                    titleAttr:  'Exportar a Excel',
                    className:  'btn btn-success'
                },
                {
                    extend:     'pdfHtml5',
                    text:       '<i class="fs-4 far fa-file-pdf"></i>',
                    titleAttr:  'Exportar a PDF',
                    className:  'btn btn-danger'
                },
                {
                    extend:     'print',
                    text:       '<i class="fs-4 fas fa-print"></i>',
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
                {"defaultContent": "<div class='btn-group-sm' role='group'><button type='button' class='btn btn-info btnBuscar fs-4' title='Información Multas'><i class='fas fa-search imgMostrar'></i></button>" +
                        "<button type='button' class='btn btn-warning btnAgregar fs-4' title='Agregar Multa'><i class='fas fa-plus imgIngMulta'></i></button></div>"}
            ]
        });
    });
};