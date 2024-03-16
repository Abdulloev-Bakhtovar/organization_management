<%@ page import="org.bakht.model.Company" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список компаний</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-grey w3-opacity w3-padding" style="display: flex; justify-content: space-between;">
    <h1>Супер приложение!</h1>
    <%-- Форма поиска по ID компании --%>
    <%--<form action="<%= request.getContextPath() %>/companies/details" method="get">
        <label for="companyId">Введите ID компании:</label>
        <input type="text" id="companyId" name="companyId">
        <button type="submit">Поиск</button>
    </form>--%>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Компании</h2>
        </div>
        <%
            List<Company> companies = (List<Company>) request.getAttribute("companies");

            if (companies != null && !companies.isEmpty()) {
        %>
        <table class="w3-table w3-bordered">
            <thead>
            <tr>
                <th>Название</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <% for (Company company : companies) { %>
            <tr>
                <td><%= company.getName() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/companies/update" method="GET">
                        <input type="hidden" name="companyId" value="<%= company.getCompanyId() %>">
                        <input type="submit" value="Изменить">
                    </form>
                </td>
                <td>
                    <form action="<%= request.getContextPath() %>/companies/delete" method="POST">
                        <input type="hidden" name="companyId" value="<%= company.getCompanyId() %>">
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
            <h5>Пока нет компаний!</h5>
        </div>
        <% } %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-padding" style="display: flex; justify-content: space-between;">
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management/companies/add'">Добавить компанию</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/organization_management'">Вернуться на главную</button>
</div>

</body>
</html>
