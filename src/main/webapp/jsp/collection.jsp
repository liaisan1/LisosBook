<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp" />
<div class="page-header">
    <h1>Моя коллекция книг</h1>
    <a href="${pageContext.request.contextPath}/books" class="btn btn-primary">Все книги</a>
</div>

<div class="collection-grid">
        <div class="collection-card">
            <h3></h3>
<%--            <c:forEach var="book" items="${list}">--%>
<%--            <p class="book-author">Автор: </p>--%>
<%--            <p class="book-details">--%>
<%--                <strong>Год:${book.publicationYear}</strong> <br>--%>
<%--                <strong>Жанр:${book.genre}</strong> <br>--%>
<%--                <strong>Автор:${book.}</strong> <br>--%>
<%--                <strong>Название:${book.name}</strong>--%>
<%--            </p>--%>
<%--            </c:forEach>--%>

            <div class="collection-actions">
                <a href="${pageContext.request.contextPath}/collection/remove?bookId=${item.bookId}"
                   class="btn btn-danger btn-small"
                   onclick="return confirm('Удалить книгу из коллекции?')">Удалить из коллекции</a>
            </div>
        </div>
</div>

    <div class="empty-state">
        <p>Ваша коллекция пуста.</p>
        <a href="${pageContext.request.contextPath}/books" class="btn btn-primary">Добавить книги в коллекцию</a>
    </div>
</body>