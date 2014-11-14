<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Profile</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>Profile</h2>
	
<ul class="small-block-grid-5">
  <li><h5>Upload avatar</h5></li>
  <li>
<form action="UploadAvatar" method="post" enctype="multipart/form-data">
	<input name="photo" type="file" size="50">
	<input name="submit" type="submit" value="Submit">
</form>
</li>
  <li></li>
  <li></li>
  <li><img src="https://developer.cdn.mozilla.net/media/img/mdn-logo-sm.png" height="500"/></li>
</ul>
	<div>

	<h5>Change password</h5>
	<h5>About me</h5>
	

<%@ include file="/WEB-INF/Layout/footer.jsp"%>
	
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
    </script>
</body>
</html>