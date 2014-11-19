<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<link rel="stylesheet" href="./css/bootstrapValidator.min.css"/>

<title>Register</title>
</head>
<body>
		<%@ include file="/WEB-INF/Layout/header.jsp"%>

<h3>Register</h2>

<form role="form" action="Register" method="post" id="Register" class="form-horizontal"
    data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
    data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">


    <div class="form-group">
        <label class="col-sm-3 control-label">Username</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" name="username" required="required" pattern="[a-zA-Z0-9-_]+"
                data-bv-regexp="true"
                data-bv-regexp-regexp="^[a-zA-Z0-9-_]+$"
                data-bv-regexp-message="The usernamename can consist of alphabetical characters only, no spaces" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label">New password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" name="password"  required="required"
                data-bv-identical="true"
                data-bv-identical-field="confirmPassword"
                data-bv-identical-message="The password and its confirm are not the same" />
            
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label">Confirm password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" name="confirm_password"  required="required"
                data-bv-identical="true"
                data-bv-identical-field="password"
                data-bv-identical-message="The password and its confirm are not the same" />
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-5 col-sm-offset-3">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>

	<%@ include file="/WEB-INF/Layout/footer.jsp"%>
	
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
		<script type="text/javascript" src="./js/bootstrapValidator.min.js"></script>
	
	<script>
$(document).ready(function() {
    $('#Register').bootstrapValidator();
});
</script>
	
</body>
</html>