(function () {
    $.ajax({
        url:'actionPagoExitoso.action',
        type:'POST'
    }).done(function (data) {
        console.log(data);
    });
});