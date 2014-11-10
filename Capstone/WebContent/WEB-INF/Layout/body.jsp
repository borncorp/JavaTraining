<!-- Posts Start ... -->
<table>
<c:forEach items="${allposts}" var="post">
   <tr>
       <td>${post.postid}</td>
       <td>${post.username}</td>
       <td>${post.content}</td>
       <td>${post.date}</td>
    </tr>
</c:forEach>
</table>
<!-- Posts End ... -->
works