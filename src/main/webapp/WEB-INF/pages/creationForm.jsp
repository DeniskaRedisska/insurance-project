<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="policyTypes" scope="request" type="java.util.List<com.example.demo.model.PolicyType>"/>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/second.css">
<head>
    <title>Creation From</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/create" method="post" modelAttribute="policy">
    <div>
        Name
        <input type="text" name="ownerName" value="${not empty policy.ownerFullName ? policy.ownerFullName : ''}">
        <form:errors path="ownerFullName" cssStyle="color: red"/>
    </div>
    <div>
        Start date
        <input type="date" name="startDate" value="${not empty policy.startDate ? policy.startDate: ''}">
        <form:errors path="startDate" cssStyle="color: red"/>
    </div>
    <div>
        Duration(years)
        <input type="number" name="contractDuration"
               value="${not empty policy.contractDuration ? policy.contractDuration : 1}">
        <form:errors path="contractDuration" cssStyle="color: red"/>
    </div>
    <div>
        Policy type
        <select name="policyType.id">
            <c:forEach items="${policyTypes}" var="type">
                <option value="${type.id}" ${not empty policy.policyType.id and policy.policyType.id==type.id ? 'selected' : ''}>
                        ${type.typeName}
                </option>
            </c:forEach>
        </select>
        <input type="hidden" name="insuredObject.id"
               value="${not empty policy ? policy.insuredObject.id : param['insured_obj'] }">
    </div>
    <div>
    <button>Create</button>
    </div>
</form:form>
</body>
</html>
