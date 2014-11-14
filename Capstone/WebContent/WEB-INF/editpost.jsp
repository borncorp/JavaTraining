<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<link rel="stylesheet" href="bower_components/dist/ui/trumbowyg.min.css">
<title>Edit Post</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>Edit Post</h2>
	
<form name="submitForm" method="POST" action="./DeletePost">
<input type="hidden" name="postid" value="${postid}">
<input type="submit" value="Delete">
</form>

<form action="EditPost" method="post" >
<div id="simple-editor">
<c:forEach items="${myPost}" var="post">
${post.content}
</c:forEach>

</div>

<input type="hidden" name="postid" value="${postid}">
<button type="submit">Submit</button>
 </form>

<%@ include file="/WEB-INF/Layout/footer.jsp"%>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script src="bower_components/dist/trumbowyg.min.js"></script>
	<script>
      $(document).foundation();
	</script>
	<script>
		$('#simple-editor').trumbowyg();
	</script>
</body>
</html>