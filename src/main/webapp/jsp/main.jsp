<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>Главная</title>
</head>

<body>
<jsp:include page="/jsp/header.jsp" />

<div class="page-header">
    <h1>Добро пожаловать в LisosBook</h1>
    <p class="subtitle">Ваш личный каталог и коллекция книг</p>
</div>

<div class="main-actions">
    <a href="${pageContext.request.contextPath}/books" class="btn btn-primary btn-large">
        Перейти к каталогу книг
    </a>

    <a href="${pageContext.request.contextPath}/collection" class="btn btn-secondary btn-large">
        Моя коллекция
    </a>
</div>

<div class="info-section">
    <div class="info-card">
        <h2>Добавляйте книги</h2>
        <p>Создавайте собственный каталог, добавляйте новые книги и управляйте ими.</p>
    </div>

    <div class="info-card">
        <h2>Ищите и сортируйте</h2>
        <p>Удобный поиск поможет быстро находить нужные книги.</p>
    </div>

    <div class="info-card">
        <h2>Управляйте коллекцией</h2>
        <p>Отмечайте книги как добавленные в личную коллекцию с указанием состояния.</p>
    </div>
</div>

</body>