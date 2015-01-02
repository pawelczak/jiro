<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>



<h1><spring:message code='photos.title' /></h1>

<c:if test="${!empty message}" >
	<c:choose >
		<c:when test="${message == 'editSuccess' }">
			<div class="alert alert-success" role="alert">
				<spring:message code="photo.edit.success" />
			</div>
		</c:when>
		<c:when test="${message == 'deleteSuccess'}">
			<div class="alert alert-success" role="alert">
				<spring:message code="photo.delete.success" />
			</div>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</c:if>


<div class="form-group">
	<div class="col-sm-3 control-label"><spring:message code='photos.fromCategory' />:</div>
	<div class="col-sm-5">
		<select class="form-control" >
			<c:forEach var="category" items="${categories}" varStatus="status">
				<option <c:if test="${categoryId == category.id}"> selected </c:if> onclick="window.location='${contextPath}/admin/photoList/${category.id}'; return false;" >${category.name}</option>
			</c:forEach>
		</select>
	</div>
</div>

<br><br><br>


<div class="form-group">
	<a class="button" href="${contextPath}/admin/addPhoto/${categoryId}">
		<img src="${contextPath}/static/image/icons/admin/add-image.png" />
		<spring:message code='photo.add' />
	</a>
</div>

<table class="table table-bordered table-hover">
	<tr>
		<th width="20px">#</th>
		<th><spring:message code='name' /></th>
		<th width="24px"></th>
		<th width="24px"><img src="${contextPath}/static/image/icons/visible.png" /></th>
		<th width="24px"></th>
		<th width="40" ><spring:message code='photo' /></th>
		<th width="160"><spring:message code='desc' /></th>
		<th width="150"></th>
	</tr>

	<c:forEach var="photo" items="${photos}" varStatus="status">	
	<tr>
		<td>${status.index + 1}</td>
		<td>${photo.title}</td>
		<td class="no-padding">
			<form method="POST" action="${contextPath}/admin/featurePhoto" id="form-feature-${status.index + 1}" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="hidden" name="status" value="${!photo.featured}" />
				 
				<c:choose>
					<c:when test="${photo.featured=='true'}" >
						<button class="button-feature" >
							<img src="${contextPath}/static/image/icons/star-8-24.png" />
						</button>
					</c:when>
					<c:otherwise>
						<button class="button-feature" >
							<img src="${contextPath}/static/image/icons/outline-star.png" />
						</button>
					</c:otherwise>
				</c:choose>
				 
			</form>
		</td>
		<td class="no-padding">
			<form method="POST" action="${contextPath}/admin/photoChangeVisibility" id="form-visible-${status.index + 1}" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="hidden" name="visibility" value="${!photo.visible}" />

				<c:choose>
					<c:when test="${photo.visible=='true'}" >
						<button class="button-visible" >
							<img src="${contextPath}/static/image/icons/ok-24.png" />
						</button>
					</c:when>
					<c:otherwise>
						<button class="button-visible" >
							<img src="${contextPath}/static/image/icons/admin/close.png" />
						</button>
					</c:otherwise>
				</c:choose>
			</form>			
		</td>
		<td class="no-padding">
			<c:if test="${!status.first}" >
				<form method="POST" action="${contextPath}/admin/photo/changePosition" id="form-feature-${status.index + 1}" >
					<input type="hidden" name="firstId" value="${photo.id}" />
					<input type="hidden" name="secondId" value="${photos[status.index-1].id}" />

					<button class="button-visible" >
						<img src="${contextPath}/static/image/icons/admin/arrow-up.png" />
					</button>
				</form>
			</c:if>
			<c:if test="${!status.last}" >
				<form method="POST" action="${contextPath}/admin/photo/changePosition" id="form-feature-${status.index + 1}" >
					<input type="hidden" name="firstId" value="${photo.id}" />
					<input type="hidden" name="secondId" value="${photos[status.index+1].id}" />
					
					<button class="button-visible" >
						<img src="${contextPath}/static/image/icons/admin/arrow-down.png" />
					</button>
				</form>
			</c:if>
		</td>
		<td><img src="${contextPath}/photos/${photo.src}" height="40" /></td>
		<td>${photo.description}</td>
		<td class="table-form" >
			<form method="GET" action="${contextPath}/admin/editPhoto" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="hidden" name="categoryId" value="${photo.cid}" />
				<input type="submit" class="btn btn-primary btn-sm" value="<spring:message code='edit' />"/> 
			</form>
		
			<form method="POST" action="${contextPath}/admin/deletePhoto" id="form-delete-${status.index + 1}" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="submit" class="btn btn-primary btn-sm deleteModal" value="<spring:message code='delete' />" data-toggle="confirmation-popup" data-title="<spring:message code='confirm.title' />"
					data-placement="top" data-confirm-content="<spring:message code='confirm.delete.content' />" data-btn-yes="<spring:message code='yes' />" data-btn-no="<spring:message code='no' />" />
			</form>
			
		</td>
	</tr>
	</c:forEach>

</table>





