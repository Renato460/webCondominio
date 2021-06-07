var Fn = {
    // Valida el rut con su cadena completa "XXXXXXXX-X"
    validaRut : function (rutCompleto) {
        rutCompleto = rutCompleto.replace("‐","-");
        if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test( rutCompleto ))
            return false;
        var tmp 	= rutCompleto.split('-');
        var digv	= tmp[1];
        var rut 	= tmp[0];
        if ( digv == 'K' ) digv = 'k' ;

        return (Fn.dv(rut) == digv );
    },
    dv : function(T){
        var M=0,S=1;
        for(;T;T=Math.floor(T/10))
            S=(S+T%10*(9-M++%6))%11;
        return S?S-1:'k';
    }
};

function validarRut() {
    if (Fn.validaRut( $("#rut").val() )){
        //$("#msgerror").html("El rut ingresado es válido :D");
        $("#rut").removeClass("border border-danger border-3").addClass("border border-success border-3");
        return true;
    } else {
        //$("#msgerror").html("El Rut no es válido :'( ");
        $("#rut").addClass("border border-danger border-3");
        console.log("Rut mal");
        return false;
    }
};
/*
$("#btnvalida").click(function(){
    if (Fn.validaRut( $("#txt_rut").val() )){
        $("#msgerror").html("El rut ingresado es válido :D");
    } else {
        $("#msgerror").html("El Rut no es válido :'( ");
    }
});*/