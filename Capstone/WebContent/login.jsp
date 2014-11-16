<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script> -->
<script type="text/javascript" src="formly/formly.min.js"></script>
<link rel="stylesheet" href="formly/formly.min.css" type="text/css" />


<title>Login</title>
</head>
<body>
	<form action="Login" method="post" data-abide>
	 <fieldset>
	 <legend>Login</legend>
						
<form data-abide>
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
  <button type="submit">Submit</button>
</form>
  </fieldset>
<%@ include file="/WEB-INF/Layout/loginform.jsp"%>

<%@ include file="/WEB-INF/Layout/footer.jsp"%>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
       $(document).foundation();
    </script>
</body>
</html>