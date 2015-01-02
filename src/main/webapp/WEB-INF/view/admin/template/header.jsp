<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div role="navigation" class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="${contextPath}/admin" class="navbar-brand"><spring:message code='admin.panel' /></a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li ><a href="${contextPath}/admin"><spring:message code='home' /></a></li>
        <li><a href="${contextPath}/admin/article"><spring:message code='articles' /></a></li>
        <li class="dropdown">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#"><spring:message code='categories' /><span class="caret"></span></a>
          <ul role="menu" class="dropdown-menu">
            <li><a href="${contextPath}/admin/addCategory"><spring:message code='add' /></a></li>
            <li><a href="${contextPath}/admin/categoryList"><spring:message code='list' /></a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#"><spring:message code='photos' /><span class="caret"></span></a>
          <ul role="menu" class="dropdown-menu">
            <li><a href="${contextPath}/admin/addPhoto"><spring:message code='add' /></a></li>
            <li><a href="${contextPath}/admin/photoList"><spring:message code='list' /></a></li>
            <li><a href="${contextPath}/admin/previewPhoto/list"><spring:message code='frontGallery' /></a></li>
          </ul>
        </li>
        <li ><a href="${contextPath}/" target="_blank" ><spring:message code='admin.gotoSite' /></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li ><a href="${contextPath}/static/j_spring_security_logout"><spring:message code="login.logout" /></a></li>
      </ul>
    </div>
  </div>
</div>

