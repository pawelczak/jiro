<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div role="navigation" class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="${contextPath}/admin" class="navbar-brand">Panel administracyjny</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li ><a href="${contextPath}/admin">Home</a></li>
        <li><a href="${contextPath}/admin/article">Artykuły</a></li>
        <li class="dropdown">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">Kategorie <span class="caret"></span></a>
          <ul role="menu" class="dropdown-menu">
            <li><a href="${contextPath}/admin/addCategory">Dodaj</a></li>
            <li><a href="${contextPath}/admin/categoryList">Lista</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">Fotografie <span class="caret"></span></a>
          <ul role="menu" class="dropdown-menu">
            <li><a href="${contextPath}/admin/addPhoto">Dodaj</a></li>
            <li><a href="${contextPath}/admin/photoList">Lista</a></li>
            <li><a href="${contextPath}/admin/previewPhoto/list">Frontowa galeria</a></li>
          </ul>
        </li>
        <li ><a href="${contextPath}/" target="_blank" >Przejdź do strony</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li ><a href="${contextPath}/static/j_spring_security_logout"><spring:message code="login.logout" /></a></li>
      </ul>
    </div>
  </div>
</div>

