<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<%@ tag display-name="section" description="Form" small-icon=""%>

<%@ attribute name="headerLabel" required="false" %>
<%@ attribute name="galleries" required="false" type="java.util.List" %>

<div class="container gallery-section">
	<div class="sh-header">
		<div><spring:message code="${headerLabel}" /></div>
	</div>

	<div class="sh-last-added row">
	
		<c:forEach var="gallery" items="${galleries}">
		
			<div class="col-md-4">
				<div class="added-item">
					<div class="item-title"><c:out value="${gallery.category.name}" /></div>	
					<img src="${photoPath}photos/${gallery.photo.src}" />
					<div class="item-desc">
						<c:out value="${gallery.category.description}" />
					</div>
					<div class="item-center" >
						<a class="button" href="${contextPath}/gallery/${gallery.category.id}" /><spring:message code="button.watch" /></a>
					</div>
				</div>
			</div>
		
		</c:forEach>

	</div>

</div>

