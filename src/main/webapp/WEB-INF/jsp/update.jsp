<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update information</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Update user information</h3>

	<div id="update">
		<form:form action="/update" method="post"
			modelAttribute="emp">
			<p>
				<label>Enter Employee Password</label>
				<form:input path="password" />
			</p>
			<p>
				<label>Enter email</label>
				<form:input path="email" />
			</p>
			<p>
				<label>Enter firstName</label>
				<form:input path="firstName" />
			</p>
			<p>
				<label>Enter lastName</label>
				<form:input path="lastName" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
