function getMenuServicios(){
    $('#cuerpo').load('../conserje/views/reservasConserje.html', function (){
        tablaAllReserva = $('#tablaAllReservas').DataTable({
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
            responsive: true,
            "ajax": {
                "url":    'getAllReserva.action',
                "type":   'POST',
                "dataSrc": "reservas"
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
                {"data": "id"},
                {"data": "fecha"},
                {"data": "nombre"},
                {"data": "horario"},
                {"data": "nombreServicio"},
                {"data": "costo"}
            ]
        });
        $.ajax({
            url: 'reserva.action',
            type: "POST",

        }).done(function (data) {
            console.log(data);
            let multiCosto = data.reservas[0].costo;
            let salaCosto = data.reservas[1].costo
            let quinchoValor = data.reservas[2].costo
            let estacionamientoCosto = data.reservas[3].costo;
            $('.multiCosto').text("$ "+multiCosto);
            $('.salaCosto').text("$ "+salaCosto);
            $('.quinchoCosto').text("$ "+quinchoValor);
            $('.estacionamientoCosto').text("$ "+estacionamientoCosto);
        });
    });

};
$(document).on('change', '#fechaDispo', function () {
    let fecha = new Date($("#fechaDispo").val());
    $("#horarios").empty();
    console.log(fecha.toLocaleDateString());

    let fechaHoy = new Date;
    console.log(fechaHoy.toLocaleDateString());
    if (fecha.toLocaleDateString() > fechaHoy.toLocaleDateString()){
        $(".avisoFecha").empty();
        let servicio = $(".reservaId").attr("placeholder");
        console.log(fecha);
        console.log(servicio);
        $( "#horarios" ).empty();
        $.ajax({
            url: 'dispo.action',
            type: "POST",
            data:{
                fecha:$("#fechaDispo").val(),
                servicio:servicio
            }
        }).done(function (data) {
            let time = data;
            let i;
            let arrayTime = time.dispo;
            let val = 0;
            for (i = 0; i < arrayTime.length; i++) {
                val=i+1;
                $( "#horarios" ).append( "<option value="+time.dispo[i].idHorario+">"+time.dispo[i].horario+"</option>" );
                console.log("#horarios");
            }
        });
    }else {
        $(".avisoFecha").append("<div class=\"alert alert-danger\" role=\"alert\">\n" +
            "  Fecha debe ser mayor a la de Hoy!!!\n" +
            "</div>")
    }


});

function modalFormulario(idButton){
    let datosResidente = document.getElementById('datosResidente');
    let recipient = idButton.getAttribute('data-bs-whatever');
    datosResidente.querySelector('.reservaId').placeholder = recipient;
    datosResidente.querySelector('.reservaId').value = recipient;
};

function formButton(){
    //params = decodeURIComponent(params,true);
    $('#spin').empty();
    if(validarRut()){

        //$('#spin').text(" ").removeAttr('role', 'alert');
        $(".btnReserva").empty().html("<div class=\"spinner-border text-white\" role=\"status\">\n" +
            "  <span class=\"visually-hidden\">Loading...</span>\n" +
            "</div>")
        //$("#spin").removeClass("alert alert-success").addClass("spinner-border text-white");
        //$('#spin').removeAttr('role', 'alert');
        $.ajax({
            url:	"setReserva.action",
            type:	'POST',
            data:	{
                fecha:$(".fechaReserva").val(),
                servicio:$(".reservaId").attr("placeholder"),
                horarios:$(".horarios").val(),
                rut:$(".rutP").val()
            }
        }).done(function (data){


            console.log(data);
            if (data.exito){

                tablaAllReserva.ajax.reload(null, false);
                $("#spin").html("<div class=\"alert alert-success\" role=\"alert\">\n" +
                    "  Reserva ingresada con éxito\n" +
                    "</div>");
                $(".btnReserva").empty().text("Confirmar Reserva");
                $("#datosResidente").modal("hide");
            }else {
                $("#spin").html("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Hubo un problema con su reserva\n" +
                    "</div>");
                $(".btnReserva").empty().text("Confirmar Reserva");
            }
        });
    }else{
        //$('#spin').addClass("alert alert-danger").html("Rut incorrecto");
    };
};
