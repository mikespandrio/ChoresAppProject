<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Troublesome Chores</title>
</head>
<body>
	<h2>Chores List for Team Trouble (user: ${name})</h2>
	<hr>	
	<table>
		<caption>Chores</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Completed?</th>
			</tr>
		</thead>
		<tbody>
			<!-- Use JSTL FOR loop to loop through all Chores -->
			<c:forEach items="${chores}" var="chore">
				<tr>
					<td>${chore.description}</td>
					<td>${chore.targetDate}</td>
					<td>${chore.isComplete}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/add-chore">Add a Chore</a>
</body>
</html>