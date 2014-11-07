<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Register</title>
</head>
<body>

	<h2>Register</h2>
	<form action="Register" method="post" data-abide>
		<table style="width: 90%; margin-left: auto; margin-right: auto;">
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

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
    </script>
</body>
</html>