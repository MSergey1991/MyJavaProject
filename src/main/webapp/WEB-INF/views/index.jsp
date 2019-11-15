<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Indesxxxx</h1>
<a href="/addTask">Add new Task</a>


<table>
    <tr>
        <th>ID</th>
        <th>Summary</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Assignee</th>
    </tr>
    <c:forEach items="${allTasks}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.summary}</td>
            <td>${task.startDate}</td>
            <td>${task.endDate}</td>
            <td>${task.assignee}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>