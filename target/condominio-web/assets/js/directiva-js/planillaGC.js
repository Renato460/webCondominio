function setTablaGastosComunesDirectiva(){

    $('#cuerpo').load("../directiva/views/planillasGcDirectiva.html", function () {
        console.log("Entramos a datatable")
        $('#tablaPlanillasDrirectiva').DataTable({
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
                {data: "fechavenc"}
            ]
        });
    });
}