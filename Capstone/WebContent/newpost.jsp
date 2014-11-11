<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<link rel="stylesheet" href="bower_components/dist/ui/trumbowyg.min.css">
<title>New Post</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>New Post</h2>

<form action="NewPost" method="post" >
<div id="simple-editor">
</div>
 </form>

<%@ include file="/WEB-INF/Layout/footer.jsp"%>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.1.min.js"><\/script>')</script>
	<script src="bower_components/dist/trumbowyg.min.js"></script>
	<script>
      $(document).foundation();
	</script>
	<script>
		$('#simple-editor').trumbowyg();
	</script>
</body>
</html>