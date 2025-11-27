<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/jsp/header.jsp" />

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp" />
<div class="form-container">
    <h1>Редактировать книгу</h1>

        <div class="alert alert-error">
        </div>

    <form action="${pageContext.request.contextPath}/books/edit" method="post" class="book-form">
        <input type="hidden" name="id" value="${book.id}">

        <div class="form-group">
            <label for="title">Название книги:</label>
            <input type="text" id="title" name="title" value="${book.title}" required>
        </div>

        <div class="form-group">
            <label for="author">Автор:</label>
            <input type="text" id="author" name="author" value="${book.author}" required>
        </div>

        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="${book.isbn}">
        </div>

        <div class="form-group">
            <label for="publicationYear">Год издания:</label>
            <input type="number" id="publicationYear" name="publicationYear" value="${book.publicationYear}" required>
        </div>

        <div class="form-group">
            <label for="genre">Жанр:</label>
            <input type="text" id="genre" name="genre" value="${book.genre}" required>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Сохранить изменения</button>
            <a href="${pageContext.request.contextPath}/books" class="btn btn-secondary">Отмена</a>
        </div>
    </form>
</div>
</body>


