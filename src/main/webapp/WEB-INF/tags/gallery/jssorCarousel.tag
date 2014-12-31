<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<%@ tag display-name="jssorCarousel" description="Form" small-icon=""%>

<%@ attribute name="photos" required="false" type="java.util.List" %>

<div class="slaidshow container">
    <div id="slider1_container" style="">
        <div u="slides" class="slider1-slides" style="">
        
        	<c:forEach var="photo" items="${photos}">
        		<div class="inside-border">
	            	<img u="image" src="${contextPath}/previewPhotos/${photo.src}" />
	            	<c:if test="${photo.description != '' }" >
	            		<div class="jssor-caption" ><c:out value="${photo.description}" /></div>
	            	</c:if>
           		</div>
        	</c:forEach>

        </div>
        
        <div style="" class="jssorb21" u="navigator">
            <div style="" u="prototype" class=""></div>
        </div>
        
        <span style="" class="jssora21l" u="arrowleft"></span>
        <span style="" class="jssora21r" u="arrowright"></span>
    </div>
</div>

