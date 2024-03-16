<%@ page import="org.bakht.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о компании</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Информация о компании</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о компании</h2>
        </div>
        <%
            Company company = (Company) request.getAttribute("company");
            if (company != null) {
        %>
        <table class="w3-table w3-bordered">
            <tr>
                <th>Название:</th>
                <td><%= company.getName() %></td>
            </tr>
        </table>
        <% } else { %>
        <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                <span onclick="this.parentElement.style.display='none'"
                      class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
            <h5>Компания не найдена!</h5>
        </div>
        <% } %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management/companies/all'">Вернуться к списку компаний</button>
</div>
</body>
</html>
