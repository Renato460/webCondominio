function cards() {
    $.ajax({
        url:'getPlanillaByRut.action',
        type:'POST'
    }).done(function (data) {

        if(data.planillas.length>1){

            $(".alertaMorosidad").html("<div class=\"alert alert-danger justify-content-center d-flex align-items-center\" role=\"alert\">\n" +
                "<i class=\"fas fa-exclamation-triangle fs-3 mx-2\"></i>\n"+
                "  <strong>Tiene pagos de gastos comunes morosos</strong>\n" +
                "</div>");
            let montoTotalDeuda =0;
            $.each(data.planillas,function (index, value) {

                montoTotalDeuda+=value.montoTotal;
            });
            $(".gastoCard").text("$ "+montoTotalDeuda);
        }
        if(data.planillas.length===1){

            $(".gastoCard").text("$ "+data.planillas[0].montoTotal);
            //let fechaVenc = new Date(data.planillas[0].fechavenc).toLocaleDateString();
            let fechaVenc = new Date(data.planillas[0].fechavenc).toLocaleDateString();

            console.log(fechaVenc);

            console.log(convertDateFormat(fechaVenc));
            let date = new Date(convertDateFormat(fechaVenc));
            console.log(date.toLocaleDateString("cl-CL"))


            if (fechaVenc<new Date()){
                $(".moroso").html("<div class=\"alert alert-danger justify-content-center d-flex align-items-center\" role=\"alert\">\n" +
                    "<i class=\"fas fa-exclamation-triangle fs-3 mx-2\"></i>\n"+
                    "  Su Gasto Común ha vencido\n" +
                    "</div>");
            }else{

                $(".moroso").html("<div class=\"alert alert-info justify-content-center d-flex align-items-center\" role=\"alert\">\n" +
                    "<i class=\"fas fa-info-circle fs-3 mx-2\"></i>\n"+
                    " <strong>Aún tiene tiempo para pagar sus gastos comunes</strong>\n" +
                    "</div>");
            }
        }else {
            $(".gastoCard").text(0);
        }
        setTimeout(function () {
            cards()
        },100000);
    });

    $.ajax({
        url:'multaResidente.action',
        type:'POST'
    }).done(function (data) {

        if (data.numeroMultas.length>0){
            $(".morosoCard").text(data.numeroMultas.length);
        }else {
            $(".morosoCard").text(0);
        }

    });
}

function convertDateFormat(string) {
    var info = string.split('-');
    return info[1] + '-' + info[0] + '-' + info[2];
}

$(document).ready(function () {
    cards();
});