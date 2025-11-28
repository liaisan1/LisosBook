<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp" />

<div class="page-header">
    <h1>Моя коллекция книг</h1>
</div>
<div class="books-grid">
    <c:forEach var="book" items="${list}">
        <div class="book-card">
            <h3>${book.title}</h3>
            <p><strong>Автор:</strong> ${book.author}</p>
            <p><strong>Год:</strong> ${book.publicationYear}</p>
            <p><strong>Жанр:</strong> ${book.genre}</p>

            <form action="${pageContext.request.contextPath}/collection" method="post">
                <input type="hidden" name="bookId" value="${book.id}">
                <button type="submit" class="btn btn-danger btn-small"
                        onclick="return confirm('Удалить книгу из коллекции?')">
                    Удалить из коллекции
                </button>
            </form>
        </div>
    </c:forEach>
</div>

</body>
