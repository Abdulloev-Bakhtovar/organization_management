<%@ page import="org.bakht.model.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о департаменте</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Информация о департаменте</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о департаменте</h2>
        </div>
        <%
            // Получаем департамент из модели
            Department department = (Department) request.getAttribute("department");
            if (department != null) {
        %>
        <table class="w3-table w3-bordered">
            <tr>
                <th>Название:</th>
                <td><%= department.getName() %></td>
            </tr>
            <tr>
                <th>Компания:</th>
                <td><%= department.getCompany().getCompanyId() %></td>
            </tr>
        </table>
        <% } else { %>
        <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                <span onclick="this.parentElement.style.display='none'"
                      class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
            <h5>Департамент не найден!</h5>
        </div>
        <% } %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management/departments/all'">Вернуться к списку департаментов</button>
</div>
</body>
</html>
