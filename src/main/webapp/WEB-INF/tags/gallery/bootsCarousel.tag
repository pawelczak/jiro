<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<%@ tag display-name="bootsCarousel" description="Form" small-icon=""%>




	<div data-ride="carousel" class="carousel slide" id="">
      <ol class="carousel-indicators">
        <li class="" data-slide-to="0" data-target="#carousel-example-captions"></li>
        <li data-slide-to="1" data-target="#carousel-example-captions" class=""></li>
        <li data-slide-to="2" data-target="#carousel-example-captions" class="active"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item">
          <img src="${contextPath}/static/image/2.jpg" />
          <div class="carousel-caption">
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </div>
        </div>
        <div class="item">
          <img src="${contextPath}/static/image/3.jpg" />
          <div class="carousel-caption">
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
        </div>
        <div class="item active">
          <img src="${contextPath}/static/image/4.jpg" />
          <div class="carousel-caption">
            <h3>Third slide label</h3>
            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
          </div>
        </div>
      </div>
      <a data-slide="prev" role="button" href="#carousel-example-captions" class="left carousel-control">
        <span class="glyphicon glyphicon-chevron-left">L</span>
      </a>
      <a data-slide="next" role="button" href="#carousel-example-captions" class="right carousel-control">
        <span class="glyphicon glyphicon-chevron-right">R</span>
      </a>
    </div>