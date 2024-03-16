<%@ page import="org.bakht.model.Company" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление отдела</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Добавление отдела</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация о отделе</h2>
        </div>
        <% List<Company> companies = (List<Company>) request.getAttribute("companies"); %>
        <% if (companies != null && !companies.isEmpty()) { %>
        <form action="<%= request.getContextPath() %>/departments/add" method="POST">
            <input type="text" name="name" placeholder="Название">
            <select name="companyId">
                <% for (Company company : companies) { %>
                <option value="<%= company.getCompanyId() %>"><%= company.getName() %></option>
                <% } %>
            </select>
            <button type="submit">Добавить отдел</button>
        </form>
        <% } else { %>
        <p>Список компания пуст или отсутствует.</p>
        <% } %>
    </div>
</div>
</body>
</html>
