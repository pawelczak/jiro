<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<h1>Article view</h1>
<c:forEach var="p" items="${articles}">
	<li>${p.id} - ${p.title}</li>
</c:forEach>
 
