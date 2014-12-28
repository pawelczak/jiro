<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>


<div class="container showcase" >

	<!-- 

	<div class="main-image">
	<img src="${contextPath}/static/image/2.jpg" />

	</div>
	
	 -->
	
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
	
	
	
	
	
	
	
	
	
	
</div>


<div class="container" >
	<div class="sh-header">
		<div>O mnie</div>
	</div>	
	<div class="sh-desc">
	
		<div class="sh-canvas" >
		
			<p>Fotografia stała się moją pasją, odtąd wykonałem samodzielnie zdjęcia pierwszego syna w 1986 roku. Chociaż już wcześniej ojciec wprowadził mnie w magiczny świat fotografii, to dopiero wtedy zdałem sobie sprawę, że odtąd będę już zawsze dźwigał ciężki sprzęt na kolejnych wyprawach w góry. Fascynuje mnie krajobraz. Lubię spojrzenie teleobiektywów i obiektywów szerokątnych. W moich fotografiach pragnę uchwycić to wrażnie potęgi przyrody jakie odczuwa się będąc gdzieś wysoko na górskiej ścieżce. </p>
		
			<p>W dążeniach do doskonałości kieruję się klasycznymi zasadami kompozycji obrazu i wierności oddania barw. Chciałbym kiedyś osiągnąć poziom niedoścignionych perfekcjonistów takich jak David Noton i Jeremy Walker. Mam nadzieję, że kiedyś go osiągnę. </p>
		
		</div>
	
		<div class="sh-images row" >
			<div class="col-md-4" >
				<img src="${contextPath}/static/image/1.jpg" />
			</div>
			<div class="col-md-4" >
				<img src="${contextPath}/static/image/2.jpg" />
			</div>
			<div class="col-md-4" >
				<img src="${contextPath}/static/image/3.jpg" />
			</div>
		</div>
	
	</div>

</div>

<!-- 
<div class="sh-header">
	<div>Polecane</div>
</div>
 -->

<div class="sh-full" >
	<div class="container" >
		<div class="sh-bottom row " >
			<div class="col-md-4" >
				<div class="teaser" >
				
					<div class="block featured"></div>
				
					<p>Polecane zdjęcia</p>
					<p>Lorem ipsum dolor sit amet, conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis </p>
				</div>
			</div>
			<div class="col-md-4" >
				<div class="teaser" >
					<div class="block gallery"></div>
				
					<p>Galeria</p>
					<p>Lorem ipsum dolor sit amet, conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis </p>
				</div>
			</div>
			<div class="col-md-4" >
				<div class="teaser" >
					<div class="block contact"></div>
					<p>Kontakt</p>
					<p>Lorem ipsum dolor sit amet, cons ectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis </p>
				</div>
			</div>
	
		</div>
	</div>

</div>



<gallery:section headerLabel="home.gallery.mostPopular" galleries="${mostPopularGalleries}" ></gallery:section>
<gallery:section headerLabel="home.gallery.lastAdded" galleries="${lastAddedGalleries}" ></gallery:section>
 
 

 
