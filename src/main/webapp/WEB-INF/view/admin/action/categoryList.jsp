<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<h1>Lista kategorii:</h1>

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

<table class="table table-bordered table-hover">
	<tr>
		<th width="20px">#</th>
		<th>Nazwa</th>
		<th width="24px" ></th>
		<th>Data dodania</th>
		<th>Data modyfikacji</th>
		<th>Opis</th>
		<!--  <th>Liczba zdjęć</th>  -->
		<th width="140"></th>
	</tr>

	<c:forEach var="category" items="${categories}" varStatus="status">	
	<tr>
		<td>${status.index + 1}</td>
		<td>${category.name}</td>
		<td></td>
		<td></td>
		<td></td>
		<td>${category.description}</td>
		<!--  <td></td> -->
		<td class="table-form" >
			<form method="GET" action="${contextPath}/admin/editCategory" >
				<input type="hidden" name="id" value="${category.id}" />
				<input type="submit" class="btn btn-primary btn-sm" value="Edytuj" />
			</form>
		
			<form method="POST" action="${contextPath}/admin/deleteCategory" id="form-delete-${status.index + 1}" >
				<input type="hidden" name="id" value="${category.id}" />
				<input type="submit" class="btn btn-primary btn-sm deleteModal" value="Usuń" data-toggle="modal" data-target="deleteModal"  />
				<!--
				<button class="btn btn-primary btn-sm deleteModal" data-toggle="modal" data-target="deleteModal" >Usun</button>
				 
				<a href="#" class="btn btn-primary btn-sm deleteModal" data-toggle="modal" data-target="deleteModal" onclick="$('#delete-form').on('click', function() {$('#form-delete-${status.index + 1}').submit();});" >Usuń</a>
				 -->
			</form>
		</td>
	</tr>
	</c:forEach>

</table>


<!-- Modal -->

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Potwierdzenie Usuwania</h4>
      </div>
      <div class="modal-body">
        Czy napewno chcesz usunąć wybraną kategorię ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
        <button type="button" id="delete-form" class="btn btn-primary">Ok</button>
      </div>
    </div>
  </div>
</div>




