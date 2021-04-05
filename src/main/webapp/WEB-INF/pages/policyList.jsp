<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="policies" type="java.util.List<com.example.demo.model.Policy>" scope="request"/>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
<head>
    <title>Policy List</title>

</head>
<body>
<div class="main">
    Policy List
    <br>
    <button>
        <a href="${pageContext.request.contextPath}/insuredObjects">Create policy</a>
    </button>
    <br>
    <table>
        <tr>
            <td>
                Owner name
            </td>
            <td>
                Date of contract
            </td>
            <td>
                Start date
            </td>
            <td>
                End date
            </td>
            <td>
                Insured object
            </td>
            <td>
                Coverage option
            </td>
        </tr>

        <c:forEach items="${policies}" var="policy">
            <tr>
                <td>${policy.ownerFullName}</td>
                <td>${policy.contractDate}</td>
                <td>${policy.startDate}</td>
                <td>${policy.endDate}</td>
                <td>${policy.insuredObject.objectName}</td>
                <td>${policy.policyType.typeName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
