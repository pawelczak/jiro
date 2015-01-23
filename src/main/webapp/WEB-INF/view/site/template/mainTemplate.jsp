<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html class="no-js" >
  <head>
  	<%@include file="/WEB-INF/view/common/meta.jsp"%>
  
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"></c:set>  
    <c:set var="photoPath" value="${contextPath}/image?fileName=" scope="session"></c:set>  
    
  <%--  
    <c:set var="DATE_PATTERN" value="dd.MM.yyyy" scope="session"></c:set>  
	 --%>
	
    <%@include file="/WEB-INF/view/common/cssView.jsp"%>
    
    <tiles:insertAttribute name="jsLibs" />
    
    <%@include file="/WEB-INF/view/site/template/pageTitle.jsp"%>

  </head>
  <body>

        <tiles:insertAttribute name="header" />
        
        <tiles:insertAttribute name="content" flush="false" />

  		<tiles:insertAttribute name="footer" /> 

  </body>
</html>