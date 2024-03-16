<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="org.bakht.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список сотрудников</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-grey w3-opacity w3-padding" style="display: flex; justify-content: space-between;">
    <h1>Супер приложение!</h1>
    <%--  GET BY ID  --%>
    <%--<form action="<%= request.getContextPath() %>/employees/details" method="get">
        <label for="employeeId">Введите ID сотрудника:</label>
        <input type="text" id="employeeId" name="empId">
        <button type="submit">Поиск</button>
    </form>--%>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Сотрудники</h2>
        </div>
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");

            if (employees != null && !employees.isEmpty()) {
        %>
        <table class="w3-table w3-bordered">
            <thead>
            <tr>
                <th>Имя</th>
                <th>Зарплата</th>
                <th>Отдел</th>
                <th>Операции</th>
            </tr>
            </thead>
            <tbody>
            <% for (Employee employee : employees) { %>
            <tr>
                <td><%= employee.getName() %></td>
                <td><%= employee.getSalary() %></td>
                <td><%= employee.getDepartment().getName() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/employees/update" method="GET">
                        <input type="hidden" name="empId" value="<%= employee.getEmployeeId() %>">
                        <input type="submit" value="Изменить">
                    </form>
                </td>
                <td>
                    <form action="<%= request.getContextPath() %>/employees/delete" method="POST">
                        <input type="hidden" name="empId" value="<%= employee.getEmployeeId() %>">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
            <span onclick="this.parentElement.style.display='none'"
                  class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
            <h5>Пока нет сотрудников!</h5>
        </div>
        <% } %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-padding" style="display: flex; justify-content: space-between;">
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management/employees/add'">Добавить</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management'">Вернуться на главную</button>
</div>

</body>
</html>
