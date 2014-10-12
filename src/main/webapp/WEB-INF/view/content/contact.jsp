<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<div class="container" >
	<div class="page-header" >
		<!--  <div class="header-icon header-contact" ></div> -->
		<div class="header-title">Kontakt</div>
	</div>
	<p></p>


	<div class="row panel-contact">
	
		<div>
			<div class="info-name c-label" >Waldemar Pawełczak</div>
		</div>
		
		<div>
			<div class="info-email c-label" >w.paw@wp.pl</div>
		</div>
	
		<form>
			<div class="form-field c-label" >
			
				<p>Napisz do mnie wiadomość</p>
			
			<div class="row" >
				<label class="col-sm-4" for="inputName">Nick:</label>
				<div class="col-sm-6" >				
					<input type="text" id="inputName" placeholder="Jan Kowalski" />
				</div>
			</div>
			
			<div class="row" >	
				<label class="col-sm-4" for="inputEmail">E-mail:</label>	
				<div class="col-sm-6" >			
					<input type="email" id="inputEmail" placeholder="jan@kowalski.pl" />
				</div>
			</div>
				
			<div class="row" >
				<label class="col-sm-4" for="inputContent">Wiadomość:</label>
				<div class="col-sm-6" >
				<%-- 
					<input type="text" id="inputContent" placeholder="Treść wiadomości" />
				 --%>
				 
				 <textarea id="inputContent" >Treść wiadomości</textarea>
				 
				</div>	
			</div>			
				
			<div class="row" >
				<input type="submit" class="button" value="Wyślij" />
			</div>
			
			</div>

		</form>
	
	
	
	
	
	</div>


</div>