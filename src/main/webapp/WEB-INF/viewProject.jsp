<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Projects</h1>
<c:forEach var="task" items="${TaskP}">
    <h1>${task.getId()}</h1>
    <h1>${task.getProjectId()}</h1>
    <h1>${task.getDescription()}</h1>
    <h1>${task.getStartDate()}</h1>
    <h1>${task.getEndDate()}</h1>
    <h1>${task.getStatus()}</h1>
</c:forEach>
</body>
</html>
