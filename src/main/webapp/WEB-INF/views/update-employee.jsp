<%--Решение проблема forEach--%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Update Employee</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Employee Information</h2>
        </div>
        <!-- Форма для обновления информации о сотруднике -->
        <form action="<%= request.getContextPath() %>/employees/update" method="POST">
            <!-- Поля для ввода новой информации о сотруднике -->
            <!-- Пример: Имя, Зарплата, Идентификатор отдела и т. д. -->
            <!-- Используйте атрибуты "value" для предварительного заполнения данных сотрудника -->
            <input type="text" name="name" value="${employee.name}">
            <input type="text" name="salary" value="${employee.salary}">
            <input type="text" name="departmentId" value="${employee.departmentId}">
            <!-- Поле для передачи идентификатора сотрудника -->
            <input type="hidden" name="employeeId" value="${employee.employeeId}">
            <!-- Кнопка для отправки формы -->
            <button type="submit">Update</button>
        </form>
    </div>
</div>
</body>
</html>
