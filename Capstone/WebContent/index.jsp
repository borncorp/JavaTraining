<%@ include file="./WEB-INF/Layout/topcrap.jsp"%>
<title>Login</title>
</head>
<body>
	<%@ include file="./WEB-INF/Layout/topbar.jsp"%>
	<%@ include file="./WEB-INF/Settings/sql.jsp"%>

	<h2>Register</h2>
	<form action="Login" method="post" data-abide>
		<table style="height: 100%; margin-left: auto; margin-right: auto;"
			width="100%">
			<tbody>
				<tr>
					<td>
						<div class="small-9 columns">
							<label>Email <small>required</small> <input name="email" type="email"
								id="email"></label> <small class="error">Your email is
								invalid</small>
						</div>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<div class="small-9 columns">
							<label>Password <small>required</small> <input
								name="password" type="password" id="password" required pattern="[a-zA-Z]+"></label>
							<small class="error">Your password must match the
								requirements</small>
						</div>
					</td>
					<td>
						<div class="small-9 columns">
							<label>Confirm Password <small>required</small> <input
								type="password" required pattern="[a-zA-Z]+"
								data-equalto="password"></label> <small class="error">The
								password did not match</small>
						</div>
					</td>
				</tr>
			</tbody>
		</table>

		<button type="submit">Submit</button>
	</form>
<%
String test = "bornoeoeoe";
%>
<%=test%>

	<sql:update dataSource="${snapshot}">
	UPDATE users SET password="58166556" WHERE username="borncorp"
    </sql:update>

	<c:catch>
		<sql:update dataSource="${snapshot}" var="count">
   create table people (personid int, name varchar(50), age int);
    </sql:update>
	</c:catch>




	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
    </script>
</body>
</html>