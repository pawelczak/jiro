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
	<a class="button" href="${contextPath}/admin/photoList">
		<img src="${contextPath}/static/image/icons/admin/arrow-back.png" />
		Powrót
	</a>
</div>

<div class="panel panel-default">
  <div class="panel-heading"><spring:message code="photo.header.${formHeader}" /></div>
  <div class="panel-body">

	<form:form modelAttribute="photo" method="POST" class="form-horizontal" enctype="multipart/form-data" >
		<form:errors path="*" />
		<%-- <form:errors path="image" /> --%>  
		
		<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">Kategoria</label>
		    <div class="col-sm-5">
		    <form:select path="cid" class="form-control">
		    	<c:forEach var="category" items="${categories}" >
		    		<option value="${category.id}" ${ photo.cid == category.id || category.id == categoryId ? 'selected' : '' } >${category.name}</option>
		    	</c:forEach>
		    </form:select>
		    </div>
	 	</div>
		<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">Tytył</label>
		    <div class="col-sm-10">
	    	  <form:input path="title" class="form-control" id="inputName" placeholder="Tytuł zdjęcia" ></form:input>
		    </div>
	 	</div>
	 	<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">Ścieżka</label>
		    <div class="col-sm-10">
		    
		    	<c:if test="${!empty photoSrc && photoSrc != ''}">
		    		<input name="image_uploaded" type="text" class="form-control file-uploaded" value="${photoSrc}" />
		    	</c:if>
		    
		    
	    	  <input name="image" type="file" class="form-control" id="inputName" placeholder="Plik ze zdjęciem" />
		    </div>
	 	</div>
	 	<div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">Widoczność</label>
		    <div class="col-sm-10">
	    	  <form:checkbox path="visible" class="" value="1" ></form:checkbox>
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
		      <input type="submit" value="<spring:message code="photo.button.${formHeader}" />" class="btn btn-primary" />
		      <a href="${contextPath}/admin/photoList/${categoryId}" class="btn btn-primary">Anuluj</a>
		    </div>
		</div>
		
	</form:form>

  </div>
</div>


