/**
 * 
 */

 function getAnuncios(){

 	$.ajax({
		url: 'anuncio.action',
		type: "POST"
	}).done(function (data) {
		$.each(data.anunciosLista, function (index,value) {
			$('.owl-carousel').append("<div class=\"card anuncioCard mb-3\" style=\"max-width: 540px;\">\n" +
				"<div class=\"row g-0\">\n" +
				"<div class=\"col-md-4\">\n" +
				"<a href="+value.url+" class=\"fancybox \" data-fancybox=\"gallery1\">\n" +
				"<img src="+value.url+" class=\"img-fluid rounded-start w-100\" style=\"height: 35vh;\" alt=\"...\" id=\"anuncioImg\">\n" +
				"</a>\n" +
				"</div>\n" +
				"<div class=\"col-md-8\">\n" +
				"<div class=\"card-body anuncioBody\" style=\"height: 35vh;\">\n" +
				"<p class=\"card-text textAnuncio\">"+value.descripcion+"</p>\n" +
				"</div>\n" +
				"</div>\n" +
				"</div>\n" +
				"</div>\n");

		});


			$('.owl-carousel').owlCarousel({
				loop: true,
				autoplay:true,
				margin:10,
				stagePadding: 10,
				responsive:{
					0:{items:1},
					600:{items:1},
					1000:{items:2},
					1400:{items:3}
				}
			});



	});

};
$(document).ready(function(){
	getAnuncios();
	
});

