
function result() {
    $.ajax({
        url:'actionPagoExitoso.action',
        type:'POST'
    }).done(function (data) {
        console.log(data);
        if(data.resultado !== 1){
            setTimeout(function () {
                result();
            },3000);
        }else {

            console.log(data.resultado)
            $(".circleCheck").empty().html("<i class=\"fas fa-check-circle fs-1 \"></i>")
            $(".tituloPago").text("Su pago ha sido confirmado, muchas gracias")
        }
    }).fail(function () {
        console.log("Error de json");
    });
}

$( document ).ready( result() );


