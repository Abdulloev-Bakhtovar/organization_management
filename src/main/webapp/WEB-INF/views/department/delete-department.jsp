<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление отдела</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Удаление отдела</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Информация об отделе</h2>
        </div>
        <form action="<%= request.getContextPath() %>/departments/delete" method="POST">
            <input type="text" name="name" value="${department.name}">
            <input type="text" name="companyId" value="${department.companyId}">
            <input type="hidden" name="departmentId" value="${department.departmentId}">
            <button type="submit">Удалить</button>
        </form>
    </div>
</div>
</body>
</html>
