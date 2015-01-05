<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<c:if test="${!empty message}" >
	<c:choose >
		<c:when test="${message == 'addSuccess'}">
			<div class="alert alert-success" role="alert">
				<spring:message code="photo.add.success" />
			</div>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</c:if>

<div class="form-group">
	<a class="button" href="${contextPath}/admin/photoList/${categoryId}">
		<img src="${contextPath}/static/image/icons/admin/arrow-back.png" />
		<spring:message code='back' />
	</a>
</div>

<div class="panel panel-default">
  <div class="panel-heading"><spring:message code="photo.header.${formHeader}" /></div>
  <div class="panel-body">

	<form:form modelAttribute="photoForm" method="POST" class="form-horizontal" enctype="multipart/form-data" >
		<form:errors path="*" />
		<%-- <form:errors path="image" /> --%>  
		
		<div class="form-group">
			<spring:message code='category' var='springCat' />
		    <label for="inputName" class="col-sm-2 control-label"><c:out value="${springCat}" /></label>
		    <div class="col-sm-5">
		    <form:select path="cid" class="form-control">
		    	<c:forEach var="category" items="${categories}" >
		    		<option value="${category.id}" ${ photo.cid == category.id || category.id == categoryId ? 'selected' : '' } >${category.name}</option>
		    	</c:forEach>
		    </form:select>
		    </div>
	 	</div>
		<div class="form-group">
			<spring:message code='title' var='springTit' />
		    <label for="inputName" class="col-sm-2 control-label"><spring:message code='title' /></label>
		    <div class="col-sm-10">
	    	  <form:input path="title" class="form-control" id="inputName" placeholder="${springTit}" ></form:input>
		    </div>
	 	</div>
	 	<div class="form-group">
	 		<spring:message code='src' var='springSrc' />
		    <label for="inputName" class="col-sm-2 control-label"><spring:message code='src' /></label>
		    <div class="col-sm-10">
		    
		    	<c:if test="${!empty photoSrc && photoSrc != ''}">
		    		<input name="image_uploaded" type="text" class="form-control file-uploaded" value="${photoSrc}" />
		    	</c:if>
		    
		    
	    	  <input name="image" type="file" class="form-control" id="inputName" placeholder="${springSrc}" />
		    </div>
	 	</div>
	 	<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label"><spring:message code='visibility' /></label>
		    <div class="col-sm-10">
	    	  <form:checkbox path="visible" class="" value="1" ></form:checkbox>
		    </div>
	 	</div>
	 	<div class="form-group">
	 		<spring:message code='desc' var='springDesc' />
		    <label for="inputDesc" class="col-sm-2 control-label"><spring:message code='desc' />:</label>
		    <div class="col-sm-6">
	    	  <form:textarea path="description" class="form-control" id="inputDesc" placeholder="${springDesc}" ></form:textarea>
		    </div>
	 	</div>
	    <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    
		      <c:if test="${formHeader == 'add'}">
		      	<input type="submit" value="<spring:message code="photo.button.${formHeader}" />" class="btn btn-primary"  />
		      </c:if>
		    
		      <c:if test="${formHeader == 'edit'}" >
			      <input type="submit" value="<spring:message code="photo.button.${formHeader}" />" class="btn btn-primary" data-toggle="confirmation-popup" data-title="<spring:message code='confirm.title' />"
					data-placement="top" data-confirm-content="<spring:message code='confirm.edit.content' />" data-btn-yes="<spring:message code='yes' />" data-btn-no="<spring:message code='no' />"  />
			  </c:if>
			  
		      <a href="${contextPath}/admin/photoList/${categoryId}" class="btn btn-primary"><spring:message code='cancel' /></a>
		    </div>
		</div>
		
	</form:form>

  </div>
</div>


