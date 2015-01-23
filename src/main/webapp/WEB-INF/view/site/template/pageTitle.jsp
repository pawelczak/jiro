<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<c:set var="title" >
	<tiles:insertAttribute name="title" />
</c:set>

<c:choose>
	<c:when test="${!empty title}" >
		<title><spring:message code="${title}" /> - <spring:message code="pageTitle.jiro" /></title>
	</c:when>
	<c:otherwise>
		<title><spring:message code="pageTitle.jiro" /></title>
	</c:otherwise>
</c:choose>

