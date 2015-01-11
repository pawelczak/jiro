<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html class="no-js" >
  <head>
    <meta name="robots" content="noindex, nofollow" >
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"></c:set>  
    <c:set var="photoPath" value="${contextPath}/.." scope="session"></c:set>  
    
	
    <%@ include file="/WEB-INF/view/admin/static/css.jsp"%>
    <%@ include file="/WEB-INF/view/admin/static/javascript.jsp"%>
    <%@ include file="/WEB-INF/view/common/meta.jsp"%>
    
    
    <title>Fotografia Waldemar Pawelczak</title>

  </head>
 
  <body>
       	<div class="wrapper" >
       		
	        <header>
	            <tiles:insertAttribute name="header" />
	        </header>
        
	        
	        <div class="container admin-panel">
               <tiles:insertAttribute name="content" flush="false" />
	        </div>
	        
	        <div class="push"></div>
        </div>
        <div class="footer" >
       		<tiles:insertAttribute name="footer" /> 
        </div>
    
    
  </body>
</html>