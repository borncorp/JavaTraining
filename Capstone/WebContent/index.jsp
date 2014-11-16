<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Index</title>
</head>
<body>
    
    <div class="container">
	<div class="row clearfix">
			<div class="col-md-12 column">
			
				<%@ include file="/WEB-INF/Layout/carousel.jsp"%>
			
				<div class="page-header">
					<h1>
						Capstone Project <small>by Adolfo Garza</small>
					</h1>
				</div>

				<c:if test="${empty sessionScope.isloggedin}">
					<div class="alert alert-dismissable alert-danger">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<h4>You are not logged in.</h4>
						Login if you want to post something.
					</div>
				</c:if>

				<div class="row clearfix">
					<div class="col-md-9 column">
						<!-- Posts Start ... -->
						<table>
							<thead>
								<tr>
									<th width="5%">PostId</th>
									<th width="50%">Content</th>
									<th width="10%">User</th>
									<th width="10%">Date</th>
									<c:if test="${sessionScope.isadmin == true}">
										<th width="10%">Admin</th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allposts}" var="post">
									<tr>
										<td>${post.postid}</td>
										<td>${post.content}</td>
										<td>${post.username}</td>
										<td>${post.date}</td>
										<c:if test="${sessionScope.isadmin == true}">
											<td>											
												<form name="submitForm" method="GET" action="./EditPost">
													<input type="hidden" name="postid" value="${post.postid}">
													<button type="submit" class="btn btn-default">Edit</button>
												</form>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- Posts End ... -->

						<ul class="pagination pagination-lg">
							<li><a href="#">Prev</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>

	<%@ include file="/WEB-INF/Layout/loginform.jsp"%>
					</div>
			</div> 
	<%@ include file="/WEB-INF/Layout/footer.jsp"%>
	
	<script src="js/vendor/jquery.js"></script>
</body>
</html>
