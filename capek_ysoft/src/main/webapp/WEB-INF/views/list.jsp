<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Ysoft homework Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/screen.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/datepickr.min.css"/>"/> 
	</head>

	<body>	
	
		<div id="content">			
			<h1>Tasks</h1>
			<c:choose>
				<c:when test="${tasks.size()==0}">
					<em>No existing tasks.</em>
				</c:when>
				<c:otherwise>
					<table class="simpletablestyle">
						<thead>
							<tr>
								<th>Id</th>
								<th>Title</th>
								<th>Text</th>
								<th>Date</th>
								<th>Priority</th>
								<th>Done</th>
								<th>REST URL</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tasks}" var="task">
								<tr>
									<td>${task.id}</td>
									<td>${task.title}</td>
									<td>${task.text}</td>
									<td>${task.date}</td>
									<td>${task.priority}</td>
									<td>${task.done}</td>
									<td><a href="<c:url value="/rest/tasks/${task.id}"/>">/rest/tasks/${task.id}</a></td>
									<td>
									<div>
										<form:form action="list/delete/${task.id}" >
											<input type="submit" name="delete" value="Delete" />
										</form:form>
										<form:form action="list/done/${task.id}">
											<input type="submit" name="done" value="Done" />
										</form:form>		
										<form:form action="list/notdone/${task.id}">
											<input type="submit" name="notdone" value="Not done" />
										</form:form>							
										<form:form action="list/inc_priority/${task.id}">
											<input type="submit" name="plus_priority" value="Increase priority" />
										</form:form>
										<form:form action="list/dec_priority/${task.id}">
											<input type="submit" name="minus_priority" value="Decrease priority" />
										</form:form>
									</div>
									</td>
							</c:forEach>
						</tbody>
					</table>
					<table class="simpletablestyle">
						<tr>
							<td>
								REST URL for all tasks: <a href="<c:url value="/rest/tasks"/>">/rest/tasks</a>
							</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			<div>
				<a href="<c:url value="/"/>"><h2>back to create</h2></a>
			</div>
		</div>
	</body>
</html>
