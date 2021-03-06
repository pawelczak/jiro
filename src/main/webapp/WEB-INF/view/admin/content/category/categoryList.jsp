<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<h1><spring:message code='category.list' />:</h1>

<c:if test="${!empty message}" >
	<c:choose >
		<c:when test="${message == 'addSuccess'}">
			<div class="alert alert-success" role="alert">
				<spring:message code="category.add.success" />
			</div>
		</c:when>
		<c:when test="${message == 'editSuccess' }">
			<div class="alert alert-success" role="alert">
				<spring:message code="category.edit.success" />
			</div>
		</c:when>
		<c:when test="${message == 'deleteSuccess'}">
			<div class="alert alert-success" role="alert">
				<spring:message code="category.delete.success" />
			</div>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</c:if>

<div class="form-group">
	<a class="button button-nav" href="${contextPath}/admin/addCategory/${categoryId}">
		<spring:message code='category.add' />
	</a>
</div>

<table class="table table-bordered table-hover">
	<tr>
		<th width="20px">#</th>
		<th><spring:message code='name' /></th>
		<th width="24px"><img src="${contextPath}/static/image/icons/visible.png" data-toggle="tooltip" data-placement="top" title="<spring:message code="category.tooltip.visibility" />" /></th>
		<%--
		<th><spring:message code='dateAdd' /></th>
		<th><spring:message code='dateModification' /></th>
		 --%>
		<th><spring:message code='desc' /></th>
		<th width="150"></th>
	</tr>

	<c:forEach var="category" items="${categories}" varStatus="status">	
	<tr>
		<td>${status.index + 1}</td>
		<td>${category.name}</td>
		<td class="no-padding">
			<form method="POST" action="${contextPath}/admin/category/visibleChange" id="form-visible-${status.index + 1}" >
				<input type="hidden" name="id" value="${category.id}" />
				<input type="hidden" name="visibility" value="${!category.visible}" />

				<c:choose>
					<c:when test="${category.visible=='true'}" >
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
		<%--<td></td>
		<td></td>  --%>
		<td>${category.description}</td>
		<!--  <td></td> -->
		<td class="table-form" >
			<form method="GET" action="${contextPath}/admin/editCategory" >
				<input type="hidden" name="id" value="${category.id}" />
				<input type="submit" class="btn btn-primary btn-sm" value="Edytuj" />
			</form>
		
			<form method="POST" action="${contextPath}/admin/deleteCategory" id="form-delete-${status.index + 1}" >
				<input type="hidden" name="id" value="${category.id}" />
				<input type="submit" class="btn btn-primary btn-sm deleteModal" value="<spring:message code='delete' />" data-toggle="confirmation-popup" data-title="<spring:message code='confirm.title' />"
					data-placement="top" data-confirm-content="<spring:message code='confirm.deleteCategory.content' />" data-btn-yes="<spring:message code='yes' />" data-btn-no="<spring:message code='no' />" />
			</form>
		</td>
	</tr>
	</c:forEach>

</table>




