<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<form:form method="post" modelAttribute="chore">
			<form:hidden path="id" />
			<form:hidden path="isRepeatAtCadence" />
			<form:hidden path="cadence" />
			<form:hidden path="createdBy" />
			<form:hidden path="isComplete" />
			<form:hidden path="completedBy" />
			<fieldset class="form-group">
				<form:label path="description">Chore Description</form:label>
				<form:input path="description" type="text" class="form-control"
					required="required" />
				<form:errors path="description" cssClass="text-warning" />
				<!-- Show errors related to description field -->
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
				<!-- Show errors related to description field -->
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	
<%@ include file="common/footer.jspf" %>