<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>



<h1>Preview Fotografie</h1>

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
	<a class="button" href="${contextPath}/admin/previewPhoto/add">
		<img src="${contextPath}/static/image/icons/admin/add-image.png" />
		Dodaj zdjęcie
	</a>
</div>

<table class="table table-bordered table-hover">
	<tr>
		<th width="20px">#</th>
		<th>Nazwa</th>
		<th width="24px"><img src="${contextPath}/static/image/icons/visible.png" /></th>
		<th width="24px"></th>
		<th width="40" >Zdjęcie</th>
		<th >Opis</th>
		<th width="150"></th>
	</tr>

	<c:forEach var="photo" items="${previewPhotos}" varStatus="status">	
	<tr>
		<td>${status.index + 1}</td>
		<td>${photo.title}</td>
		<td class="no-padding">
			<form method="POST" action="${contextPath}/admin/previewPhoto/visibleChange" id="form-visible-${status.index + 1}" >
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
				<form method="POST" action="${contextPath}/admin/previewPhoto/changePosition" id="form-feature-${status.index + 1}" >
					<input type="hidden" name="firstId" value="${photo.id}" />
					<input type="hidden" name="secondId" value="${previewPhotos[status.index-1].id}" />

					<button class="button-visible" >
						<img src="${contextPath}/static/image/icons/admin/arrow-up.png" />
					</button>
				</form>
			</c:if>
			<c:if test="${!status.last}" >
				<form method="POST" action="${contextPath}/admin/previewPhoto/changePosition" id="form-feature-${status.index + 1}" >
					<input type="hidden" name="firstId" value="${photo.id}" />
					<input type="hidden" name="secondId" value="${previewPhotos[status.index+1].id}" />
					
					<button class="button-visible" >
						<img src="${contextPath}/static/image/icons/admin/arrow-down.png" />
					</button>
				</form>
			</c:if>
		</td>
		<td><img src="${contextPath}/previewPhotos/${photo.src}" height="40" /></td>
		<td>${photo.description}</td>
		<td class="table-form" >
			<form method="GET" action="${contextPath}/admin/previewPhoto/edit" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="submit" class="btn btn-primary btn-sm" value="Edytuj" />
			</form>
		
			<form method="POST" action="${contextPath}/admin/previewPhoto/delete" id="form-delete-${status.index + 1}" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="submit" class="btn btn-primary btn-sm deleteModal" value="Usuń" data-toggle="modal" data-target="deleteModal"  />
				<!--
				<a href="#" class="btn btn-primary btn-sm deleteModal" data-toggle="modal" data-target="deleteModal" onclick="$('#delete-form').on('click', function() {$('#form-delete-${status.index + 1}').submit();});" >Usuń</a>
				  -->
			</form>
		</td>
	</tr>
	</c:forEach>

</table>





