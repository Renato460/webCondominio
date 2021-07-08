(function () {
    $.ajax({
        url:'actionPagoExitoso.action',
        type:'POST'
    }).done(function (data) {
        console.log(data);
    }).fail(function () {
        console.log("Error de json");
    });
});