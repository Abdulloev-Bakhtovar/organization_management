<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление сотрудника</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Удаление сотрудника</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о сотруднике</h2>
        </div>
        <form action="<%= request.getContextPath() %>/employees/delete" method="POST">
            <input type="text" name="name" value="${employee.name}">
            <input type="text" name="salary" value="${employee.salary}">
            <input type="text" name="departmentId" value="${employee.departmentId}">
            <input type="hidden" name="empId" value="${employee.employeeId}">
            <button type="submit">Удалить</button>
        </form>
    </div>
</div>
</body>
</html>
