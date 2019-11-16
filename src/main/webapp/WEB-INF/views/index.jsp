<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<fmt:setLocale value="en_US"/>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Indesxxxx</h1>
<a href="/addTask">Add new Task</a>


<form method="post" action="searchFilter">

    <select name="assignee" itemtype="text">
        <option value="" label="Assignee not selected"/>
        <c:forEach items="${allAssignees}" var="assignee">
            <option value="${assignee}">
                <c:out value="${assignee}"/>
            </option>
        </c:forEach>
    </select>

    <input type="date" name="startDate">
    <input type="date" name="endDate">

    <select name="period" itemtype="text">
        <option value="" label="Choose time period"/>
        <option value="lastQuarter" label="Last Quarter"/>
        <option value="lastMonth" label="Last Month"/>
        <option value="lastWeek" label="Last Week"/>
        <option value="currentQuarterToDate" label="Current Quarter to Date"/>
        <option value="currentMonthToDate" label="Current Month to Date"/>
        <option value="currentWeekToDate" label="Current Week to Date"/>
    </select>

    <button type="submit">Search by filter</button>

</form>

<h3>
    ${noSearchResultMessage}
</h3>

<h1>
    ${incorrectEnteredParametersMessage}
</h1>

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
            <td><fmt:formatDate pattern="dd/MMM/yyyy" value="${task.startDate}"/></td>
            <td><fmt:formatDate pattern="dd/MMM/yyyy" value="${task.endDate}"/></td>
            <td>${task.assignee}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>