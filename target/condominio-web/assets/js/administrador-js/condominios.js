function setTablaViviendas(){
    $('#cuerpo').load("../administracion/views/condominios.html", function(){
        $.ajax({
            url:'getCondominios.action',
            type: 'POST'
        }).done(function(data){

            console.log(data);
            $("#condominioviv").empty();
            $.each(data.condominio,function(index,value){
                let idCondominio = (value.idCondominio).toString();
                let nombre = value.nombre;
                $("#condominioviv").append('<option value='+idCondominio+'> '+nombre+' </option>');
            });
        });
    });
};
$(document).on('click','.btnEnviarCondominio',function () {
    $('.tablaCondominios').load("../administracion/views/tablaviviendas.html", function(){
        let condominio = $('#condominioviv').val();
        $('#tablaCondominios').DataTable({
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
                "url":    'getViviendas.action',
                "type":   'POST',
                "dataSrc": "vivienda",
                "data": {idCondo:condominio
                }
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    titleAttr: 'Ingresar Vivienda',
                    text:'<i class="fas fa-house-user"></i>',
                    className: 'btn btn-primary btn-ingresarVivienda'
                },
                {
                    titleAttr: 'Ingresar Gastos Comunes',
                    text:'<i class="fas fa-file-invoice-dollar"></i>',
                    className: 'btn btn-primary btn-ingresargcs'
                },
                {
                    titleAttr: 'Mostrar Gastos Comunes',
                    text:'<i class="fas fa-calculator"></i>',
                    className: 'btn btn-primary btn-mostrargcs'
                }
            ],
            "columns":[
                {"data": "idVivienda"},
                {"data": "nroVivienda"},
                {"data": "titular"},
                {"data": "rutTitular"},
                {"defaultContent": "<div class='text-center'> <button type='button' class='btn btn-info btnEditarViv ml-2'><i class=\"fas fa-edit\"></i></button></div> "}
            ]
        });
    });
    //$(".btnEnviarCondominio").empty().append("<div class='spinner-border text-primary'></div>");


});

$(document).on('click','.btn-ingresarCondo',function (){
        $("#modalid2").modal('toggle');
        $.ajax({
            url:'getRegiones.action',
            type: 'POST'
        }).done(function(data){

        console.log(data);

        $("#region").empty().append('<option > Seleccione Región </option>');

        $.each(data.regiones,function(index,value){
            let idRegion = (value.idRegion).toString();
            let nombre = value.nombreRegion;

            $("#region").append('<option value='+idRegion+'> '+nombre+' </option>');
        });
    });
});

$(document).on('change','#region',function (){
    console.log(this.value);
    $.ajax({
        url: 'getComunas.action',
        type: 'POST',
        data:{
            idRegion:this.value
        }
    }).done(function(data){
        console.log(data)
        $('#comunas').empty().append('<option > Seleccione Comuna </option>');;

        $.each(data.comunas,function(index,value){
            let idComuna = (value.idComuna).toString();
            let nombre = value.nombreComuna;

            $("#comunas").append('<option value='+idComuna+'> '+nombre+' </option>');
        });
    });
});
$('#formsetcondominio').submit(function(e){
    e.preventDefault();
    $('#cuerpoAlerta2').empty();
    $(".btnEnviarForma").empty().append("<div class='spinner-border text-primary'></div>");
    let nombreCondominio = $('#nombrecondo').val();
    let calle = $('#calle').val();
    let numero = $('#numero').val();
    let idComuna = $('#comunas').val();
    $.ajax({
        url: "setCondominio.action",
        method: "POST",
        data: {
            nombre: nombreCondominio,
            numero: numero,
            calle: calle,
            idComuna: idComuna
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta2").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Condominio ingresado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta2").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el condominio</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarForma').empty().text("CONFIRMAR REGISTRO");

        $('#nombrecondo').val("");
        $('#calle').val("");
        $('#numero').val("");
        $('#comunas').val("");


    }).fail(function () {
        $("#cuerpoAlerta2").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
$(document).on('click','.btn-mostrargcs', function(){
    $('.tablaCondominios').load("../administracion/views/tablagastoscomunes.html", function(){
        let condominio = $('#condominioviv').val();
        $('#tablaGastosComunes').DataTable({
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
                "url":    'getGastosComunes.action',
                "type":   'POST',
                "dataSrc": "gastocomun",
                "data": {idCondo:condominio
                }
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    titleAttr: 'Ingresar Vivienda',
                    text:'<i class="fas fa-house-user"></i>',
                    className: 'btn btn-primary btn-ingresarVivienda'
                },
                {
                    titleAttr: 'Ingresar Gastos Comunes',
                    text:'<i class="fas fa-file-invoice-dollar"></i>',
                    className: 'btn btn-primary btn-ingresargcs'
                },
                {
                    titleAttr: 'Mostrar Gastos Comunes',
                    text:'<i class="fas fa-calculator"></i>',
                    className: 'btn btn-primary btn-mostrargcs'
                }
            ],
            "columns":[
                {"data": "idGastocomun"},
                {"data": "descripcion"},
                {"data": "valor"},
                {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnEliminar'><i class=\"far fa-trash-alt\"></i></button> " +
                        "<button type='button' class='btn btn-info btnEditarGC ml-2'><i class=\"fas fa-edit\"></i></button></div> "}
            ]
        });
    });
    //$(".btnEnviarCondominio").empty().append("<div class='spinner-border text-primary'></div>");
});

$(document).on('click','.btn-ingresarVivienda',function(){
    $("#modalid3").modal('toggle');
});
$(document).on('click','.btn-ingresargcs',function(){
    $("#modalid5").modal('toggle');
});
let idViviendad;
$(document).on('click','.btnEditarViv',function(){
    let fila = $(this).closest("tr");
    idViviendad = fila.find('td:eq(0)').text();
    let nroVivienda = fila.find('td:eq(1)').text();
    let titular = fila.find('td:eq(2)').text();
    let ruttitular = fila.find('td:eq(3)').text();
    $("#modalid7").modal('toggle');
    $("#editnumerovivienda").val(nroVivienda);
    $("#edittitular").val(titular);
    $("#editruttitular").val(ruttitular);
});
$(document).on('click','.btnEnviarFormaeditVivienda',function (e){
    e.preventDefault();
    $(".btnEnviarFormaeditVivienda").empty().append("<div class='spinner-border text-primary'></div>");
    let nroVivienda = $("#editnumerovivienda").val();
    let titular=$("#edittitular").val();
    let ruttitular=$("#editruttitular").val();
    $.ajax({
        url:"updateVivienda.action",
        method: "POST",
        data:{
            idVivienda: idViviendad,
            nroVivienda: nroVivienda,
            titular: titular,
            ruttitular: ruttitular,
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta7").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Vivienda Actualizada</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta7").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al Actualizar la Vivienda </span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };

        $('.btnEnviarFormaeditVivienda').empty().text("Actualizar");

    }).fail(function () {
        $("#cuerpoAlerta7").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
})
let idGastocomunn;
$(document).on('click','.btnEditarGC',function(){
    let fila = $(this).closest("tr");
    idGastocomunn = fila.find('td:eq(0)').text();
    let descripcion = fila.find('td:eq(1)').text();
    let valor = fila.find('td:eq(2)').text();
    $("#modalid6").modal('toggle');
    $("#editnombregc").val(descripcion);
    $("#editValorgc").val(valor);
});
$(document).on('click','.btnEnviarUpdate',function(e){
    e.preventDefault();
    $(".btnEnviarUpdate").empty().append("<div class='spinner-border text-primary'></div>");
    console.log(idGastocomunn);
    let descripcion = $("#editnombregc").val();
    let valor = $("#editValorgc").val();
    $.ajax({
        url:"updateGastoComun.action",
        method: "POST",
        data:{
            idGastocomun:idGastocomunn,
            descripcion:descripcion,
            valor:valor,
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta6").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Gasto Comun Actualizado</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta6").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al Actualizar el Gasto Comun</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };

        $('.btnEnviarUpdate').empty().text("Actualizar");

    }).fail(function () {
        $("#cuerpoAlerta6").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
})
$(document).on('click','.btnEliminar',function(){
    let fila = $(this).closest("tr");
    let idGastocomun = fila.find('td:eq(0)').text();
    $.ajax({
        url:"deleteGastoComun.action",
        method: "POST",
        data:{
            idGastocomun:idGastocomun,
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoconfirm1").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Gasto Comun Eliminado</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoconfirm1").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al Eliminar el Gasto Comun</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };


    }).fail(function () {
        $("#cuerpoconfirm1").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
$('#formsetvivienda').submit(function(e){
     e.preventDefault();
     $('#cuerpoAlerta3').empty();
    $(".btnEnviarFormaVivienda").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio= $('#condominioviv').val();
    let nroVivienda = $('#numerovivienda').val();
    let titular = $('#titular').val();
    let ruttitular = $('#ruttitular').val();
    $.ajax({
        url: "setVivienda.action",
        method:"POST",
        data:{
            nroVivienda:nroVivienda,
            idCondominio:idCondominio,
            titular: titular,
            ruttitular: ruttitular,
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta3").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Vivienda ingresada con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta3").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar la vivienda</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarFormaVivienda').empty().text("CONFIRMAR REGISTRO");
        $('#condominioviv').val("");
        $('#numerovivienda').val("");
        $('#titular').val("");
        $('#ruttitular').val("");


    }).fail(function () {
        $("#cuerpoAlerta3").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
$('#formsetgastocomun').submit(function(e){
    e.preventDefault();
    $('#cuerpoAlerta5').empty();
    $(".btnEnviarFormagc").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio= $('#condominioviv').val();
    let descripcion = $('#nombregc').val();
    let valor = $('#Valorgc').val();
    $.ajax({
        url: "setGastoComun.action",
        method:"POST",
        data:{
            idCondominio:idCondominio,
            descripcion:descripcion,
            valor:valor,
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta5").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Gasto Común ingresado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta5").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el Gasto comun</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarFormagc').empty().text("CONFIRMAR REGISTRO");




    }).fail(function () {
        $("#cuerpoAlerta3").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
