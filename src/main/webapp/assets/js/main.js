$(document).ready(function () {
    $('tabla').DataTable({
       responsive: "true",
        dom:'Bfrtilp',
        buttons:[
            {
                extends:    'excelHtml5',
                text:       '<i class="fas fa-file-excel"></i>',
                tittleAttr: 'Exportar a Excel',
                className:  'btn btn-success'
            },
            {
                extends:    'pdfHtml5',
                text:       '<i class="fas fa-file-pdf"></i>',
                tittleAttr: 'Exportar a PDF',
                className:  'btn btn-danger'
            },
            {
                extends:    'print',
                text:       '<i class="fas fa-print"></i>',
                tittleAttr: 'Imprimir',
                className:  'btn btn-info'
            },

        ]
    });
});