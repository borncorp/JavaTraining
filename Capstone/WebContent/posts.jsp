<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Index</title>
</head>
<body>
    
    <div class="container">
	<div class="row clearfix">
			<div class="col-md-12 column">
						
		<%@ include file="/WEB-INF/Layout/header.jsp"%>

				<c:if test="${empty sessionScope.isloggedin}">
					<div class="alert alert-dismissable alert-danger">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<h4>You are not logged in.</h4>
						Login if you want to post something.
					</div>
				</c:if>

				<div class="row clearfix">
					<div id="edittext" class="col-md-9 column">
						<!-- Posts Start ... -->
						<table>
							<thead>
								<tr>
									<th width="50%"><h3>Content</h3></th>
									<th width="10%"><h3>User</h3></th>
									<th width="15%"><h3>Date</h3></th>
									<c:if test="${sessionScope.isadmin == true}">
										<th width="10%"><h3>Admin</h3></th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allposts}" var="post">
									<tr>
										<td><a href="./ViewPost?postid=${post.postid}"><strong>${post.title}</strong></a></td>
										<td>${post.username}</td>
										<td><fmt:formatDate pattern="MM-dd-yy hh:mma" value="${post.date}"/></td>
										<c:if test="${sessionScope.isadmin == true}">
											<td>											
												<form name="editPost" method="GET" action="./EditPost">
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
							<li><a href="./Posts?pagenumber=0&currentpage=${currentpage}">First</a></li>
							<li><a href="./Posts?pagenumber=1&currentpage=${currentpage}">2</a></li>
							<li><a href="./Posts?pagenumber=2&currentpage=${currentpage}">3</a></li>
							<li><a href="./Posts?pagenumber=3&currentpage=${currentpage}">4</a></li>
							<li><a href="./Posts?pagenumber=4&currentpage=${currentpage}">5</a></li>
							<li><a href="./Posts?pagenumber=5&currentpage=${currentpage}">6</a></li>
						</ul>
					</div>

	<%@ include file="/WEB-INF/Layout/loginform.jsp"%>
					</div>
			</div> 
			
	<%@ include file="/WEB-INF/Layout/footer.jsp"%>

</body>
</html>
