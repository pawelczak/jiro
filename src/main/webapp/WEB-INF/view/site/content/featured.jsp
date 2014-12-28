<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div class="container" >
	<div class="page-header" >
		<!--  <div class="header-icon header-contact" ></div> -->
		<div class="header-title">Polecane zdjęcia</div>
	</div>
	<div class="block-text" >Poniżej przedstawione są wybrane zdjęcia ze wszystkich galerii tematycznych</div>

	<c:forEach items="${photos}" var="photo" >
	
		<div>
			<div class="image-desc" >${photo.title}</div>
		</div>
		<div class="image-frame">
			<img src="${contextPath}/photos/${photo.src}" width="100%" />
		</div>
		
	
	</c:forEach>

</div>


