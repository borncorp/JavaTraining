<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>Posts</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>Posts</h2>

<%@ include file="/WEB-INF/Layout/footer.jsp"%>

<!-- Posts Start ... -->
<table>
<c:forEach items="${allposts}" var="post">
   <tr>
       <td><c:out value="${post.content}"></c:out></td>
    </tr>
</c:forEach>
</table>
<!-- Posts End ... -->

	
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
    </script>
</body>
</html>