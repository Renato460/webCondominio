/**
 *
 */

$(document).on("click", ".btnBuscar", function (e) {
    console.log("Entramos a las multas")
    let fila = $(this).closest("tr"); //con esto puedo traerme
    let userRut = fila.find('td:eq(3)').text();
    let cantMultas = fila.find('td:eq(7)').text();
    let row = $("#tablaResidentes").DataTable().row(fila);
    let imgButton = this.firstChild;
    let buttonSearch = this;
    if (!(cantMultas==='0')){
        if ( row.child.isShown() ) {
            row.child.hide();
            fila.removeClass('shown');
            $(".imgMostrar").removeClass("fa-search-minus").addClass('fa-search');
            $(this).removeClass("btn-danger").addClass("btn-info");
        }
        else {
            $(this).empty().append("<div class='spinner-border text-info'></div>");
            // Open this row
            let tablaMultas = "<table class=' col-12 table tablaMultas' id='tablaMultas' style='width: 100%'>"+
                "<thead class='text-primary'>"+
                "<tr><th scope='col'>Id multa</th>"+
                "<th scope='col'>Descripción</th>"+
                "<th scope='col'>Monto</th>"+
                "<th scope='col'>Fecha</th>"+
                "<th scope='col'>Acciones</th>"+
                "</tr>"+"</thead><tbody>";
            $.ajax({
                url: "getMulta.action",
                type:"POST",
                data:{rut: userRut}
            }).done(function( data ) {
                console.log(buttonSearch);
                $(buttonSearch).removeClass("btn-info").addClass("btn-danger").empty().append("<i class=\"fas fs-4 fa-search-minus imgMostrar\"></i>");
                /*$(buttonSearch).empty();
                $(buttonSearch).append("<i class=\"fas fs-4 fa-search-minus imgMostrar\"></i>")*/
                $.each(data.numeroMultas,function(index,value){
                    let id_multa = (value.id_multa).toString();
                    let descripcion = value.descripcion;
                    let monto = parseInt(value.monto).toLocaleString("es-CL");
                    let fechaIng = value.fechaIng;
                    //let dt = new Date(fechaIng).toLocaleDateString()
                    let buttonEdit="<div class='btn-group-sm' role='group'><button type='button' class='btn btn-success btnEditarMulta fs-4' title='Información Multas'><i class=\"far fa-edit\"></i></i></button>" +
                        "<button type='button' class='btn btn-danger btnEliminar fs-4' title='Agregar Multa'><i class=\"far fa-trash-alt\"></i></button></div>"
                    tablaMultas +="<tr><td>"+id_multa+"</td><td>"+descripcion+"</td><td>"+monto+"</td><td>"+fechaIng+"</td><td>"+buttonEdit+"</td></tr>";
                });

                tablaMultas+="</tbody></table>";
                row.child( tablaMultas ).show();

                fila.addClass('shown');
            });

        };


    }
});

$(document).on('click','.btnEditarMulta', function () {
    $("#editMultas").modal("toggle");
    let fila = $(this).closest("tr"); //con esto puedo traerme
    let idMulta = fila.find('td:eq(0)').text();
    let descripcion = fila.find('td:eq(1)').text();
    let monto = fila.find('td:eq(2)').text();
    console.log(idMulta);
    $("#idMulta").val(idMulta);
    $("#descripcionMulta").val(descripcion);
    $("#montoMultaEdicion").val(monto);


});

$(document).on('submit','#formMultaEdicion',function (e) {
    e.preventDefault();
    console.log();
    let monto = $('#montoMultaEdicion').val().replace(/\./g,'')
    $.ajax({
       url: "editarMulta.action",
       type: "POST",
       data:{
           idMulta:$("#idMulta").val(),
           descripcion:$('#descripcionMulta').val(),
           monto:monto
       }
    }).done(function (data) {
        if (data.respuesta===1){
            $("#cuerpoAlertaEdicion").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Ingresada con éxito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        }else {$("#cuerpoAlertaEdicion").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al ingresar</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        }

    }).fail(function (){
        $("#cuerpoAlertaEdicionServicio").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al ingresar</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});

$(document).on('click', ".btnEliminar", function () {
    let fila = $(this).closest("tr"); //con esto puedo traerme
    let idMulta = fila.find('td:eq(0)').text();
    $(".btnEliminar").empty().html("<div class=\"spinner-border text-white\" role=\"status\">\n" +
        "  <span class=\"visually-hidden\">Loading...</span>\n" +
        "</div>");
    $.ajax({
        url: "deleteMulta.action",
        type: "POST",
        data:{
            idMulta:idMulta
        }
    }).done(function (data) {
        tabaResidentes.ajax.reload(null, false);
        $(".btnEliminar").empty().html("<i class=\"far fa-trash-alt\"></i>");
       /* $("#cuerpoAlertaEdicion").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Ingresada con éxito</span>" +
            "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");*/
    });
});
