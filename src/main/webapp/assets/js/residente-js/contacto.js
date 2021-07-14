function contacto(){
    $("#cuerpo").load("../residentes/views/contacto.html")
}

$(document).on("submit",'#formularioContacto', function (event) {
    event.preventDefault();
    let email = $("#emailContacto").val();
    let assunto = $("#assunto").val();
    let mensaje = $("#mensaje").val();
    $(".mailTO").attr("href",`mailto:mailprueba@mailprueba.cl?subject=${assunto} ${email}&body=${mensaje}`);
    document.querySelector(".mailTO").click();

});