<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>



<h1>Fotografie</h1>

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
	<div class="col-sm-3 control-label">Zdjęcia z kategorii:</div>
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
	<a class="button" href="${contextPath}/admin/addPhoto/${categoryId}">Dodaj zdjęcie</a>
</div>

<table class="table table-bordered table-hover">
	<tr>
		<th width="20px">#</th>
		<th>Nazwa</th>
		<th width="24px"></th>
		<th width="24px"><img src="${contextPath}/static/image/icons/visible.png" /></th>
		<th width="40" >Zdjęcie</th>
		<th width="160">Opis</th>
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
		<td><img src="${contextPath}/photos/${photo.src}" height="40" /></td>
		<td>${photo.description}</td>
		<td class="table-form" >
			<form method="GET" action="${contextPath}/admin/editPhoto" >
				<input type="hidden" name="id" value="${photo.id}" />
				<input type="submit" class="btn btn-primary btn-sm" value="Edytuj" />
			</form>
		
			<form method="POST" action="${contextPath}/admin/deletePhoto" id="form-delete-${status.index + 1}" >
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





