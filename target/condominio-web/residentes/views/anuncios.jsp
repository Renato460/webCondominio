<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="carouselExampleControls" class="carousel slide"
	data-bs-ride="carousel">
	<div class="carousel-inner">

		<s:iterator value="anunciosLista" var="cant" status="status">
			<s:if test="#status.index.equals(0)">
				<div class="carousel-item active">
					<img src="<s:property value="#cant.getUrl()" />"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>
							<s:property value="#cant.getDescripcion()" />
						</h5>
	
					</div>
				</div>
			</s:if>
			<s:else>
    			<div class="carousel-item">
					<img src="<s:property value="#cant.getUrl()" />"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>
							<s:property value="#cant.getDescripcion()" />
						</h5>
	
					</div>
				</div>
			</s:else>
		</s:iterator>

	</div>
	<button class="carousel-control-prev" type="button"
		data-bs-target="#carouselExampleControls" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next" type="button"
		data-bs-target="#carouselExampleControls" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
	</button>
</div>