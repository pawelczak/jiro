<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html class="no-js" >
  <head>
  	<meta name="robots" content="noindex, nofollow" >
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"></c:set>  
    
	
	 
    <%@include file="/WEB-INF/view/admin/static/css.jsp"%>
    <%@include file="/WEB-INF/view/common/javascript.jsp"%>
    <%@include file="/WEB-INF/view/common/meta.jsp"%>
    
    <title><spring:message code="login.title" /></title>

  </head>
 
  <body>
  	<div class="container" >
	   	<form role="form" class="form-signin" method="POST" action="${contextPath}/static/j_spring_security_check">
	        <h2 class="form-signin-heading"><spring:message code="login.header" /></h2>
	        <input type="text" name="j_username" autofocus="" required="" placeholder="<spring:message code='login.name' />" class="form-control">
	        <input type="password" name="j_password" required="" placeholder="<spring:message code='login.passw' />" class="form-control">
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> <spring:message code="login.remember" />
	          </label>
	        </div>
	        <button type="submit" class="btn btn-lg btn-primary btn-block"><spring:message code="login.button.text" /></button>
	      </form>
      </div>
  </body>
</html>