<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new task</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<ul class="nav">
    <li class="nav-item">
        <a class="nav-link active" href="index">All tasks</a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="/addTask">Add new task</a>
    </li>

</ul>

<div class="container">

    <br/>
    <br/>

    <h3>
        ${incorrectEnteredParametersMessage}
    </h3>

    <form role="form" action="createNewTask" method="post">
        <div class="form-group">
            <p class="help-block">Enter Assignee: </p>
            <input name="assignee" type="text" class="form-control" placeholder="Assignee"/>

        </div>

        <div class="form-group">
            <p class="help-block">Enter Summary: </p>
            <input name="summary" type="text" class="form-control" placeholder="Summary"/>

        </div>

        <div class="form-group">
            <p class="help-block">Enter Start Date: </p>
            <input name="startDate" type="date" class="form-control" placeholder="StartDate"/>

        </div>

        <div class="form-group">
            <p class="help-block">Enter End Date ("End Date" should be after "Start Date"):</p>
            <input name="endDate" type="date" class="form-control" placeholder="EndDate"/>

        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-info" value="Create new task"/>
        </div>
    </form>

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