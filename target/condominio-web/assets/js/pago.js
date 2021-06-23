(function () {
    $.ajax({
        url:'actionPagoExitoso.action',
        type:'POST'
    }).done(function (data) {
        console.log(data);
<<<<<<< HEAD
=======
    }).fail(function () {
        console.log("Error de json");
>>>>>>> 09f75bf8e5459fc744bdc95e9cf099fab9929ce5
    });
});