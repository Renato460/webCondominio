
function setAnuncio() {
    $('#cuerpo').load('../directiva/views/vistaSetAnuncio.html');
};

$(document).on('submit','#formAnuncio',function (e) {
    e.preventDefault();
    //console.log($(this));
    let data = document.getElementById('formAnuncio');
    let file = ($('#anuncioFoto'))[0].files[0];
    let fileName = file.name;
    let descripcion = $('#descripcionAnuncio').val();
    let formData = new FormData();
    formData.append('file',file);
    formData.append('fileFileName',fileName);
    formData.append('descripcion', descripcion);
    //console.log(formData);





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
        if(data.resultado===1){
            $("#respuestaAnuncio").html("<div class='alert alert-success alert-dismissible fade show position-relative' role='alert'>" +
                "<i class=\"fas fa-check-circle fs-4\"></i><span class='fw-bold position-absolute top-50 start-50 translate-middle'>Anuncio ingresado con éxito</span>" +
                "<button type=\"button\" class=\"btn-close btn-success\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
        }

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
