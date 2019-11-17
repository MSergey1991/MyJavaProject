<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<fmt:setLocale value="en_US"/>
<head>
    <meta charset="UTF-8">
    <title>Sheduler</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<ul class="nav">
    <li class="nav-item">
        <a class="nav-link disabled" href="index">All tasks</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/addTask">Add new task</a>
    </li>

</ul>


<div class="container">
    <br/>
    <h1>Tasks search filter</h1>
    <br/>


    <form role="form" method="post" action="searchFilter">
        <div class="form-group">
            <p class="help-block">Select assignee:</p>
            <select name="assignee" itemtype="text" class="form-control">
                <option value="" label="Assignee not selected"/>
                <c:forEach items="${allAssignees}" var="assignee">
                    <option value="${assignee}">
                        <c:out value="${assignee}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <p class="help-block">Enter Start Date:</p>
            <input name="startDate" type="date" class="form-control"/>

        </div>
        <div class="form-group">
            <p class="help-block">Enter End Date:</p>
            <input name="endDate" type="date" class="form-control"/>

        </div>
        <div class="form-group">
            <p class="help-block">Choose time period:</p>
            <select name="period" itemtype="text" class="form-control">
                <option value="" label="Choose time period"/>
                <option value="lastQuarter" label="Last Quarter"/>
                <option value="lastMonth" label="Last Month"/>
                <option value="lastWeek" label="Last Week"/>
                <option value="currentQuarterToDate" label="Current Quarter to Date"/>
                <option value="currentMonthToDate" label="Current Month to Date"/>
                <option value="currentWeekToDate" label="Current Week to Date"/>
            </select>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-info" value="Search by filter"/>
        </div>
    </form>


    <h3>
        ${noSearchResultMessage}
    </h3>

    <br/>
    <br/>

    <h3> Tasks List </h3>
    <br/>
    <div class="table-responsive-md">
        <table class="table table-striped">
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
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>