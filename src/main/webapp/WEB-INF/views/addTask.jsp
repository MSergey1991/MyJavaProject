<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OK</title>
</head>
<body>

<h1> This page saves new tasks</h1>

<form action="createNewTask" method="post">
    <input type="text" name="assignee" placeholder="Assignee"/>
    <input type="text" name="summary" placeholder="Summary"/>
    <input type="date" name="startDate" placeholder="StartDate"/>
    <input type="date" name="endDate" placeholder="EndDate"/>

    <button type="submit">
        Create new task
    </button>

</form>

</body>
</html>