<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Posts</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>Posts</h2>

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
								<input type="submit" value="Edit">
							</form>
						</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- Posts End ... -->


<%@ include file="/WEB-INF/Layout/footer.jsp"%>

	<script src="js/vendor/jquery.js"></script>

</body>
</html>