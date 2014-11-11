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
					<td>Edit</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- Posts End ... -->