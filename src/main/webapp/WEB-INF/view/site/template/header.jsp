<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<div class="container" >
	<nav>
		<div class="logo navbar-header" ><a class="navbar-brand" href="${contextPath}/" >Waldemar Pawełczak</a></div>
	
		<ul class="nav navbar-nav navbar-right" >
			<li ><a href="${contextPath}/" ><spring:message code="navigation.main" /></a></li>
			<li ><a href="${contextPath}/featured" ><spring:message code="navigation.featured" /></a></li>
			<li><a href="${contextPath}/gallery" ><spring:message code="navigation.gallery" /></a></li>
			<li><a href="${contextPath}/contact" ><spring:message code="navigation.contact" /></a></li>
		</ul>
	
	</nav>

</div>


