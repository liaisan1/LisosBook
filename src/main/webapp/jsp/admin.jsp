<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Админ панель</title>
</head>
<body>

<h2>Администрирование книг</h2>

<!-- Вывод ошибок -->
<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight:bold;">
            ${errorMessage}
    </div>
    <br>
</c:if>

<!-- Форма добавления книги -->
<form action="${pageContext.request.contextPath}/admin" method="post">
    <h3>Добавить книгу</h3>

    <label>Название книги:</label><br>
    <input type="text" name="title" placeholder="Введите название" required><br><br>

    <label>Автор:</label><br>
    <input type="text" name="author" placeholder="Введите автора" required><br><br>

    <label>Год выпуска:</label><br>
    <input type="text" name="publicationYear" placeholder="Введите год" required><br><br>

    <label>Жанр:</label><br>
    <input type="text" name="genre" placeholder="Введите жанр" required><br><br>

    <button type="submit" name="action" value="addBook">Добавить книгу</button>
</form>

<hr><br>

<!-- Форма изменения книги -->
<form action="${pageContext.request.contextPath}/admin" method="post">
    <h3>Изменить книгу</h3>

    <label>Название книги:</label><br>
    <input type="text" name="title" placeholder="Введите название" required><br><br>

    <label>Автор:</label><br>
    <input type="text" name="author" placeholder="Введите автора" required><br><br>

    <label>Новый год выпуска:</label><br>
    <input type="text" name="publicationYear" placeholder="Введите новый год" required><br><br>

    <label>Новый жанр:</label><br>
    <input type="text" name="genre" placeholder="Введите новый жанр" required><br><br>

    <button type="submit" name="action" value="updateBook">Изменить книгу</button>
</form>

<hr><br>

<!-- Форма удаления книги -->
<form action="${pageContext.request.contextPath}/admin" method="post">
    <h3>Удалить книгу</h3>

    <label>Название книги:</label><br>
    <input type="text" name="title" placeholder="Введите название" required><br><br>

    <label>Автор:</label><br>
    <input type="text" name="author" placeholder="Введите автора" required><br><br>

    <button type="submit" name="action" value="deleteBook">Удалить книгу</button>
</form>

</body>
</html>
