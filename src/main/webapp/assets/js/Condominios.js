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
                }
            ],
            "columns":[
                {"data": "idVivienda"},
                {"data": "nroVivienda"},
                {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnBuscar'><i class='fas fa-search'></i></button></div>"}
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
$(document).on('click','.btn-ingresarVivienda',function(){
    $("#modalid3").modal('toggle');
});
$('#formsetvivienda').submit(function(e){
     e.preventDefault();
     $('#cuerpoAlerta3').empty();
    $(".btnEnviarFormaVivienda").empty().append("<div class='spinner-border text-primary'></div>");
    let idCondominio= $('#condominioviv').val();
    let nroVivienda = $('#numerovivienda').val();
    $.ajax({
        url: "setVivienda.action",
        method:"POST",
        data:{
            nroVivienda:nroVivienda,
            idCondominio:idCondominio,
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




    }).fail(function () {
        $("#cuerpoAlerta3").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
