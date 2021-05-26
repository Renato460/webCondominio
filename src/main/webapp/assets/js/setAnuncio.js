function setAnuncio() {
    $('#cuerpo').load('../directiva/views/vistaSetAnuncio.html');
    /*$.ajax({
        url:'views/vistaSetAnuncio.txt',
        method:'GET'
    }).done(function (data) {
        console.log(data);
        $('#cuerpo').append(data);
    });
    /*let formulario = $('.formAnuncio').html("<input type='file' id='file'><input type='submit' value='Submit'>");
    $('#cuerpo').append(formulario);*/

};

$(document).on('submit','#formAnuncio',function (e) {
    e.preventDefault();
    console.log($(this));
    let data = document.getElementById('formAnuncio');
    let file = ($('#anuncioFoto'))[0].files[0];
    let fileName = file.name;
    let formData = new FormData();
    formData.append('file',file);
    formData.append('fileFileName',fileName)
    console.log(formData);
    $.ajax({
        url:'setImagenAnuncio.action',
        type:'POST',
        data: formData,
        async:true,
        cache:false,
        contentType: false,
        processData: false

    }).done(function (data) {
        console.log(data);
        $('#cuerpo').append(data);
    });
});
