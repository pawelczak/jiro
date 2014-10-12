<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div class="container gallery" >
	<div class="page-header" >
		<!--  <div class="header-icon header-contact" ></div> -->
		<div class="header-title">Galeria</div>
	</div>
	<p></p>


	<c:forEach items="${galleries}" var="gallery" varStatus="status" >
	
		<c:if test="${status.index % 3 == 0}">
			<div class="row">
		</c:if>
	
		<div class="col-md-4 gallery-item">
			<a href="${contextPath}/gallery/${gallery.category.id}" >
				
				<img src="${contextPath}/photos/${gallery.image.src}" />
				
				<div class="gallery-desc">
					<span>${gallery.category.name}</span>
					<p>${gallery.category.description}</p>	
					<div>Wszystkie fotografie</div>
				</div>
			</a>
		</div>
	
		<c:if test="${status.index % 3 == 2}">
			</div>
		</c:if>
	
	</c:forEach>

	<c:if test="${status.index % 3 != 2}">
		</div>
	</c:if>

</div>

