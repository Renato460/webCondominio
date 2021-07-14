function menuEventos() {
    $('#cuerpo').load("../conserje/views/eventos.html", function () {
        console.log("Entramos a datatable")
        let idCondo = $("#idCondominio").text();
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
                    idCondominio: idCondo,
                }
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    text: '<i class="fas fa-calendar-plus"></i>',
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
                {"data": "idEvento"},
                {"data": "fecha"},
                {"data": "descripcion"},
                {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnEditarEvento'><i class=\"fas fa-edit\"></i></button> " +
                        " <button type='button' class='btn btn-info btnEliminarEvento'><i class=\"far fa-trash-alt\"></i></button> </div> "}
            ]
        })
    })
};
//let idEventoo;
$(document).on('click','.btnEditarEvento', function(){
    let fila = $(this).closest("tr");
    idEventoo = fila.find('td:eq(0)').text();
    let descripcion = fila.find('td:eq(2)').text();
    $("#modaleven1").modal('toggle');
    $("#descEventoedit").val(descripcion);
});
$(document).on('click','.btnEnviarFormaEventoEdit',function (e){
    e.preventDefault();
    $(".btnEnviarFormaEventoEdit").empty().append("<div class='spinner-border text-primary'></div>");
    let descripcion = $("#descEventoedit").val();
    $.ajax({
        url: "editarEvento.action",
        type:"POST",
        data:{
            idEvento:idEventoo,
            descripcion:descripcion
        }
    }).done(function(data){
        if(data.resultado === 1){
            $("#cuerpoAlerta0").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Evento Actualizado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta0").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al actualizar el evento</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarFormaEventoEdit').empty().text("Actualizar");
    });
})
$(document).on('click','.btnEliminarEvento',function(){
    let fila = $(this).closest("tr");
    idEventoo = fila.find('td:eq(0)').text();
    $.ajax({
        url:"deleteEvento.action",
        type:"POST",
        data:{
            idEvento:idEventoo
        }
    })
})