<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div class="container gallery-single">

	

	<div class="page-header" >
		<div class="link-back"><a href="${contextPath}/gallery" >Powrót</a></div>
	
		<div class="header-title"><spring:message code="gallery.header" /> "${category.name}"</div>
	</div>

	<c:forEach items="${photos}" var="photo" varStatus="status">
	
		<c:if test="${status.index % 3 == 0}">
			<div class="row">
		</c:if>
		
		<div class="col-md-4">
			<div class="image-title">${photo.title}</div> 
			<div class="image-frame" >
				<img id="gi-${status.index}" class="gallery-image" src="${photoPath}/photos/${photo.src}" width="100%" data-title="${photo.title}" />
			</div>
		</div>
	
		<c:if test="${status.index % 3 == 2}">
			</div>
		</c:if>
	
	</c:forEach>

	<c:if test="${status.index % 3 != 2}">
		</div>
	</c:if>
</div>