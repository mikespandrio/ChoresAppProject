<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>Chores List for Team Trouble (user: ${name})</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Repeated?</th>
					<th>Cadence</th>
					<th>Created by</th>
					<th>Is Completed?</th>
					<th>Completed by</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<!-- Use JSTL FOR loop to loop through all Chores -->
				<c:forEach items="${chores}" var="chore">
					<tr>
						<td>${chore.description}</td>
						<td><fmt:formatDate value="${chore.targetDate}" pattern="MM/dd/yyyy"/></td>
						<td>${chore.isRepeatAtCadence}</td>
						<td>${chore.cadence}</td>
						<td>${chore.createdBy}</td>
						<td>${chore.isComplete}</td>
						<td>${chore.completedBy}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-chore?id=${chore.id}">Update</a></td>						
						<td><a type="button" class="btn btn-warning"
							href="/delete-chore?id=${chore.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-chore">Add a Chore</a>
		</div>
	</div>
	
<%@ include file="common/footer.jspf" %>