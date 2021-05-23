function setTablaUsuarios(){
        $('#cuerpo').load("../administracion/views/usuarios.html", function () {
            console.log("Entramos a datatable")
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
                    "url":    'getListaResidentes.action',
                    "type":   'POST',
                    "dataSrc": "listaResidentes"
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
                    {"data": "nombre"},
                    {"data": "aPaterno"},
                    {"data": "aMaterno"},
                    {"data": "run"},
                    {"data": "nacionalidad"},
                    {"data": "telefono"},
                    {"data": "correo"},
                    {"data": "fechai"},
                    {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnBuscar'><i class='fas fa-search'></i></button></div>"}
                ]
            });
        });
    };

$(document).on('click','.btn-ingresar',function (){
  /*  $('#cuerpo').empty();
    $('#cuerpo').load("../administracion/views/registro.html");
*/

   $.ajax({
       url:'getCondominios.action',
       type: 'POST'
   }).done(function(data){

       console.log(data);
       $("#condominio").empty();
       $.each(data.condominio,function(index,value){
           let idCondominio = (value.idCondominio).toString();
           let nombre = value.nombre;
           $("#condominio").append('<option value='+idCondominio+'> '+nombre+' </option>');
       });
       $("#modalid1").modal('toggle');
   });
});
/*function getcondominios(){

}*/