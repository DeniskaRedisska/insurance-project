<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="objects" type="java.util.List<com.example.demo.model.InsuredObject>" scope="request"/>
<html>
<head>
    <title>Creation Options</title>
</head>
<body>
<h2>Choose what object you want to insure:</h2>
<c:forEach items="${objects}" var="object">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/creationForm?insured_obj=${object.id}">
                ${object.objectName}
             </a>
        </li>
    </ul>
</c:forEach>
</body>
</html>
