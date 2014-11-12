<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Register</title>
</head>
<body>
	<form action="Register" method="post" data-abide>
	 <fieldset>
	 <legend>Register</legend>
						
  <div class="name-field">
    <label>Username <small>required</small>
      <input type="text" name="username"  pattern="alpha_numeric" required>
    </label>
    <small class="error">Username is required and must be a string.</small>
  </div>
  <div class="password-field">
    <label>Password <small>required</small>
      <input type="password"  name="password" required >
    </label>
    <small class="error">Your password must match the requirements.</small>
  </div>
  <div class="password-field">
	<label>Confirm Password <small>required</small> 
		<input type="password" data-equalto="password" required>
	</label> <small class="error">The password did not match</small>
  </div>

  <button type="submit">Submit</button>
  </fieldset>
</form>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
    </script>
</body>
</html>