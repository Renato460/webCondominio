
function setAnuncio() {
    $('#cuerpo').load('../directiva/views/vistaSetAnuncio.html');
};

$(document).on('submit','#formAnuncio',function (e) {
    e.preventDefault();
    console.log($(this));
    let data = document.getElementById('formAnuncio');
    let file = ($('#anuncioFoto'))[0].files[0];
    let fileName = file.name;
    let descripcion = $('#descripcionAnuncio').val();
    let formData = new FormData();
    formData.append('file',file);
    formData.append('fileFileName',fileName);
    formData.append('descripcion', descripcion);
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


$(document).on('change', '#anuncioFoto', function (){
   let file = ($('#anuncioFoto'))[0].files[0];
   if (file){
     const reader = new FileReader();
       $('.defaultText').addClass('d-none');
       $('.image-preview_Image').removeClass('d-none').addClass('d-block');

     reader.addEventListener('load', function () {
         $('.image-preview_Image').attr("src", this.result);
     });

     reader.readAsDataURL(file);
   }else {
       $('.defaultText').removeClass('d-none');
       $('.image-preview_Image').removeClass('d-block').addClass('d-none');
       $('.image-preview_Image').attr("src", "");
   };
});
