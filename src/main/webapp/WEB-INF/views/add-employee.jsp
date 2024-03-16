<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Add Employee</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Employee Information</h2>
        </div>
        <!-- Форма для добавления нового сотрудника -->
        <form action="<%= request.getContextPath() %>/employees/add" method="POST">
            <!-- Поля для ввода информации о новом сотруднике -->
            <!-- Пример: Имя, Зарплата, Идентификатор отдела и т. д. -->
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="salary" placeholder="Salary">
            <input type="text" name="departmentId" placeholder="Department ID">
            <!-- Кнопка для отправки формы -->
            <button type="submit">Add Employee</button>
        </form>
    </div>
</div>
</body>
</html>
