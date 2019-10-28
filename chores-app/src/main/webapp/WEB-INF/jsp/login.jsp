<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
	<font color="red">${errorMessage}</font>
		<form:form method="post">		
 			Name: 
			<input type="text" name="name" />
			Password: 
			<input type="password" name="password" /> 
			
			<br><br> 
			<input type="submit" />
		</form:form>
	</div>

<%@ include file="common/footer.jspf" %>