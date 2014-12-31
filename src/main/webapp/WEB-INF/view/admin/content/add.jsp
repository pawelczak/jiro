<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<h1>Add</h1>

<form:form modelAttribute="image" method="POST" >

	<form:input path="source" ></form:input>
	
	<input type="submit" />
</form:form>
