<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<h3 style="color: red;">Register New User</h3>
	<div id="registerUser">
		<form:form action="/register" method="post" modelAttribute="user">
			<p>
				<label>Enter id</label>
				<form:input path="id" />
			</p>
			<p>
				<label>Enter password</label>
				<form:password path="password" />
			</p>
			<p>
				<label>Enter email</label>
				<form:password path="email" />
			</p>
			<p>
				<label>Enter First Name</label>
				<form:password path="firstName" />
			</p>
			<p>
				<label>Enter Last Name</label>
				<form:password path="lastName" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>