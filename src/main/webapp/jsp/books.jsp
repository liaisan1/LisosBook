<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp" />
<div class="page-header">
    <h1>Каталог книг</h1>
    <a href="${pageContext.request.contextPath}/book/new" class="btn btn-primary">Добавить книгу</a>
</div>

<div class="search-section">
    <form action="${pageContext.request.contextPath}/book/search" method="get" class="search-form">
        <input type="text" name="q" placeholder="Поиск книг..." value="${searchQuery}">
        <button type="submit" class="btn btn-secondary">Найти</button>
    </form>
</div>

<div class="books-grid">
        <div class="book-card">
            <h3></h3>
            <p class="book-author">Автор: </p>
            <p class="book-details">
            </p>

            <div class="book-actions">


                <div class="admin-actions">
                    <a href="${pageContext.request.contextPath}/book/edit?id=${book.id}" class="btn btn-warning btn-small">Редактировать</a>
                    <a href="${pageContext.request.contextPath}/book/delete?id=${book.id}"
                       class="btn btn-danger btn-small"
                       onclick="return confirm('Удалить эту книгу?')">Удалить</a>
                </div>
            </div>
        </div>
</div>
</body>

