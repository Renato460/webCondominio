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
                "<th scope='col'>Fecha</th>"+"</tr>"+"</thead><tbody>";
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
                    let dt = new Date(fechaIng).toLocaleDateString()
                    tablaMultas +="<tr><td>"+id_multa+"</td><td>"+descripcion+"</td><td>$"+monto+"</td><td>"+dt+"</td></tr>";
                });

                tablaMultas+="</tbody></table>";
                row.child( tablaMultas ).show();

                fila.addClass('shown');
            });

        };
    }
});
