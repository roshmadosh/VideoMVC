<html>
<body>
<h1>Spring MVC Single File Upload</h1>

<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
	<label style="display: block;" for="file">Upload file here:</label>
	<input type="file" name="file" id="file"/>
	<br></br>
	<button type="submit">Submit</button>
</form>
</body>

</html>
