<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html class="no-js" >
  <head>
  
  
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"></c:set>  
    
  <%--  
    <c:set var="DATE_PATTERN" value="dd.MM.yyyy" scope="session"></c:set>  
	 --%>
	
    <%@include file="/WEB-INF/view/common/cssView.jsp"%>
    <%@include file="/WEB-INF/view/site/lib/javascript.jsp"%>
    <%@include file="/WEB-INF/view/common/meta.jsp"%>
    
    <title>Fotografia Waldemar Pawelczak</title>

  </head>
 
  <body>
       	<div class="wrapper" >
       	
	        <header class="navbar navbar-fixed-top" >
	            <tiles:insertAttribute name="header" />
	        </header>
	        
            <tiles:insertAttribute name="content" flush="false" />
	        
	        <div class="push"></div>
        </div>
        <footer>
       		<tiles:insertAttribute name="footer" /> 
        </footer>
     
    
  </body>
</html>