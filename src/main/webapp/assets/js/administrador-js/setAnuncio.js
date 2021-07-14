
function setAnuncio() {
    $('#cuerpo').load('../directiva/views/vistaSetAnuncio.html');



};

$(document).on('submit','#formAnuncio',function (e) {
    e.preventDefault();
    //console.log($(this));

    let data = document.getElementById('formAnuncio');
    let file = ($('#anuncioFoto'))[0].files[0];
    let fileName = file.name;
    //let descripcion = $('#descripcionAnuncio').val();
    let descripcion = $('#summernote').val();

    if (descripcion.length >= 400) {
        //val.value = val.value.substring(0, 500);
        console.log(descripcion.length);
        $('.aviso').html("<div class=\"alert alert-warning\" role=\"alert\">\n" +
            "  No puede ser más de 400 caracteres\n" +
            "</div>");
    } else {
        //$('#charNum').text(400 - len);
        $('.aviso').empty();
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
                $("#respuestaExitosaAnuncio").show( "slow" ).delay(4000).hide( "slow" );

            }else {

                $("#respuestaErrorAnuncio").show( "slow" ).delay(4000).hide( "slow" );
            }
        });
    }
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
