<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Edit Post</title>
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
					<%@ include file="/WEB-INF/Layout/header.jsp"%>
				<br>
				<div class="row clearfix">
					<div class="col-md-9 column">
						<div class="row clearfix">
							<div id="edittext" class="col-md-12 column">
								<form action="EditPost" method="post">
								<h4>Title:</h4>
								<input type="text" class="form-control" label="title" name="title" style="width: 100%;" required
								
								value="${post.title}">
											
									<textarea rows="10" name="simple-editor" style="width: 100%;">
											${post.content}
											</textarea>
							</div>
						</div>
					<br>
					<div class="row clearfix">
						<div class="col-md-3 column">
							 	<input type="hidden" name="postid" value="${post.postid}">
								<button type="submit" class="btn btn-primary">Submit</button>
								</form>
						</div>
						<div class="col-md-6 column">
						</div>
						<div class="col-md-3 column">
							 	<form name="DeletePost" method="POST" action="./DeletePost">
								<input type="hidden" name="postid" value="${post.postid}">
								<button type="submit" class="btn btn-danger">Delete</button>
								</form>
						</div>
					</div>

					</div>
							<%@ include file="/WEB-INF/Layout/loginform.jsp"%>
					</div>

					<%@ include file="/WEB-INF/Layout/footer.jsp"%>

					<script src="js/jquery.min.js"></script>
					<script type="text/javascript"
						src="http://js.nicedit.com/nicEdit-latest.js"></script>
					<script type="text/javascript">
					//<![CDATA[
					bkLib.onDomLoaded(function() {
						nicEditors.allTextAreas({
							buttonList : [ 'bold', 'italic', 'underline', 'ol',
									'ul', 'strikethrough', 'removeformat',
									'hr', 'removeformat', 'image', 'upload',
									'link', 'unlink' ]
						})
					});
					//]]>
				</script>
</body>
</html>
