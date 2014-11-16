<%@ include file="/WEB-INF/Layout/topcrap.jsp"%>
<title>New Post</title>
</head>
<body>
	<%@ include file="/WEB-INF/Layout/topbar.jsp"%>

	<h2>New Post</h2>

<form action="NewPost" method="post" >
<textarea name="simple-editor" style="width: 90%;">
</textarea>
<button type="submit">Submit</button>
 </form>

<%@ include file="/WEB-INF/Layout/footer.jsp"%>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
      $(document).foundation();
	</script>
	
	<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
	<script type="text/javascript">
	//<![CDATA[
    bkLib.onDomLoaded(function() { nicEditors.allTextAreas({buttonList : ['bold','italic','underline','ol','ul','strikethrough','removeformat','hr','removeformat','image','upload','link','unlink']}) });
//]]>
</script>
</body>
</html>