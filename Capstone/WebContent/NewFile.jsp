<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="formly/formly.min.js"></script>
<link rel="stylesheet" href="formly/formly.min.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
<form id="MyForm">
Username: <input type="text" name="Username" place="No spaces" label="Username" require="true" />
<br />
Password: <input type="password" name="Password" label="Password" require="true" />
<input type="password" name="PasswordMatch" match="Password" label="Password" place="Re-type password" />
<input type="submit" value="Sign up" /><input type="reset" value="Clear" />
</form>


<script>
$(document).ready(function() { 
	
	$('#MyForm').formly(); 
});
</script>
</body>
</html>