<%@ page import="org.bakht.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновить информацию о сотруднике</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Обновить информацию о сотруднике</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о сотруднике</h2>
        </div>
        <% List<Department> departments = (List<Department>) request.getAttribute("departments"); %>
        <% if (departments != null && !departments.isEmpty()) { %>
        <form action="<%= request.getContextPath() %>/employees/update" method="POST">
            <input type="text" name="name" value="${employee.name}">
            <input type="text" name="salary" value="${employee.salary}">
            <select name="departmentId">
                <% for (Department department : departments) { %>
                <option value="<%= department.getDepartmentId() %>"><%= department.getName() %></option>
                <% } %>
            </select>
            <input type="hidden" name="employeeId" value="${employee.employeeId}">
            <button type="submit">Обновить</button>
        </form>
        <% } else { %>
        <p>Список отделов пуст или отсутствует.</p>
        <% } %>
    </div>
</div>
</body>
</html>
