/**
 *
 */

$(document).on("click", ".btnBuscar", function () {
    let fila = $(this).closest("tr");
    let userRut = fila.find('td:eq(3)').text();
    let cantMultas = fila.find('td:eq(7)').text();
    let row = $("#tablaResidentes").DataTable().row(fila);
    let imgButton = this.firstChild;
    let buttonSearch = this;
    if (!(cantMultas==='0')){
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            fila.removeClass('shown');
            imgButton.classList.remove("fa-search-minus");
            buttonSearch.classList.remove("btn-danger");
            imgButton.classList.add("fa-search");
            buttonSearch.classList.add("btn-info");
        }
        else {
            // Open this row
            let tablaMultas = "<table className=' col-12 table table-striped tablaMultas' id='tablaMultas' style='width: 100%'>"+
                "<thead className='text-primary'>"+
                "<tr><th scope='col'>Id multa</th>"+
                "<th scope='col'>Descripción</th>"+
                "<th scope='col'>Monto</th>"+
                "<th scope='col'>Fecha</th>"+"</tr>"+"</thead><tbody>";
            $.ajax({
                url: "getMulta.action",
                type:"POST",
                data:{rut: userRut}
            }).done(function( data ) {

                imgButton.classList.remove("fa-search");
                buttonSearch.classList.remove("btn-info");
                imgButton.classList.add("fa-search-minus");
                buttonSearch.classList.add("btn-danger");
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
        }
    }
});
