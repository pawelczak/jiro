<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<%@ tag display-name="categoryForm" description="Form" small-icon=""%>

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

	<form:form modelAttribute="category" method="POST" class="form-horizontal" >
	
		<form:errors path="name" />
		<form:errors path="description" />
		
		<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">Nazwa:</label>
		    <div class="col-sm-6">
	    	  <form:input path="name" class="form-control" id="inputName" placeholder="Nazwa" ></form:input>
		    </div>
	 	</div>
	 	<div class="form-group">
		    <label for="inputDesc" class="col-sm-2 control-label">Opis:</label>
		    <div class="col-sm-6">
	    	  <form:textarea path="description" class="form-control" id="inputDesc" placeholder="Opis" ></form:textarea>
		    </div>
	 	</div>
	    <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" value="<spring:message code='category.button.${formHeader}' />"  class="btn btn-primary" />
		    </div>
		</div>
		
	</form:form>

  </div>
</div>

