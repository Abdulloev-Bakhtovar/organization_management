<%@ page import="org.bakht.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление сотрудника</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Добавление сотрудника</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о сотруднике</h2>
        </div>
        <% List<Department> departments = (List<Department>) request.getAttribute("departments"); %>
        <% if (departments != null && !departments.isEmpty()) { %>
        <form action="<%= request.getContextPath() %>/employees/add" method="POST">
            <input type="text" name="name" placeholder="Имя">
            <input type="text" name="salary" placeholder="Зарплата">
            <select name="departmentId">
                <% for (Department department : departments) { %>
                <option value="<%= department.getDepartmentId() %>"><%= department.getName() %></option>
                <% } %>
            </select>
            <button type="submit">Добавить сотрудника</button>
        </form>
        <% } else { %>
        <p>Список отделов пуст или отсутствует.</p>
        <% } %>
    </div>
</div>
</body>
</html>
