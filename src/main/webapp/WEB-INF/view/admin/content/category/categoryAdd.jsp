<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


 <c:if test="${!empty message}" >
	<c:choose >
		<c:when test="${message == 'addSuccess'}">
			<div class="alert alert-success" role="alert">
				<spring:message code="category.add.success" />
			</div>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</c:if>
 

<div class="panel panel-default">
  <div class="panel-heading"><spring:message code="category.header.${formHeader}" /></div>
  <div class="panel-body">

	<form:form modelAttribute="categoryForm" method="POST" class="form-horizontal" >
	
		<form:errors path="name" />
		<form:errors path="description" />
		
		<div class="form-group">
			<spring:message code='name' var='name' />
		    <label for="inputName" class="col-sm-2 control-label"><c:out value="${name}" />:</label>
		    <div class="col-sm-6">
	    	  <form:input path="name" class="form-control" id="inputName" placeholder="${name}" ></form:input>
		    </div>
	 	</div>
	 	<div class="form-group">
	 		<spring:message code='desc' var='desc' />
		    <label for="inputDesc" class="col-sm-2 control-label"><c:out value="${desc}" />:</label>
		    <div class="col-sm-6">
	    	  <form:textarea path="description" class="form-control" id="inputDesc" placeholder="${desc}" ></form:textarea>
		    </div>
	 	</div>
	    <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		        <c:if test="${formHeader == 'add'}">
			      	<input type="submit" value="<spring:message code="category.button.${formHeader}" />" class="btn btn-primary"  />
		      	</c:if>
			    
		      	<c:if test="${formHeader == 'edit'}" >
				      <input type="submit" value="<spring:message code="category.button.${formHeader}" />" class="btn btn-primary" data-toggle="confirmation-popup" data-title="<spring:message code='confirm.title' />"
					data-placement="top" data-confirm-content="<spring:message code='confirm.editCategory.content' />" data-btn-yes="<spring:message code='yes' />" data-btn-no="<spring:message code='no' />"  />
				</c:if>
			      
			    <a href="${contextPath}/admin/categoryList" class="btn btn-primary"><spring:message code='cancel' /></a>
		    </div>
		</div>
		
	</form:form>

  </div>
</div>


 

