function setTablaUsuarios(){
        $('#cuerpo').load("../administracion/views/usuarios.html", function () {
            console.log("Entramos a datatable")
           tableResidente= $('#tablaResidentes').DataTable({
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
                    {"defaultContent": "<div class='text-center'><button type='button' class='btn btn-info btnEditar'><i class=\"fas fa-user-edit\"></i></button></div>"}
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
$("#formsetusuario").submit(function (e) {
    e.preventDefault();
    $('#cuerpoAlerta').empty();
    $(".btnEnviarForma").empty().append("<div class='spinner-border text-primary'></div>");
    let usuario = $('#usuario').val();
    let password =$('#password').val();
    let rol = $('#rol').val();
    let nombre = $('#nombre').val();
    let apaterno = $('#apaterno').val();
    let amaterno = $('#amaterno').val();
    let rut= $('#rut').val();
    let nacionalidad = $('#nacionalidad').val();
    let telefono = $('#telefono').val();
    let email = $('#email').val();
    let condominio = $('#condominio').val();
    let vivienda = $('#vivienda').val();

    $.ajax({
        url: "setUsuario.action",
        method: "POST",
        data: {
            usuario:usuario,
            password:password,
            idrol:rol,
            nombre:nombre,
            apaterno:apaterno,
            amaterno: amaterno,
            run:rut,
            nacionalidad:nacionalidad,
            telefono:telefono,
            correo:email,
            idvivienda:vivienda,
            idcondominio:condominio
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Usuario ingresado con exito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
            $('#usuario').val("");
            $('#password').val("");
            $('#rol').val("Seleccione Rol");
            $('#nombre').val("");
            $('#apaterno').val("");
            $('#amaterno').val("");
            $('#rut').val("");
            $('#nacionalidad').val("");
            $('#telefono').val("");
            $('#email').val("");
            $('#condominio').val("Seleccione Condominio");
            $('#vivienda').val("");
            $('.btnEnviarForma').empty().html("CONFIRMAR REGISTRO");
            tableResidente.ajax.reload();
        }else{
            $('.btnEnviarForma').empty().html("CONFIRMAR REGISTRO");
            $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al registrar el usuario</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };





    }).fail(function () {
        $("#cuerpoAlerta").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });

});
$(document).on('click','.btnEditar',function(){
    let fila = $(this).closest("tr");
    let Nombre = fila.find('td:eq(0)').text();
    let Apaterno = fila.find('td:eq(1)').text();
    let Amaterno = fila.find('td:eq(2)').text();
    let Run = fila.find('td:eq(3)').text();
    let Nacionalidad = fila.find('td:eq(4)').text();
    let Telefono = fila.find('td:eq(5)').text();
    let Correo = fila.find('td:eq(6)').text();
    $("#modalid4").modal('toggle');
    $('#nombreedit').val(Nombre);
    $('#apaternoedit').val(Apaterno);
    $('#amaternoedit').val(Amaterno);
    $('#rutedit').val(Run);
    $('#nacionalidadedit').val(Nacionalidad);
    $('#telefonoedit').val(Telefono);
    $('#correoedit').val(Correo);

});
$(document).on('click','.btnEnviarFormaEdit',function(e){
    e.preventDefault();
    $(".btnEnviarFormaEdit").empty().append("<div class='spinner-border text-primary'></div>");
    let Nombre = $('#nombreedit').val();
    let Apaterno = $('#apaternoedit').val();
    let Amaterno = $('#amaternoedit').val();
    let Run = $('#rutedit').val();
    let Nacionalidad = $('#nacionalidadedit').val();
    let Telefono = $('#telefonoedit').val();
    let Correo = $('#correoedit').val();
    $.ajax({
        url: "updateUser.action",
        type: "POST",
        data:{
            Nombre:Nombre,
            Apaterno:Apaterno,
            Amaterno:Amaterno,
            Run:Run,
            Nacionalidad:Nacionalidad,
            Telefono:Telefono,
            Correo:Correo
        }
    }).done(function (data){

        if(data.resultado === 1){
            $("#cuerpoAlerta4").append("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Actualización Completada</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");

        }else{
            $("#cuerpoAlerta4").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Error al Actualizar los datos</span>" +
                "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        };
        $('.btnEnviarFormaEdit').empty().text("Actualizar");
        tableResidente.ajax.reload(null,false);

    }).fail(function () {
        $("#cuerpoAlerta4").append("<div class='alert alert-danger alert-dismissible fade show position-relative' role='alert'>" +
            "<i class=\"fas fa-exclamation-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>No se pudo concretar la petición</span>" +
            "<button type=\"button\" class=\"btn-close btn-danger\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
    });
});
$(function (){
    $.ajax({
        url:"miniReportes.action",
        type:"POST"

    }).done(function(data){
        $("#cantmultas").html(data.cantMultas);
        $("#cantmorosos").html(data.cantMorosos);
        $("#cantcondos").html(data.cantCondos);
    })


})