<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1>Spring MVC Single File Upload</h1>

<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
	<label style="display: block;" for="file">Upload file here:</label>
	<input type="file" name="file" id="file"/>
	<br></br>
	<ul>
	<c:forEach items="${files}" var="content">
		<li><c:out value="${content}"/></li>
	</c:forEach>
	</ul>
		
	<button type="submit">Submit</button>
</form>
</body>

</html>
