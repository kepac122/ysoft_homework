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
			<h1>Welcome to Task list!</h1>

			<form:form commandName="newTask" id="reg">
				<h2>Task Creation</h2>					
				<table>
					<tbody>
						<tr>
							<td><form:label path="title">Title:</form:label></td>
							<td><form:input path="title"/></td>
							<td><form:errors class="invalid" path="title" /></td>
						</tr>
						<tr>
							<td><form:label path="text">Text:</form:label></td>
							<td><form:input path="text"/></td>
							<td><form:errors class="invalid" path="text"/></td>
						</tr>
						<tr>
							<td><form:label path="date">Date:</form:label></td>
							<td>
							<div class="datepickr-wrapper">							
								<form:input id="datepickr" path="date"/></td>
							</div>
							<td><form:errors class="invalid" path="date"/></td>
						</tr>
						<tr>
							<td><form:label path="priority">Priority:</form:label>
							<!-- TODO five radios to choose one priority -->
							<td><form:input path="priority" value="5" /></td>
							<td><form:errors class="invalid" path="priority"/></td>
						</tr>

					</tbody>
				</table>
				<table>
					<tr>
						<td>
							<input type="submit" value="Create"/>
						</td>
					</tr>
				</table>
			</form:form>		
			<div>
				<a href="<c:url value="/list"/>"><h2>To list</h2></a>
			</div>	
		</div>

		<script src="<c:url value="/static/resources/js/datepickr.min.js"/>"></script>
		<script>
			datepickr('#datepickr');
		</script>		
	</body>
</html>
