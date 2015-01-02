<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>

<div class="container" >
	<div class="page-header" >
		<div class="header-title"><spring:message code="contact.header" /></div>
	</div>
	<p></p>

	<div class="row panel-contact">
	
		<div>
			<div class="info-name c-label" ><spring:message code="contact.info.name" /></div>
		</div>
		
		<div>
			<div class="info-email c-label" ><spring:message code="contact.info.email" /></div>
		</div>
	
		<%-- <form> --%>
			<div class="form-field c-label" >
			
				<p><spring:message code="contact.sendMessage" /></p>
			
			<div class="row" >
				<label class="col-sm-4" for="inputName"><spring:message code="contact.form.nick" />:</label>
				<div class="col-sm-6" >				
					<input type="text" id="inputName" placeholder="Jan Kowalski" />
				</div>
			</div>
			
			<div class="row" >	
				<label class="col-sm-4" for="inputEmail"><spring:message code="contact.form.email" />:</label>	
				<div class="col-sm-6" >			
					<input type="email" id="inputEmail" placeholder="jan@kowalski.pl" />
				</div>
			</div>
				
			<div class="row" >
				<label class="col-sm-4" for="inputContent"><spring:message code="contact.form.message" />:</label>
				<div class="col-sm-6" >
				<%-- 
					<input type="text" id="inputContent" placeholder="Treść wiadomości" />
				 --%>

				 <textarea id="inputContent" placeholder="<spring:message code="contact.form.messageText" />" ></textarea>
				 
				</div>	
			</div>			
				
			<div class="row" >
				<input type="submit" class="button" value="<spring:message code='button.send' />" />
			</div>
			
			</div>

		<%-- </form> --%>
	
	</div>

</div>
